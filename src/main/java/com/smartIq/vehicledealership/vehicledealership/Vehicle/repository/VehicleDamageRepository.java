package com.smartIq.vehicledealership.vehicledealership.Vehicle.repository;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.controller.VehicleDamage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDamageRepository extends JpaRepository<VehicleDamage,Long> {
}
