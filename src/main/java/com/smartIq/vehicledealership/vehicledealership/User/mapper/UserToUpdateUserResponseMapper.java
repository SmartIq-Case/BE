package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.UpdateUserResponse;
//TODO:Classlara Constructor ekle
public class UserToUpdateUserResponseMapper {
    public static UpdateUserResponse tDto(User user){
        return UpdateUserResponse.builder()
                .company(user.getCompany().getTitle())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
