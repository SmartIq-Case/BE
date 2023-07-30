package com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.dto;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.enums.*;
import lombok.*;

import java.util.List;

/**
 * Yeni bir {@link Vehicle} oluşturmak için kullanılan request DTO nesnesidir.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCreateRequest {

    private VehicleStatus vehicleStatus;
    private String vehicleBrand;
    private String vehicleSerial;
    private String vehicleModel;
    private Integer vehicleYear;
    private VehicleFuelType vehicleFuelType;
    private VehicleConditionStatus vehicleConditionStatus;
    private Integer vehicleRange;
    private Short vehiclePowerHp;
    private VehicleColor vehicleColor;
    private Boolean vehicleGuarantee;
    private VehicleDamageType vehicleDamageType;

    private List<VehicleDamageCreateRequest> vehicleDamageCreateRequests;
}
