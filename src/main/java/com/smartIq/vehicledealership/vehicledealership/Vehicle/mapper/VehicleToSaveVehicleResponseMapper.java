package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.SaveVehicleResponse;

public class VehicleToSaveVehicleResponseMapper {
    public static SaveVehicleResponse toDto(Vehicle vehicle){
        return SaveVehicleResponse.builder()
                .year(vehicle.getYear())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .bodyType(vehicle.getBodyType())
                .transmissionType(vehicle.getTransmissionType())
                .fuelType(vehicle.getFuelType())
                .version(vehicle.getVersion())
                .km(vehicle.getKm())
                .price(vehicle.getPrice())
                .status(vehicle.getStatus())
                .companyname(vehicle.getCompany().getTitle())
                .build();


    }
}
