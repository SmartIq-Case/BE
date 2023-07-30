package com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDamageCreateRequest {
    private String vehicleDamageTitle;
    private BigDecimal vehicleDamagePrice;
    private LocalDateTime vehicleDamageDate;
}
