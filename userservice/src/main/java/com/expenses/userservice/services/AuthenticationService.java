package com.expenses.userservice.services;

import com.expenses.userservice.entities.Users;
import com.expenses.userservice.model.LoginDTO;
import com.expenses.userservice.model.LoginResponseDTO;
import com.expenses.userservice.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthenticationService {

    private JwtService jwtService;
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ){
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

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
        String token = jwtService.generateToken(claimsMap, user,3600L);
        loginResponseDTO.setJwtToken(token);
        return loginResponseDTO;
    }
}
