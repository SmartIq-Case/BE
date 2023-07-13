package com.smartIq.vehicledealership.vehicledealership.User.payload.response;

import com.smartIq.vehicledealership.vehicledealership.Company.entity.Company;
import com.smartIq.vehicledealership.vehicledealership.User.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Builder
public class GetAllUserResponse {
List<User> users;



}
