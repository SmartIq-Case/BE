package com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker;


import com.smartIq.vehicledealership.vehicledealership.User.Repository.TokenRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Token;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorizationChecker {

    private final TokenRepository tokenRepository;


    public  User authorize(
            String tokenCode,
            Role... roles
    ){

        Token token = tokenRepository.findTokenByTokenCode(tokenCode)
                .orElseThrow(()->new RuntimeException("Invalid Token!"));

        User user = token.getUser();

        for (Role role :
                roles) {
            if (user.getRole().equals(role)) {
                return user;
            }
        }

        throw new UnauthorizedException();
    }

}
