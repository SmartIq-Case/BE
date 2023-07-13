package com.smartIq.vehicledealership.vehicledealership.Company.mapper;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.GetCompaniesResponse;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.response.GetCompanyResponse;

import java.util.ArrayList;
import java.util.List;


public class CompanyListToCompanyResponseMapper {
    public static GetCompaniesResponse toDto(List<Company> companies){
        List<GetCompanyResponse> list =new ArrayList<>();
        for (Company com:companies) {
            list.add(CompanyToCompanySavedResponseMapper.toDto(com));

        }
        return GetCompaniesResponse.builder()
                .companies(list)
                .build();





    }

}
