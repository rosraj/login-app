package com.demo.config;

import com.demo.cache.UserCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public UserCache userCache(){
        return new UserCache();
    }
}
