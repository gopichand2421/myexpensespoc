package com.expenses.userservice.util.tokenfactory;

import com.expenses.userservice.entities.Users;

import java.util.Map;

//FOR HANDLING SSO AUTHENTICATION
public class XmlAccessToken implements  AccessToken{

    //TODO XML BASED TOKEN GENERATION FOR AN USER
    @Override
    public String generateToken(Map<String, Object> claims, Users user, Long expiration, String hashingKey) {
        return "";
    }
}
