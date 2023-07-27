package com.smartIq.vehicledealership.vehicledealership.Company.controller;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyListToCompanyResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyToCompanySavedResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanyToUpdateCompanyResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SaveCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.UpdateCompanyRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.GetCompaniesResponse;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.GetCompanyResponse;
import com.smartIq.vehicledealership.vehicledealership.Company.service.CompanyService;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.TokenRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Token;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController{

    private final CompanyService companyService;
    private final TokenRepository tokenRepository;


    @GetMapping
    public ResponseEntity<GetCompaniesResponse> getAllCompany(
        //@RequestHeader("token") String token
    )
    {
        /*
        Token token = tokenRepository.findByToken(token);
        User user = token.getUser();
        if(user.getRole() == ADMIN ){

        }
         */
        List<Company> companies=companyService.getAllCompany();

        return ResponseEntity.ok(CompanyListToCompanyResponseMapper.toDto(companies));

    }


    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyResponse> getCompanyById(
            @PathVariable Long id
    ){
        Company company=companyService.getOneCompanyById(id);
        GetCompanyResponse getCompanyResponse= CompanyToCompanySavedResponseMapper.toDto(company);
        return ResponseEntity.ok(getCompanyResponse);


    }


    @PostMapping
    public ResponseEntity<?> createCompany(
            @RequestBody SaveCompanyRequest saveCompanyRequest
    ){
       Company company= companyService.createCompany(saveCompanyRequest);
       return ResponseEntity.ok(CompanyToCompanySavedResponseMapper.toDto(company));

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyRequest updateCompanyRequest){
       Company company= companyService.updateCompanyById(id,updateCompanyRequest);
        return ResponseEntity.ok(CompanyToUpdateCompanyResponseMapper.toDto(company));
    }


    @DeleteMapping("/{id}")
    public void deleteCompanyByid(@PathVariable Long id){
        companyService.deleteCompanyById(id);

    }


}
