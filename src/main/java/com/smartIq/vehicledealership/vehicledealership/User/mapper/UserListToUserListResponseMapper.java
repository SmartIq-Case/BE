package com.smartIq.vehicledealership.vehicledealership.User.mapper;

import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import com.smartIq.vehicledealership.vehicledealership.User.payload.response.GetUserResponse;

import java.util.ArrayList;
import java.util.List;

public class UserListToUserListResponseMapper {
    public static List<GetUserResponse> toDto(List<User> users){
        List<GetUserResponse> list = new ArrayList<>();
        for (User user: users){
            //GetUserResponse getUserResponse = UserToGetUserResponseMapper.toDto(user);
            list.add(UserToGetUserResponseMapper.toDto(user));
        }
        return list;
    }
}
