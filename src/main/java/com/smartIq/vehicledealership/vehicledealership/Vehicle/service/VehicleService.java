package com.smartIq.vehicledealership.vehicledealership.Vehicle.service;

import com.smartIq.vehicledealership.vehicledealership.Company.service.CompanyService;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.enums.VehicleStatus;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper.SaveVehicleRequestToVehicleMapper;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.mapper.VehicleUpdateRequestToVehicle;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request.SaveVehicleRequest;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.payload.request.UpdateVehicleRequest;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CompanyService companyService;

    public List<Vehicle> getAllVehicle() {

        return vehicleRepository.findAll();
    }

    public Vehicle getOneVehicleById(Long id) {

        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle cant found By given id:" + id));

    }

    public Vehicle createVehicle(SaveVehicleRequest saveVehicleRequest) {

        Vehicle vehicle = new Vehicle();
        SaveVehicleRequestToVehicleMapper.toDto(saveVehicleRequest, vehicle);
        vehicle.setCompany(companyService.getOneCompanyById(saveVehicleRequest.getCompany()));
        vehicle.setStatus(VehicleStatus.ON_SALE);


        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateOneVehicle(Long id, UpdateVehicleRequest updateVehicleRequest) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cant find vehicle by Given id:" + id));
        VehicleUpdateRequestToVehicle.toDto(vehicle, updateVehicleRequest);
        vehicle.setCompany(companyService.getOneCompanyById(updateVehicleRequest.getCompany()));
        return vehicleRepository.save(vehicle);


    }

    public void deleteVehicle(Long id) {

        vehicleRepository.deleteById(id);
    }
}
