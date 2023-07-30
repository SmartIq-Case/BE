package com.smartIq.vehicledealership.vehicledealership.deal.model.entity;

import com.smartIq.vehicledealership.vehicledealership.Vehicle.entity.Vehicle;
import com.smartIq.vehicledealership.vehicledealership.common.entity.BaseEntity;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.DealStatus;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.OwnerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "deal")
public class Deal extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Enumerated(EnumType.STRING)
    private OwnerType ownerType;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "deal_title")
    private String dealTitle;

    @Column(name = "deal_price")
    private BigDecimal dealPrice;

    @Enumerated(EnumType.STRING)
    private DealStatus dealStatus;

    @Column(name = "deal_address")
    private String dealAddress;

    @Column(name = "deal_details",length = 500)
    private String dealDetails;

    @Column(name = "deal_date")
    private LocalDateTime dealDate;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST
            }
    )
    @JoinColumn(name = "vehicle_id",referencedColumnName = "id")
    private Vehicle vehicle;



}
