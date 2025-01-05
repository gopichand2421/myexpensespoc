package com.expenses.userservice.util.tokenfactory;

import com.expenses.userservice.entities.Users;
import com.expenses.userservice.config.ApplicationConfigProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JwtAccessToken implements  AccessToken{


    @Override
    public String generateToken(Map<String, Object> claims, Users user, Long expiration, String hashingKey){
        String username = Objects.nonNull(user.getUsername()) ? user.getUsername() : user.getEmail();
        return Jwts.builder()
                .setSubject(username)
                .addClaims(claims)
                .signWith(getSignInKey(hashingKey))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ expiration))
                .compact();
    }

    private Key getSignInKey(final String hasingKey){
        byte[] keyBytes = Decoders.BASE64.decode(hasingKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
