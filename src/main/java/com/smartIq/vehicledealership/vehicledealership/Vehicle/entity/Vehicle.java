package com.smartIq.vehicledealership.vehicledealership.Vehicle.entity;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.enums.VehicleStatus;
import com.smartIq.vehicledealership.vehicledealership.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Table(name = "vehicle")

public class Vehicle extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer year;
    private String brand;
    private String model;
    private String bodyType;
    private String transmissionType;
    private String fuelType;
    private String version;
    private Integer km;
    private BigDecimal price;
    private VehicleStatus status;
    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;



    //TODO:DEALS,IMAGES,DAMAGES yazılacak
}
