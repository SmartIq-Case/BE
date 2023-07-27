package com.smartIq.vehicledealership.vehicledealership.Company.service;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.SaveCompanyRequestToCompany;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.UpdateCompanyRequestToCompany;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SaveCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.UpdateCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.repository.CompanyRepository;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.UserRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    /**
     * Bir kullanıcı bu isteği attığında kendisi User konumundan artık bir şirket sahibi konumuna geçer.
     * Rolü Company_Owner olarak güncellenir ve Company ile ilişkilendirilir.
     *
     * @param saveCompanyRequest
     * @return
     */
    public Company createCompany(
            SaveCompanyRequest saveCompanyRequest,
            User user
    ){
        if(companyRepository.existsByTitle(saveCompanyRequest.getTitle())){
           throw new RuntimeException("There is already a company with same title!");
        }

        final Company companyEntityToBeSave
                = SaveCompanyRequestToCompany.toCompany(saveCompanyRequest,user);

        final Company savedCompanyEntity = companyRepository.save(companyEntityToBeSave);

        user.setCompany(savedCompanyEntity);
        user.setRole(Role.COMPANY_OWNER);

        userRepository.save(user);

        return savedCompanyEntity;
    }


    /**
     * Yalnızca ADMIN seviyesinde rolü olan bir kullanıcı tarafından erişilebilen bir metoddur.
     * Projedeki tüm {@link Company} entity nesnelerini geriye döndürür.
     *
     * @return
     */
    public List<Company> getAllCompany(
    ){
        return companyRepository.findAll();
    }


    public Company getOneCompanyById(
            Long id
    ) {
        return companyRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Company not found:"+ id));
    }




    public Company updateCompanyById(Long id, UpdateCompanyRequest request) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Can't find a Company with given id: "+id));

        company.setTitle(request.getTitle());
        company.setStatus(request.getStatus());

        return companyRepository.save(company);

    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }
}
