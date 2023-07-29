package com.smartIq.vehicledealership.vehicledealership.Company.payload.request;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import lombok.*;

/**
 * Yeni bir {@link Company} entity nesnesi oluşturmak için gelen request DTO nesnesidir.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanySaveRequest {
      private String title;
}
