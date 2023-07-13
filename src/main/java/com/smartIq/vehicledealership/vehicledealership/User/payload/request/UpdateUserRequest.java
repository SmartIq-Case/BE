package com.smartIq.vehicledealership.vehicledealership.User.payload.request;

import lombok.Data;

/**
 * password için yetkilendirmenin yapıldığı katmadna değitirilir
 */
@Data
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long company;

}
