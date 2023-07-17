package com.smartIq.vehicledealership.vehicledealership.User.payload.request;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

public class SaveUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long company;

}
