package com.smartIq.vehicledealership.vehicledealership.deal.model.dto;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.dto.VehicleCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.deal.model.entity.Deal;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.DealStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * Yeni bir {@link Deal} oluşturmak için kullanılan request DTO nesnesidir.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DealCreateRequest {

    private String dealTitle;
    private BigDecimal dealPrice;
    private String dealAddress;
    private String dealDetails;
    private DealStatus dealStatus;

    private Long vehicleId;
    private VehicleCreateRequest vehicleCreateRequest;

}
