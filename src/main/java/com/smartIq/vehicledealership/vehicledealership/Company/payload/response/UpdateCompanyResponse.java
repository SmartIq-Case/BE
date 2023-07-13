package com.smartIq.vehicledealership.vehicledealership.Company.payload.response;

import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class UpdateCompanyResponse {
    private String title;
    private Status status;

}
