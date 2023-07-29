package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.CompanyGetResponse;

import java.util.List;


public class CompanyListToCompanyResponseMapper {


    public static CompanyGetResponse toGetCompanyResponse(
            Company company
    ) {
        return CompanyGetResponse.builder()
                .title(company.getTitle())
                .build();
    }


    public static List<CompanyGetResponse> toGetCompanyResponse(
            List<Company> companies
    ){
        if(companies == null){
            return null;
        }

        return companies.stream()
                .map(CompanyListToCompanyResponseMapper::toGetCompanyResponse)
                .toList();
    }

}
