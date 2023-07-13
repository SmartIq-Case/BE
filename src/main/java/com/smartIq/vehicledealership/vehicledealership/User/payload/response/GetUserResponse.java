package com.smartIq.vehicledealership.vehicledealership.User.payload.response;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserResponse {
    /**
     * Gerekliliğe göre gore id kısmı silinebilir
     */
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Company company;
}
