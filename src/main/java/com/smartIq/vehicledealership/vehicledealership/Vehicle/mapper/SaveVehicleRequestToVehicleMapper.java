package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request.SaveVehicleRequest;

import java.time.LocalDateTime;

public class SaveVehicleRequestToVehicleMapper {
    public static void toDto(SaveVehicleRequest saveVehicleRequest,Vehicle vehicle){
        vehicle.setYear(saveVehicleRequest.getYear());
        vehicle.setBrand(saveVehicleRequest.getBrand());
        vehicle.setModel(saveVehicleRequest.getModel());
        vehicle.setBodyType(saveVehicleRequest.getBodyType());
        vehicle.setTransmissionType(saveVehicleRequest.getTransmissionType());
        vehicle.setFuelType(saveVehicleRequest.getFuelType());
        vehicle.setVersion(saveVehicleRequest.getVersion());
        vehicle.setKm(saveVehicleRequest.getKm());
        vehicle.setPrice(saveVehicleRequest.getPrice());
        vehicle.setCreatedAt(LocalDateTime.now());
        vehicle.setUpdatedAt(null);
        vehicle.setCreatedBy(null);
        vehicle.setUpdatedBy(null);


        //TODO:Createdby eklenecek


    }
}
