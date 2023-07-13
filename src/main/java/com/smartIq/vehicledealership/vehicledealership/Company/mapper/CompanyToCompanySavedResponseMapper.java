package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.GetCompanyResponse;

public class CompanyToCompanySavedResponseMapper {
    public static GetCompanyResponse toDto(Company company){
            return GetCompanyResponse.builder()
                    .title(company.getTitle())
                    .build();
    }
}
