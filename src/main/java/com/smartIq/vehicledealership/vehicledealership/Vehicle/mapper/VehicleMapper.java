package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.dto.VehicleCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.OwnerType;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * Vehicle Entity nesneleri ile DTO nesneleri arasında mapleme işlemlerini yürüten
 * mapper sınıftır.
 *
 */
public class VehicleMapper {

    public static Vehicle mapForSaving(
            @NonNull VehicleCreateRequest request,
            @NonNull User user
    ){

        Vehicle vehicleForSave = Vehicle.builder()
                .vehicleOwnerType(
                        user.getRole().equals(Role.USER) ? OwnerType.INDIVIDUAL : OwnerType.CORPORATE
                )
                .ownerId(user.getId())
                .vehicleStatus(request.getVehicleStatus())
                .vehicleBrand(request.getVehicleBrand())
                .vehicleYear(request.getVehicleYear())
                .vehicleColor(request.getVehicleColor())
                .vehicleModel(request.getVehicleModel())
                .fuelType(request.getVehicleFuelType())
                .vehicleSerial(request.getVehicleSerial())
                .vehicleRange(request.getVehicleRange())
                .vehiclePowerHP(request.getVehiclePowerHp())
                .vehicleGuarantee(request.getVehicleGuarantee())
                .vehicleConditionStatus(request.getVehicleConditionStatus())
                .vehicleDamageType(request.getVehicleDamageType())

                .createdAt(LocalDateTime.now())
                .createdBy(user.getId())

                .build();

        if(request.getVehicleDamageCreateRequests() != null){
            vehicleForSave.setVehicleDamages(
                    request.getVehicleDamageCreateRequests().stream()
                            .map(vehicleDamageCreateReq -> VehicleDamageMapper
                                    .mapForSaving(vehicleDamageCreateReq,user))
                            .toList()
            );
        }

        return vehicleForSave;
    }


}
