package com.smartIq.vehicledealership.vehicledealership.Company.controller;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyToCompanySavedResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyToUpdateCompanyResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanySaveRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanyUpdateRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.CompanyGetResponse;
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
    public ResponseEntity<CompanyGetResponse> createCompany(
            @RequestHeader("token") String tokenCode,
            @RequestBody CompanySaveRequest saveCompanyRequest
    ) {
        User user = authorizationChecker.authorize(tokenCode, Role.USER);
        final Company savedCompany = companyService.createCompany(saveCompanyRequest, user);
        final CompanyGetResponse response = CompanyMapper.toGetCompanyResponse(savedCompany);

        return ResponseEntity.ok(response);

    }


    @GetMapping
    public ResponseEntity<List<CompanyGetResponse>> getAllCompany(
            @RequestHeader("token") String tokenCode
    ) {

        authorizationChecker.authorize(tokenCode, Role.ADMIN);

        final List<Company> allCompaniesFromDb = companyService.getAllCompany();
        final List<CompanyGetResponse> companyGetResponses = CompanyMapper
                .toGetCompanyResponse(allCompaniesFromDb);

        return ResponseEntity.ok(companyGetResponses);
    }


    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CompanyGetResponse> getCompanyById(
            @PathVariable Long id,
            @RequestHeader("token") String tokenCode
    ) {
        authorizationChecker.authorize(tokenCode, Role.ADMIN, Role.USER, Role.COMPANY_OWNER);

        final Company company = companyService.getOneCompanyById(id);
        final CompanyGetResponse getCompanyResponse = CompanyMapper
                .toGetCompanyResponse(company);

        return ResponseEntity.ok(getCompanyResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(
            @PathVariable Long id,
            @RequestBody CompanyUpdateRequest updateCompanyRequest,
            @RequestHeader("token") String tokenCode
    ) {
        final User user = authorizationChecker.authorize(tokenCode,Role.ADMIN,Role.COMPANY_OWNER);

        final Company updatedCompany = companyService.updateCompanyById(id, updateCompanyRequest,user);
        final CompanyGetResponse response = CompanyMapper.toGetCompanyResponse(updatedCompany);

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public void deleteCompanyByid(
            @PathVariable("id") Long id,
            @RequestHeader("token") String tokenCode
    ) {
        final User user = authorizationChecker.authorize(tokenCode,Role.ADMIN,Role.COMPANY_OWNER);
        companyService.deleteCompanyById(id,user);

    }


}
