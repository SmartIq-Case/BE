package com.smartIq.vehicledealership.vehicledealership.Company.payload.response;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import lombok.*;

/**
 * SubUser olarak kullanılan {@link User} entity nesnelerinin varsayılan response yapısıdır.
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanySubUserGetResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
