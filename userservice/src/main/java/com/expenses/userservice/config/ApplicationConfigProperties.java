package com.expenses.userservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class ApplicationConfigProperties implements EnvironmentAware {

    @Autowired
    Environment environment;

    @Value("userservice.jwt.expiration-time")
    private String expirationTime;

    @Value("userservice.jwt.secret-key")
    private String jwtKey;

    //Hashing key getters
    public String getHashingKey(){
        return environment.getProperty("userservice.jwt.secret-key");
    }

    //getting expiration time
    public String jwtExpiringTime(){
        return expirationTime;
    }

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }
}
