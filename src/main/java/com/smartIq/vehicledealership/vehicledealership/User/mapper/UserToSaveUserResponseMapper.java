package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.SaveUserResponse;

public class UserToSaveUserResponseMapper {
    public static SaveUserResponse toDto(User user){
            return SaveUserResponse.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .build();

    }
}
