package com.smartIq.vehicledealership.vehicledealership.Company.controller;

import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanySubUserMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanySubUserUpdateRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SubUserCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.CompanySubUserGetResponse;
import com.smartIq.vehicledealership.vehicledealership.Company.service.CompanySubUserService;
import com.smartIq.vehicledealership.vehicledealership.User.Service.UserAuthService;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserMapper;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.UserAuthenticatedResponse;
import com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker.AuthorizationChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Bir şirketin yönetimini yapabilen alt kullanıcıların tanımlandığı rest controller sınıfıdır..
 */
@RestController
@RequestMapping("/api/v1/companies/sub-users")
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
    public ResponseEntity<UserAuthenticatedResponse> createSubUser(
            @RequestHeader("token") String tokenCode,
            @RequestBody SubUserCreateRequest request
    ) {
        final User requestOwner = authorizationChecker.authorize(tokenCode, Role.COMPANY_OWNER);

        final User registeredSubUser = userAuthService.createSubUser(request, requestOwner);
        final UserAuthenticatedResponse registeredSubUserResponse = UserMapper.toAuthenticatedResponse(registeredSubUser);

        return ResponseEntity.ok(registeredSubUserResponse);
    }


    /**
     * İsteği yapan Company_OWNER yetkisine sahip kullanıcının hesabına bağlı tüm alt kullanıcıları döndüren endpoint.
     *
     * @param tokenCode
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CompanySubUserGetResponse>> getAllSubUsers(
            @RequestHeader("token") String tokenCode

    ){
        final User requestOwner =authorizationChecker.authorize(tokenCode, Role.COMPANY_OWNER);

        final List<User> subUsers = companySubUserService.getAllSubUsers(requestOwner);

        final List<CompanySubUserGetResponse> response = CompanySubUserMapper
                .toSubUserGetResponse(subUsers);

        return ResponseEntity.ok(response);

    }

    /**
     * ID Değeri belirtilen SubUser'e erişim için kullanılan endpoint.
     *
     */
    @GetMapping("/{subUserId}")
    public ResponseEntity<CompanySubUserGetResponse> getSubUserById(
        @RequestHeader("token") String tokenCode,
        @PathVariable("subUserId") Long subUserId
    ){
        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.COMPANY_OWNER);

        final User subUser = companySubUserService.getSubUserById(requestOwner,subUserId);
        final CompanySubUserGetResponse response = CompanySubUserMapper
            .toSubUserGetResponse(subUser);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{subUserId}")
    public ResponseEntity<CompanySubUserGetResponse> updateSubUserById(
            @RequestHeader("token") String tokenCode,
            @RequestBody CompanySubUserUpdateRequest request,
            @PathVariable("subUserId") Long subUserId
    ){
        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.COMPANY_OWNER);

        final User updatedSubUser = companySubUserService.updateSubUserById(requestOwner,subUserId,request);
        final CompanySubUserGetResponse response = CompanySubUserMapper.toSubUserGetResponse(updatedSubUser);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{subUserId}")
    public ResponseEntity<Void> deleteSubUserById(
            @RequestHeader("token") String tokenCode,
            @PathVariable("subUserId") Long subUserId
    ){
        final User requestOwner = authorizationChecker.authorize(tokenCode,Role.COMPANY_OWNER);

        companySubUserService.deleteSubUserById(subUserId,requestOwner);

        return ResponseEntity.ok(null);
    }



}
