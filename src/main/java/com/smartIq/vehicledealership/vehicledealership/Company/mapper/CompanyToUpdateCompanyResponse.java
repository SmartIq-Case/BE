package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.UpdateCompanyResponse;

public class CompanyToUpdateCompanyResponse {
    public static UpdateCompanyResponse toDto(Company company){
        return UpdateCompanyResponse.builder()
                .title(company.getTitle())
                .status(company.getStatus())
                .build();
    }
}
