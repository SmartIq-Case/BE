package com.smartIq.vehicledealership.vehicledealership.Company.payload.request;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SubUser olarak kullanılan bir {@link Company} entity nesnesine bağlı olan {@link User} entity nesnesini
 * güncellemek için kullanılan request DTO nesnesidir.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanySubUserUpdateRequest {
    private String firstname;
    private String lastname;
    private String email;
}
