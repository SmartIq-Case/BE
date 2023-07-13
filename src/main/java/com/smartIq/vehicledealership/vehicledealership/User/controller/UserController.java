package com.smartIq.vehicledealership.vehicledealership.User.controller;

import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserToUpdateUserResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.UpdateUserRequest;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserListToUserListResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserToGetUserResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.User.mapper.UserToSaveUserResponseMapper;
import com.smartIq.vehicledealership.vehicledealership.User.Service.UserService;
import com.smartIq.vehicledealership.vehicledealership.User.payload.request.SaveUserRequest;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.GetUserResponse;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.SaveUserResponse;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/user")
public class UserController {

    private final UserService userService;

    // TODO : In UserController, POST(save), GET(gelAll, getUserById), PUT(update), DELETE(delete) methods.

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody SaveUserRequest saveUserRequest) {
        SaveUserResponse saveUserResponse = UserToSaveUserResponseMapper.toDto(userService.createUser(saveUserRequest));
        return ResponseEntity.ok(saveUserResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(
            @PathVariable("id") Long id
    ) {
        GetUserResponse getUserResponse = UserToGetUserResponseMapper.toDto(userService.getOneUserById(id));

        return ResponseEntity.ok(getUserResponse);
    }


    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<GetUserResponse> getUserResponse = UserListToUserListResponseMapper.toDto(userService.getAllUsers());
        return ResponseEntity.ok(getUserResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable("id") Long id,
            @RequestBody UpdateUserRequest updateUserRequest
    ) {
      UpdateUserResponse updateUserResponse= UserToUpdateUserResponseMapper.tDto(userService.updateUserById(id, updateUserRequest)) ;
        return ResponseEntity.ok(updateUserResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(userService.deleteOneUserById(id)) ;
    }


}
