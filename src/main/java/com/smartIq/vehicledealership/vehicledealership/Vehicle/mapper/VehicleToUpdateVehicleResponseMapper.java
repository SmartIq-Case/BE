package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.UpdateVehicleResponse;

public class VehicleToUpdateVehicleResponseMapper {
    public static UpdateVehicleResponse toDto(Vehicle vehicle){
        return UpdateVehicleResponse.builder()
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
                .companyName(vehicle.getCompany().getTitle())
                .build();

    }
}
