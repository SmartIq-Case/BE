package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.GetVehicleResponse;

public class VehicleToVehicleReponseMapper {
    public static GetVehicleResponse toDto(Vehicle vehicle){
        return GetVehicleResponse.builder()
                .year(vehicle.getYear())
                .brand(vehicle.getBrand())
                .model(vehicle.getModel())
                .bodyType(vehicle.getBodyType())
                .transmissionType(vehicle.getTransmissionType())
                .fuelType(vehicle.getFuelType())
                .version(vehicle.getVersion())
                .price(vehicle.getPrice())
                .status(vehicle.getStatus())
                .build();

    }
}
