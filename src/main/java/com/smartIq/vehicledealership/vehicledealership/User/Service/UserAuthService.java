package com.smartIq.vehicledealership.vehicledealership.User.Service;

import com.smartIq.vehicledealership.vehicledealership.User.Repository.TokenRepository;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.UserRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Token;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UserAuthenticateRequest;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UserRegisterRequest;
import com.smartIq.vehicledealership.vehicledealership.common.util.PasswordEncoder;
import com.smartIq.vehicledealership.vehicledealership.common.util.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Userlerin authentication, register ve token süreçlerini yöneten servis katmanıdır.
 *
 *
 */
@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public User register(
        UserRegisterRequest request
    ){

        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("email is already exist"+ request.getEmail());
        }


        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        Token token = new Token();
        token.setToken(TokenGenerator.generateToken());

        token = tokenRepository.save(token);


        user.setToken(token);

        return userRepository.save(user);
    }

    /**
     * Kullanıcının email ve şifresini gönderdiği ve doğrulama sonucunda geriye
     * kullanıcının işlemlerde kullanması için geçerli token oluşturulduğu metoddur.
     *
     * @return
     */
    public User authenticate(
        UserAuthenticateRequest request
    ){

        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("There is no user with given email: "+request.getEmail()));

        passwordEncoder.matches(request.getPassword(), user.getPassword());

        expireOldTokens(user);

        Token token = new Token();
        token.setToken(TokenGenerator.generateToken());

        token = tokenRepository.save(token);

        user.setToken(token);

        return userRepository.save(user);
    }

    public void logout(
            UserAuthenticateRequest request
    ){
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("There is no user with given email: "+request.getEmail()));

        passwordEncoder.matches(request.getPassword(), user.getPassword());
        expireOldTokens(user);
    }

    /**
     * Eski tokeni silip, user'in token alanını null yapar.
     */
    private void expireOldTokens(
        User user
    ){
        Token token = user.getToken();

        tokenRepository.delete(token);

        user.setToken(null);
    }
}
