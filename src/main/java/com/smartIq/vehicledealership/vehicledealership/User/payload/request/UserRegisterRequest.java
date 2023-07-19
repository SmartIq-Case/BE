package com.smartIq.vehicledealership.vehicledealership.User.payload.request;

import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Yeni bir kullanıcı kaydı için kullanılan request DTO nesnesidir.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Role role;
}
