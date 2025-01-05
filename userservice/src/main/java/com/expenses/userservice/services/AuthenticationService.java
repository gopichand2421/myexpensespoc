package com.expenses.userservice.services;

import com.expenses.userservice.config.ApplicationConfigProperties;
import com.expenses.userservice.entities.UserTokens;
import com.expenses.userservice.entities.Users;
import com.expenses.userservice.model.LoginDTO;
import com.expenses.userservice.model.LoginResponseDTO;
import com.expenses.userservice.repositories.UserRepository;
import com.expenses.userservice.repositories.UserTokenRepository;
import com.expenses.userservice.util.tokenfactory.AccessTokenFactory;
import com.expenses.userservice.util.tokenfactory.JwtTokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthenticationService {

    @Autowired
    private ApplicationConfigProperties applicationConfigProperties;

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private UserTokenRepository userTokenRepository;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            UserTokenRepository userTokenRepository
    ){
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userTokenRepository = userTokenRepository;
    }
    // User authentication method
    public LoginResponseDTO userAuthenticate(LoginDTO loginDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(), loginDTO.getPassword()
        ));
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        Map<String, Object> claimsMap = new HashMap<>();
        //Todo Hard code need to remove
        List<String> userRoles = Arrays.asList("APP_USER","APP_ADMIN");
        claimsMap.put("roles",userRoles);
        Users user = userRepository.findUsernameOrEmail(loginDTO.getUsername()).orElseThrow();

        //Generating access token using access token factory
        AccessTokenFactory accessTokenFactory = new JwtTokenFactory();
        String  accessToken = accessTokenFactory.tokenFactory().generateToken(claimsMap, user,3600L,
                this.applicationConfigProperties.getHashingKey());
        UserTokens userTokens = new UserTokens();
        userTokens.setUser(user);
        userTokens.setUserToken(accessToken);
        userTokens.setExpired(false);
        this.userTokenRepository.save(userTokens);
        loginResponseDTO.setJwtToken(accessToken);
        return loginResponseDTO;
    }
}
