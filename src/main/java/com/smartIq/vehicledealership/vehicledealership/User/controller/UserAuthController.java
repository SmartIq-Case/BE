package com.smartIq.vehicledealership.vehicledealership.User.controller;

import com.smartIq.vehicledealership.vehicledealership.User.Service.UserAuthService;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UserAuthenticateRequest;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UserRegisterRequest;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserMapper;
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


    /**
     * Bir kullanıcının sisteme kayıt olduğu endpoint.
     *
     * @param request
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody UserRegisterRequest request
    ) {

        UserRegisteredResponse response = UserMapper.entityToResponse(userAuthService.register(request));

        return ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(
            @RequestBody UserAuthenticateRequest request
            ){
       return ResponseEntity.ok(userAuthService.authenticate(request)) ;

    }
    @PostMapping("/logout")
    public void logout(@RequestBody UserAuthenticateRequest request){

        userAuthService.logout(request);


    }



}
