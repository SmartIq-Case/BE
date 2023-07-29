package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanySaveRequest;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;

import java.time.LocalDateTime;
//TODO:Company boş nesne mi dönüyor kontrol et
public class SaveCompanyRequestToCompany {

    public static Company toCompany(
            CompanySaveRequest saveCompanyRequest,
            User user
    ){
        return Company.builder()
                .title(saveCompanyRequest.getTitle())
                .status(Status.ACTIVE)
                .createdAt(LocalDateTime.now())
                .createdBy(user.getId())
                .build();



    }
}
