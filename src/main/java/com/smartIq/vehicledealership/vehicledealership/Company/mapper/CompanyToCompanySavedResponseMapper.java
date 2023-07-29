package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.CompanyGetResponse;

public class CompanyToCompanySavedResponseMapper {
    public static CompanyGetResponse toDto(Company company){
            return CompanyGetResponse.builder()
                    .title(company.getTitle())
                    .build();
    }
}
