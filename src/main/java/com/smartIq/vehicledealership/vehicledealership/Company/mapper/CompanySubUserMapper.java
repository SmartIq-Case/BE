package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanySubUserUpdateRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.CompanySubUserGetResponse;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * SubUser olarak kullanılan {@link User} entity nesneleri ile DTO nesneleri arasında
 * mapleme işlemlerini yürüten mapper sınıftır.
 *
 */
public class CompanySubUserMapper {

    public static CompanySubUserGetResponse toSubUserGetResponse(
            User subUser
    ){
        if (subUser == null)
            return null;

        return CompanySubUserGetResponse.builder()
                .id(subUser.getId())
                .firstname(subUser.getFirstName())
                .lastname(subUser.getLastName())
                .email(subUser.getEmail())
                .build();

    }

    public static List<CompanySubUserGetResponse> toSubUserGetResponse(
            List<User> subUsers
    ){
        if(subUsers == null)
            return null;

        return subUsers.stream()
                .filter(user -> user.getRole().equals(Role.COMPANY_USER))
                .map(CompanySubUserMapper::toSubUserGetResponse)
                .toList();
    }


    public static void mapForUpdating(
            User subUserToBeUpdate,
            User updatorUser,
            CompanySubUserUpdateRequest request
    ) {
        subUserToBeUpdate.setEmail(request.getEmail());
        subUserToBeUpdate.setFirstName(request.getFirstname());
        subUserToBeUpdate.setLastName(request.getLastname());

        subUserToBeUpdate.setUpdatedAt(LocalDateTime.now());
        subUserToBeUpdate.setUpdatedBy(updatorUser.getId());
    }
}
