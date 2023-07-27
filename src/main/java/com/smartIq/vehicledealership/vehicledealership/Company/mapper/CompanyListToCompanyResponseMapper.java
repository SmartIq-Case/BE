package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.GetCompanyResponse;

import java.util.List;


public class CompanyListToCompanyResponseMapper {


    public static GetCompanyResponse toGetCompanyResponse(
            Company company
    ) {
        return GetCompanyResponse.builder()
                .title(company.getTitle())
                .build();
    }


    public static List<GetCompanyResponse> toGetCompanyResponse(
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
