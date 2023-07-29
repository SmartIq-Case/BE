package com.smartIq.vehicledealership.vehicledealership.Company.payload.response;

import lombok.*;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGetResponse {
    private Long id;
    private String title;
}
