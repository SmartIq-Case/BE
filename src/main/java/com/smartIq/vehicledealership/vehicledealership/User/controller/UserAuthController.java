package com.smartIq.vehicledealership.vehicledealership.User.controller;

import com.smartIq.vehicledealership.vehicledealership.User.Service.UserAuthService;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UserRegisterRequest;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserAuthMapper;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.UserRegisteredResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kullanıcıların authentication, register, token işlemlerini yöneten controller sınıfıdır.
 *
 *
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthService userAuthService;

    // TODO : register endpoint.
    // TODO : authenticate endpoint.
    // TODO : logout endpoint.

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody UserRegisterRequest request
    ) {
        User user = userAuthService.register(request);
        UserRegisteredResponse response = UserAuthMapper.entityToResponse(user);

        return ResponseEntity.ok(response);

    }



}
