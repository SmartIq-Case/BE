package com.smartIq.vehicledealership.vehicledealership.Company.controller;

import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SubUserCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.service.CompanySubUserService;
import com.smartIq.vehicledealership.vehicledealership.User.Service.UserAuthService;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserMapper;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UserRegisterRequest;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.UserRegisteredResponse;
import com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker.AuthorizationChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Bir şirketin yönetimini yapabilen alt kullanıcıların tanımlandığı rest controller sınıfıdır..
 */
@RestController
@RequestMapping("/api/v1/companies/subusers")
@RequiredArgsConstructor
public class CompanySubUserController {

    private final AuthorizationChecker authorizationChecker;
    private final CompanySubUserService companySubUserService;
    private final UserAuthService userAuthService;

    // TODO : Yeni bir subUser'in oluşturulduğu endpoint.

    /**
     * Şirket sahibi bir kullanıcının şirketine alt kullanıcı eklediği endpointtir.
     *
     *
     * @param tokenCode
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<UserRegisteredResponse> createSubUser(
            @RequestHeader("token") String tokenCode,
            @RequestBody SubUserCreateRequest request
    ) {
        final User requestOwner = authorizationChecker.authorize(tokenCode, Role.COMPANY_OWNER);

        final User registeredSubUser = userAuthService.createSubUser(request, requestOwner);
        final UserRegisteredResponse registeredSubUserResponse = UserMapper.entityToResponse(registeredSubUser);

        return ResponseEntity.ok(registeredSubUserResponse);
    }


}
