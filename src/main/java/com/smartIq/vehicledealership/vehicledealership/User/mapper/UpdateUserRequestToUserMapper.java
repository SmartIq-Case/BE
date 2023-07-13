package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UpdateUserRequest;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;

public class UpdateUserRequestToUserMapper {
    public static void toEntity(
            UpdateUserRequest updateUserRequest,
            User user
    ){
        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        user.setEmail(updateUserRequest.getEmail());
    }
}
