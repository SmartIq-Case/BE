package com.smartIq.vehicledealership.vehicledealership.User.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bir kullanıcının email ve şifre gönderdiği bunun sonucunda
 * authenticate sürecinin başlatıldığı request DTO nesnesidir.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticateRequest {
    private String email;
    private String password;
}
