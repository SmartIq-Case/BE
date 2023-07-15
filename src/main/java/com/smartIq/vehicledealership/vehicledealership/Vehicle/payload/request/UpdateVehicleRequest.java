package com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.enums.VehicleStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class UpdateVehicleRequest {
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
    private Long Company;
}
