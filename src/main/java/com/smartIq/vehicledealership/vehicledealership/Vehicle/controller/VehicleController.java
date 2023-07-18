package com.smartIq.vehicledealership.vehicledealership.Vehicle.controller;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper.VehicleToSaveVehicleResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper.VehicleToUpdateVehicleResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper.VehicleToVehicleReponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper.VehiclesToAllVehiclesResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request.SaveVehicleRequest;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request.UpdateVehicleRequest;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.GetAllVehiclesResponse;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.GetVehicleResponse;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.SaveVehicleResponse;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.response.UpdateVehicleResponse;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;
    @GetMapping
    public ResponseEntity<?> getAllVehicles(){
       List<GetVehicleResponse> list= VehiclesToAllVehiclesResponseMapper.toDto( vehicleService.getAllVehicle());
        return ResponseEntity.ok(list);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneVehicle(@PathVariable Long id){
        GetVehicleResponse getVehicleResponse= VehicleToVehicleReponseMapper.toDto(vehicleService.getOneVehicleById(id));
        return ResponseEntity.ok(getVehicleResponse);

    }
    @PostMapping
    public ResponseEntity<?> savedVehicle(@RequestBody SaveVehicleRequest saveVehicleRequest){
        SaveVehicleResponse vehicle=VehicleToSaveVehicleResponseMapper.toDto(vehicleService.createVehicle(saveVehicleRequest));
        return ResponseEntity.ok(vehicle);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id,@RequestBody UpdateVehicleRequest updateVehicleRequest){
        UpdateVehicleResponse updateVehicleResponse= VehicleToUpdateVehicleResponseMapper.toDto(vehicleService.updateOneVehicle(id,updateVehicleRequest));
        return ResponseEntity.ok(updateVehicleResponse);

    }
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);

    }


}
