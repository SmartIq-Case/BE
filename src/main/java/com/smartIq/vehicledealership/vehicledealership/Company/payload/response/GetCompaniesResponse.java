package com.smartIq.vehicledealership.vehicledealership.Company.payload.response;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Getter
@SuperBuilder
public class GetCompaniesResponse {
    private List<GetCompanyResponse> companies;
}
