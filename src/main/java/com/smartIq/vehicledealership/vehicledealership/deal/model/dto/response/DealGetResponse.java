package com.smartIq.vehicledealership.vehicledealership.deal.model.dto.response;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.DealStatus;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.OwnerType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DealGetResponse {

    private Long id;
    private OwnerType ownerType;
    private Long ownerId;
    private String dealTitle;
    private BigDecimal dealPrice;
    private DealStatus dealStatus;
    private String dealAddress;
    private String dealDetails;
    private LocalDateTime dealDate;
    private Long vehicleId;

}
