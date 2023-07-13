package com.smartIq.vehicledealership.vehicledealership.Company.payload.response;

import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
public class GetCompaniesResponse {
    private List<GetCompanyResponse> companies;
}
