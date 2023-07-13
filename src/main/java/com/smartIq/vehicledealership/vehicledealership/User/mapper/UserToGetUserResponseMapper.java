package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.GetUserResponse;

public class UserToGetUserResponseMapper {
    public static GetUserResponse toDto(User user){
        return GetUserResponse.builder()
                .email(user.getEmail())
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .id(user.getId())
                .company(user.getCompany())
                .build();
    }
}
