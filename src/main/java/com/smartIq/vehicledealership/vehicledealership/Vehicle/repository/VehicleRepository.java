package com.smartIq.vehicledealership.vehicledealership.Vehicle.repository;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}
