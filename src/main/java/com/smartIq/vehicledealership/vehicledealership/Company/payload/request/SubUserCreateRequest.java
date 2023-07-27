package com.smartIq.vehicledealership.vehicledealership.Company.payload.request;

import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Şirketlerin alt kullanıcılarının oluşturulmasında kullanılan request DTO nesnesidir.
 *
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubUserCreateRequest {

    private String firstName;
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;

    private Role role;

    @AssertTrue
    public boolean isRoleValid(){
        if(this.role == Role.COMPANY_USER)
            return true;
        return false;
    }


}
