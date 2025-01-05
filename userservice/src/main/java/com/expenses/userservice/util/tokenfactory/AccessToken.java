package com.expenses.userservice.util.tokenfactory;

import com.expenses.userservice.entities.Users;

import java.util.Map;

//Functional for generating token
@FunctionalInterface
public interface AccessToken {

    //method for generating token
    String generateToken(Map<String, Object> claims, Users user, Long expiration, String hashingKey);
}
