package com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaveVehicleRequest {
    private Integer year;
    private String brand;
    private String model;
    private String bodyType;
    private String transmissionType;
    private String fuelType;
    private String version;
    private Integer km;
    private BigDecimal price;
    private Long company;


}
