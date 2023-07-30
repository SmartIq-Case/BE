package com.smartIq.vehicledealership.vehicledealership.deal.service;

import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper.VehicleMapper;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.repository.VehicleRepository;
import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;
import com.smartIq.vehicledealership.vehicledealership.deal.mapper.DealMapper;
import com.smartIq.vehicledealership.vehicledealership.deal.model.dto.DealCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.deal.model.entity.Deal;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.DealStatus;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.OwnerType;
import com.smartIq.vehicledealership.vehicledealership.deal.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Yalnızca Deal oluşturmaktan sorumlu olan servis sınıfıdır.
 */
@Service
@RequiredArgsConstructor
public class DealCreateService {

    private final DealRepository dealRepository;
    private final VehicleRepository vehicleRepository;


    public Deal createDeal(
            User requestOwner,
            DealCreateRequest request
    ) {
        OwnerType ownerType = canCreateDeal(requestOwner);

        Deal dealEntityToBeCreate = DealMapper.mapForSaving(request,requestOwner);

        Vehicle vehicleEntityToBeRelate = null;


        if(request.getVehicleId()!=null) {
            vehicleEntityToBeRelate = vehicleRepository
                    .findById(request.getVehicleId())
                    .orElseThrow(() -> new RuntimeException("Böyle bir aracınız bulunmuyor!"));

            if (!vehicleEntityToBeRelate.getVehicleOwnerType().equals(ownerType)) {
                throw new RuntimeException("Böyle bir aracınız bulunmuyor!");
            }

            if (vehicleEntityToBeRelate.getDeal() != null) {
                throw new RuntimeException("Bu araç başka bir ilanda zaten yayınlanıyor.");
            }

            dealEntityToBeCreate.setVehicle(vehicleEntityToBeRelate);
            vehicleEntityToBeRelate.setDeal(dealEntityToBeCreate);
        }
        else if(request.getVehicleCreateRequest() !=null){
            vehicleEntityToBeRelate = VehicleMapper
                    .mapForSaving(request.getVehicleCreateRequest(),requestOwner);

            dealEntityToBeCreate.setVehicle(vehicleEntityToBeRelate);
            vehicleEntityToBeRelate.setDeal(dealEntityToBeCreate);
        }
        else{
            throw new RuntimeException("Hiç bir araç olmaksızın ilan oluşturamazsınız.");
        }

        return dealRepository.save(dealEntityToBeCreate);
    }

    /**
     * Parametre olarak verilen User'in Deal oluşturup oluşturamayacağını kontrol eder.
     *
     * Bunu yaparken bazı kurallar uygular.
     * <list>
     *     <li>
     *         USER rolüne sahip bir kullanıcının yalnızca bir tane aktif ilanı olabilir.
     *         Eğer ikinci bir aktif ilan oluşturmaya kalkarsa hata fırlatır.
     *     </li>
     *     <li>
     *         COMPANY altında bulunan COMPANY_OWNER veya COMPANY_USER rolüne sahip bir kullanıcı
     *         dilediği kadar ilan oluşturabilir.
     *         Fakat bağlı bulundukları Company aktif durumda olmalıdır.
     *     </li>
     * </list>
     * @param user
     */
    private OwnerType canCreateDeal(
            User user
    ){
        OwnerType ownerType = null;
        if(user.getRole().equals(Role.USER)){
            if(dealRepository
                    .existsDealByOwnerIdAndOwnerTypeAndDealStatus
                            (user.getId(), OwnerType.INDIVIDUAL, DealStatus.ACTIVE)){
                throw new RuntimeException("Zaten mevcutta aktif bir ilanınız var," +
                        " ikincisini oluşturamazsınız.");
            }
            ownerType = OwnerType.INDIVIDUAL;

        }

        else if(user.getRole().equals(Role.COMPANY_OWNER)||user.getRole().equals(Role.COMPANY_USER)){
            if (!user.getCompany().getCompanyStatus().equals(Status.ACTIVE)){
                throw new RuntimeException("Şirketinizin durumu aktif değildir, bu sebeple ilan oluşturamazsınız.");
            }
            ownerType = OwnerType.CORPORATE;
        }

        return ownerType;
    }
}
