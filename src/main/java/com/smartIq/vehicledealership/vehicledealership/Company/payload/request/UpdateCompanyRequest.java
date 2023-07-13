package com.smartIq.vehicledealership.vehicledealership.Company.payload.request;

import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;
import lombok.Data;

@Data
public class UpdateCompanyRequest {


    private String title;
    private Status status;

}
