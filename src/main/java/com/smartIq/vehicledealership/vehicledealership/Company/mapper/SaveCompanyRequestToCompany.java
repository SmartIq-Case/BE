package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SaveCompanyRequest;

import java.time.LocalDateTime;
//TODO:Company boş nesne mi dönüyor kontrol et
public class SaveCompanyRequestToCompany {
    public static Company toCompany(SaveCompanyRequest saveCompanyRequest){
        return Company.builder()
                .title(saveCompanyRequest.getTitle())
                .createdAt(LocalDateTime.now())
                .createdBy(null)
                .updatedAt(null)
                .updatedBy(null)
                .build();



    }
}
