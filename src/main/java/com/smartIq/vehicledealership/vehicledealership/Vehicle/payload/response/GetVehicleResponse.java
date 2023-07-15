package com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.enums.VehicleStatus;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
@Builder
public class GetVehicleResponse {

    private Integer year;
    private String brand;
    private String model;
    private String bodyType;
    private String transmissionType;
    private String fuelType;
    private String version;
    private Integer km;
    private BigDecimal price;
    private VehicleStatus status;


}
