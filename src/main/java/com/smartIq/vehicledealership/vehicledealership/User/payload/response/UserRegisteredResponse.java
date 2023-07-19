package com.smartIq.vehicledealership.vehicledealership.User.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bir user kayıt işleminden sonra kayıt edilen user'in bilgilerini gösteren response DTO nesnesidir.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisteredResponse {
    private Long id;
    private String token;
}
