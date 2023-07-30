package com.smartIq.vehicledealership.vehicledealership.Vehicle.controller;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "vehicle_damage")
public class VehicleDamage extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "damage_title")
    private String damageTitle;

    @Column(name = "damage_Price")
    private BigDecimal damagePrice;

    @Column(name = "damage_Data")
    private LocalDateTime damageDate;

    @ManyToOne(
            fetch = FetchType.LAZY

    )
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;



}
