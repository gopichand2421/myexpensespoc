package com.expenses.userservice.controller;

import com.expenses.userservice.model.LoginDTO;
import com.expenses.userservice.model.LoginResponseDTO;
import com.expenses.userservice.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(
            AuthenticationService authenticationService
    ){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginDTO loginDTO){
        LoginResponseDTO loginResponseDTO = authenticationService.userAuthenticate(loginDTO);
        return ResponseEntity.ok(loginResponseDTO);
    }
}
