package com.expenses.userservice.services;

import com.expenses.userservice.entities.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Service
public class JwtService {

    @Value("${userservice.jwt.expiration-time}")
    private long expirationTime;

    @Value("${userservice.jwt.secret-key}")
    private String secretKey;

    public String generateToken(Map<String, Object> claims, Users user, Long expiration){
        String username = Objects.nonNull(user.getUsername()) ? user.getUsername() : user.getEmail();
        return Jwts.builder()
                .setSubject(username)
                .addClaims(claims)
                .signWith(getSignInKey())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ expiration))
                .compact();
    }

    private Key getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
