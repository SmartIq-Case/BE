package com.smartIq.vehicledealership.vehicledealership.User.Service;

import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UpdateUserRequest;
import com.smartIq.vehicledealership.vehicledealership.Company.service.CompanyService;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.SaveUserRequestToUserMapper;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UpdateUserRequestToUserMapper;
import com.smartIq.vehicledealership.vehicledealership.User.Repository.UserRepository;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.SaveUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CompanyService companyService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getOneUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find a Company with given id: " + id));

    }

    public User createUser(SaveUserRequest saveUserRequest) {

        User user = new User();
        SaveUserRequestToUserMapper.toEntity(saveUserRequest,user);
        if (saveUserRequest.getCompany()!=null) {
            user.setCompany(companyService.getOneCompanyById(saveUserRequest.getCompany()));
        }

        return userRepository.save(user);
    }

    public void deleteOneUserById(Long id) {
          userRepository.deleteById(id);
    }

   public User updateUserById(Long id, UpdateUserRequest updateUserRequest) {
        User user =userRepository.findById(id).orElseThrow(()->new RuntimeException("Can't find a Company with given id: " + id));
        UpdateUserRequestToUserMapper.toEntity(updateUserRequest,user);
        user.setCompany(companyService.getOneCompanyById(updateUserRequest.getCompany()));
        return userRepository.save(user);
    }
}
