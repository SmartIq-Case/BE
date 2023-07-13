package com.smartIq.vehicledealership.vehicledealership.User.payload.request;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long company;

}
