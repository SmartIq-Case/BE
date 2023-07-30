package com.smartIq.vehicledealership.vehicledealership.Vehicle.entity;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.enums.*;
import com.smartIq.vehicledealership.vehicledealership.Vehicle.controller.VehicleDamage;
import com.smartIq.vehicledealership.vehicledealership.common.entity.BaseEntity;
import com.smartIq.vehicledealership.vehicledealership.deal.model.entity.Deal;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.OwnerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OwnerType vehicleOwnerType;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "status")
    private VehicleStatus vehicleStatus;

    @Column(name = "brand")
    private String vehicleBrand;

    @Column(name = "year")
    private Integer vehicleYear;

    @Enumerated(EnumType.STRING)
    private VehicleColor vehicleColor;

    @Column(name = "model")
    private String vehicleModel;

    @Enumerated(EnumType.STRING)
    private VehicleFuelType fuelType;

    @Column(name = "version")
    private String vehicleSerial;

    @Column(name = "vehicle_range")
    private Integer vehicleRange;

    @Column(name = "vehicle_power_hp")
    private Short vehiclePowerHP;

    @Column(name = "vehicle_guarantee")
    private Boolean vehicleGuarantee;

    @Enumerated(EnumType.STRING)
    private VehicleConditionStatus vehicleConditionStatus;

    @Enumerated(EnumType.STRING)
    private VehicleDamageType vehicleDamageType;



    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "vehicle",
            cascade = {
                    CascadeType.PERSIST
            }
    )
    private List<VehicleDamage> vehicleDamages;

    @OneToOne(
            fetch = FetchType.LAZY,
            mappedBy = "vehicle"
    )
    private Deal deal;


    //TODO: IMAGES yazılacak
}
