package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanyUpdateRequest;

public class UpdateCompanyRequestToCompany {
    public static Company toCompany(CompanyUpdateRequest request, Long id){
        return Company.builder()
                .id(id)
                .title(request.getTitle())
                .status(request.getStatus())
                .build();

    }
}
