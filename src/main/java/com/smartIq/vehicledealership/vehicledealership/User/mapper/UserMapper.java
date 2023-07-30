package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SubUserCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Token;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UserRegisterRequest;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.UserAuthenticatedResponse;
import com.smartIq.vehicledealership.vehicledealership.common.util.PasswordEncoder;
import com.smartIq.vehicledealership.vehicledealership.common.util.TokenGenerator;

import java.time.LocalDateTime;

/**
 * UserAuth katmanındaki request ve response nesnelerinin mapleme işleminin yapıldığı sınıftır.
 */
public class UserMapper {

    public static User mapForSaving(
            UserRegisterRequest request,
            PasswordEncoder passwordEncoder
    ){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .token(Token.builder()
                        .tokenCode(TokenGenerator.generateToken())
                        .build())
                .build();
    }

    public static User mapForSubUserSaving(
            SubUserCreateRequest request,
            PasswordEncoder passwordEncoder,
            User creatorUser
    ){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .createdBy(creatorUser.getId())
                .company(creatorUser.getCompany())
                .token(Token.builder()
                        .tokenCode(TokenGenerator.generateToken())
                        .build())
                .build();
    }

    public static UserAuthenticatedResponse toAuthenticatedResponse(
            User user
    ){
        return UserAuthenticatedResponse.builder()
                .token(user.getToken().getTokenCode())
                .build();
    }

    public static UserAuthenticatedResponse toSubUserRegisteredResponse(
            User creatorUser,
            User createdSubUser
    ){
        return UserAuthenticatedResponse.builder()
                .token(createdSubUser.getToken().getTokenCode())
                .build();
    }

}
