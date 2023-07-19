package com.smartIq.vehicledealership.vehicledealership.common.config;

import com.smartIq.vehicledealership.vehicledealership.common.util.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Bean(name = "passwordEncoderCustomSHA256" )
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder();
    }
}
