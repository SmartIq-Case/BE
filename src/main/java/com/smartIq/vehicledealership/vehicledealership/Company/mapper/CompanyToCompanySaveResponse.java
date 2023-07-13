package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.CompanySaveResponse;

public class CompanyToCompanySaveResponse {
    public static CompanySaveResponse toDto(Company company){
        return CompanySaveResponse.builder()
                .title(company.getTitle())
                .status(company.getStatus())
                .build();

    }
}
