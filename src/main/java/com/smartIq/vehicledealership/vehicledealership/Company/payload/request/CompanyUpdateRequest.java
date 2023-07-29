package com.smartIq.vehicledealership.vehicledealership.Company.payload.request;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.common.entity.enums.Status;
import lombok.*;

/**
 * Bir {@link Company} entity nesnesini güncellemek için kullanılan request DTO nesesidir.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUpdateRequest {
    private String title;
    private Status status;
}
