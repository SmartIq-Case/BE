package com.smartIq.vehicledealership.vehicledealership.common.util;


import com.smartIq.vehicledealership.vehicledealership.User.entity.User;

import java.util.UUID;

public class TokenGenerator {

    //uses UUID standard, 128bit key. 32character length
    public static String generateToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}