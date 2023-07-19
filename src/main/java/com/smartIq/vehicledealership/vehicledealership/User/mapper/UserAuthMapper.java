package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.UserRegisteredResponse;

/**
 * UserAuth katmanındaki request ve response nesnelerinin mapleme işleminin yapıldığı sınıftır.
 */
public class UserAuthMapper {

    public static UserRegisteredResponse entityToResponse(
            User user
    ){
        return UserRegisteredResponse.builder()
                .id(user.getId())
                .token(user.getToken().getToken())
                .build();
    }

}
