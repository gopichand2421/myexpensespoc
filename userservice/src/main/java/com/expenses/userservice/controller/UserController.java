package com.expenses.userservice.controller;

import com.expenses.userservice.entities.Users;
import com.expenses.userservice.model.UsersDTO;
import com.expenses.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UsersDTO usersDTO){
        return ResponseEntity.ok(userService.createUser(usersDTO));
    }
}
