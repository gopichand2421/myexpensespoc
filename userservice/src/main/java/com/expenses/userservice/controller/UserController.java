package com.expenses.userservice.controller;

import com.expenses.userservice.model.UsersDTO;
import com.expenses.userservice.services.UserHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    private UserHandlerService userHandlerService;

    @Autowired
    public UserController(final UserHandlerService userHandlerService){
        this.userHandlerService = userHandlerService;
    }

    @PostMapping
    public ResponseEntity<String> createNewUser(@RequestBody UsersDTO usersDTO){
        String val = this.userHandlerService.createUser(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
    }
}
