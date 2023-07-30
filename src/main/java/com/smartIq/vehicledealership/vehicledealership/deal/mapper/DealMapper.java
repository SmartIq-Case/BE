package com.smartIq.vehicledealership.vehicledealership.deal.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.deal.model.dto.DealCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.deal.model.dto.response.DealGetResponse;
import com.smartIq.vehicledealership.vehicledealership.deal.model.entity.Deal;
import com.smartIq.vehicledealership.vehicledealership.deal.model.enums.OwnerType;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * {@link Deal} entity nesneleri ile DTO nesneleri arasındaki mapleme işlemlerini yürüten
 * mapper sınıftır.
 */
public class DealMapper {

    public static Deal mapForSaving(
            @NonNull  DealCreateRequest request,
            @NonNull User user
    ){
        return Deal.builder()
                .ownerType(
                        user.getRole().equals(Role.USER) ? OwnerType.INDIVIDUAL : OwnerType.CORPORATE
                )
                .ownerId(user.getId())
                .dealTitle(request.getDealTitle())
                .dealPrice(request.getDealPrice())
                .dealStatus(request.getDealStatus())
                .dealAddress(request.getDealAddress())
                .dealDetails(request.getDealDetails())
                .dealDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy(user.getId())
                .build();
    }

    public static DealGetResponse toGetResponse(
        @NonNull Deal deal
    ){
        return DealGetResponse.builder()
                .id(deal.getId())
                .ownerType(deal.getOwnerType())
                .ownerId(deal.getOwnerId())
                .dealTitle(deal.getDealTitle())
                .dealPrice(deal.getDealPrice())
                .dealStatus(deal.getDealStatus())
                .dealAddress(deal.getDealAddress())
                .dealDetails(deal.getDealDetails())
                .dealDate(deal.getDealDate())
                .vehicleId(deal.getVehicle().getId())
                .build();
    }


}
