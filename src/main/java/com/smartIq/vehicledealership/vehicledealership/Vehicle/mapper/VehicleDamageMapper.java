package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.controller.VehicleDamage;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.dto.VehicleDamageCreateRequest;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * {@link VehicleDamage} nesneleri ile DTO nesneleri arasında mapleme işlemlerini
 * yöneten mapper sınıftır.
 */
public class VehicleDamageMapper {

    public static VehicleDamage mapForSaving(
            @NonNull VehicleDamageCreateRequest request,
            @NonNull User user
    ){
        return VehicleDamage.builder()
                .damageTitle(request.getVehicleDamageTitle())
                .damagePrice(request.getVehicleDamagePrice())
                .damageDate(request.getVehicleDamageDate())
                .createdAt(LocalDateTime.now())
                .createdBy(user.getId())
                .build();
    }
}
