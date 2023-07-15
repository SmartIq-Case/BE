package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request.UpdateVehicleRequest;

import java.time.LocalDateTime;

public class VehicleUpdateRequestToVehicle {
    public static void toDto(Vehicle vehicle, UpdateVehicleRequest updateVehicleRequest){
        vehicle.setYear(updateVehicleRequest.getYear());
        vehicle.setBrand(updateVehicleRequest.getBrand());
        vehicle.setModel(updateVehicleRequest.getModel());
        vehicle.setBodyType(updateVehicleRequest.getBodyType());
        vehicle.setTransmissionType(updateVehicleRequest.getTransmissionType());
        vehicle.setFuelType(updateVehicleRequest.getFuelType());
        vehicle.setVersion(updateVehicleRequest.getVersion());
        vehicle.setKm(updateVehicleRequest.getKm());
        vehicle.setPrice(updateVehicleRequest.getPrice());
        vehicle.setStatus(updateVehicleRequest.getStatus());
        vehicle.setCreatedBy(null);
        vehicle.setUpdatedBy(null);
        vehicle.setUpdatedAt(LocalDateTime.now());
        vehicle.setCreatedAt(null);

        //TODO:updated by ekle

    }
}
