package com.smartIq.vehicledealership.vehicledealership.Company.controller;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyListToCompanyResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyToCompanySavedResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyToUpdateCompanyResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SaveCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.UpdateCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.GetCompanyResponse;
import com.smartIq.vehicledealership.vehicledealership.Company.service.CompanyService;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker.AuthorizationChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;
    private final AuthorizationChecker authorizationChecker;


    /**
     * @param tokenCode
     * @param saveCompanyRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<?> createCompany(
            @RequestHeader("token") String tokenCode,
            @RequestBody SaveCompanyRequest saveCompanyRequest
    ) {
        User user = authorizationChecker.authorize(tokenCode, Role.USER);
        final Company company = companyService.createCompany(saveCompanyRequest, user);

        return ResponseEntity.ok(CompanyToCompanySavedResponseMapper.toDto(company));

    }


    @GetMapping
    public ResponseEntity<List<GetCompanyResponse>> getAllCompany(
            @RequestHeader("token") String tokenCode
    ) {

        authorizationChecker.authorize(tokenCode, Role.ADMIN);

        final List<Company> allCompaniesFromDb = companyService.getAllCompany();
        final List<GetCompanyResponse> companyGetResponses = CompanyListToCompanyResponseMapper
                .toGetCompanyResponse(allCompaniesFromDb);

        return ResponseEntity.ok(companyGetResponses);

    }


    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponse> getCompanyById(
            @PathVariable Long id,
            @RequestHeader("token") String tokenCode
    ) {
        authorizationChecker.authorize(tokenCode, Role.ADMIN, Role.USER, Role.COMPANY_OWNER);
        final Company company = companyService.getOneCompanyById(id);
        final GetCompanyResponse getCompanyResponse = CompanyToCompanySavedResponseMapper.toDto(company);
        return ResponseEntity.ok(getCompanyResponse);


    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(
            @PathVariable Long id,
            @RequestBody UpdateCompanyRequest updateCompanyRequest,
            @RequestHeader("token") String tokenCode
    ) {
        authorizationChecker.authorize(tokenCode,Role.ADMIN,Role.COMPANY_OWNER);
        Company company = companyService.updateCompanyById(id, updateCompanyRequest);
        return ResponseEntity.ok(CompanyToUpdateCompanyResponseMapper.toDto(company));
    }


    @DeleteMapping("/{id}")

    public void deleteCompanyByid(
            @PathVariable Long id,
            @RequestHeader("token") String tokenCode
    ) {
        authorizationChecker.authorize(tokenCode,Role.ADMIN,Role.COMPANY_OWNER);
        companyService.deleteCompanyById(id);

    }


}
