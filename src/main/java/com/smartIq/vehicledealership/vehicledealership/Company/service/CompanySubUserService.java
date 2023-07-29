package com.smartIq.vehicledealership.vehicledealership.Company.service;

import com.smartIq.vehicledealership.vehicledealership.Company.mapper.CompanySubUserMapper;
import com.smartIq.vehicledealership.vehicledealership.Company.payload.request.CompanySubUserUpdateRequest;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.UserRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Bir şirketin yönetimini yapabilen alt kullanıcıların tanımlandığı rest controller sınıfıdır..
 *
 */
@Service
@RequiredArgsConstructor
public class CompanySubUserService {

    private final UserRepository userRepository;


    public List<User> getAllSubUsers(
            User requestOwner
    ) {
        return userRepository
                .findUsersByCompany(requestOwner.getCompany())
                .orElseThrow(()-> new RuntimeException("Hiç alt kullanıcı bulunmuyor."));
    }

    /**
     * ID değeri verilen SubUser olarak kullanılan {@link User} entity nesnesini geriye döndüren metoddur.
     *
     * @param requestOwner
     * @param subUserId
     * @return
     */
    public User getSubUserById(
            User requestOwner,
            Long subUserId
    ) {
        return userRepository
                .findUserByIdAndCompany(subUserId,requestOwner.getCompany())
                .orElseThrow(UnauthorizedException::new);
    }


    /**
     *
     * @param requestOwner
     * @param subUserId
     *
     * @return
     */
    public User updateSubUserById(
            User requestOwner,
            Long subUserId,
            CompanySubUserUpdateRequest request
    ) {

        User subUserToBeUpdate = userRepository
                .findUserByIdAndCompany(subUserId,requestOwner.getCompany())
                .orElseThrow(UnauthorizedException::new);
                //.orElseThrow(()->new UnauthorizedException());

        CompanySubUserMapper.mapForUpdating(subUserToBeUpdate,requestOwner,request);


        return userRepository.save(subUserToBeUpdate);

    }


    public void deleteSubUserById(
            Long subUserId,
            User requestOwner
    ) {

        User subUserToBeDelete = userRepository
                .findUserByIdAndCompany(subUserId,requestOwner.getCompany())
                .orElseThrow(UnauthorizedException::new);

        subUserToBeDelete.setCompany(null);

        userRepository.delete(subUserToBeDelete);
    }
}
