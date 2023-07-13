package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.UpdateCompanyRequest;

public class UpdateCompanyRequestToCompany {
    public static Company toCompany(UpdateCompanyRequest request,Long id){
        return Company.builder()
                .id(id)
                .title(request.getTitle())
                .status(request.getStatus())
                .build();

    }
}
