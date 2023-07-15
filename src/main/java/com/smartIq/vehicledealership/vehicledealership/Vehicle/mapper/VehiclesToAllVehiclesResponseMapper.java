package com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.GetVehicleResponse;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class VehiclesToAllVehiclesResponseMapper {
    public static List<GetVehicleResponse> toDto(List<Vehicle> vehicles){

        List<GetVehicleResponse> vec= new ArrayList<>();
        for(Vehicle vehicle:vehicles){
            vec.add(VehicleToVehicleReponseMapper.toDto(vehicle));
        }
        return vec;
    }
}
