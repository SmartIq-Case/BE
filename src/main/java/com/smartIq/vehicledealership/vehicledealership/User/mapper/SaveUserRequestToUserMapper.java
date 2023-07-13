package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.SaveUserRequest;

public class SaveUserRequestToUserMapper {
    public static void toEntity(SaveUserRequest saveUserRequest,User user){

        user.setFirstName(saveUserRequest.getFirstName());
        user.setLastName(saveUserRequest.getLastName());
        user.setEmail(saveUserRequest.getEmail());
        user.setPassword(saveUserRequest.getPassword());
    }

}
