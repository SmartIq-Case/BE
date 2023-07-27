package com.smartIq.vehicledealership.vehicledealership.User.Service;

import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.SubUserCreateRequest;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.TokenRepository;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.UserRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Role;
import com.smartIq.vehicledealership.vehicledealership.User.entity.Token;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserMapper;
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

    /**
     * Bir kullanıcının sisteme kayıt olduğu metoddur. Varsayılan olarak kullanıcılara başlangışta USER rolü verilir.
     * Kullanıcı ilerleyen süreçte bir şirket oluşturursa rolü COMPANY_OWNER olarak güncellenecek ve o Company ile ilişkilendirilecek.
     *
     *
     * @param request
     * @return
     */
    public User register(
        UserRegisterRequest request
    ){

        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("email is already exist"+ request.getEmail());
        }

        User userEntityToBeSave = UserMapper.mapForSaving(request,passwordEncoder);

        return userRepository.save(userEntityToBeSave);
    }

    /**
     * Şirketlere ait alt kullanıcıların tanımlandığı metoddur.
     *
     * @param request
     * @return
     */
    public User createSubUser(
            SubUserCreateRequest request,
            User creatorUser
    ){
        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("email is already exist"+ request.getEmail());
        }

        User userEntityToBeSave = UserMapper.mapForSaving(request,passwordEncoder,creatorUser);

        return userRepository.save(userEntityToBeSave);

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

        Token tokenEntityToBeSave = new Token();
        tokenEntityToBeSave.setTokenCode(TokenGenerator.generateToken());

        final Token savedTokenEntity = tokenRepository.save(tokenEntityToBeSave);

        user.setToken(savedTokenEntity);

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
