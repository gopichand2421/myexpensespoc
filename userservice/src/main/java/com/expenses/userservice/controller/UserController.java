package com.expenses.userservice.controller;

import com.expenses.userservice.model.UsersDTO;
import com.expenses.userservice.services.UserHandlerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Gopichand Senagavarapu
 * @vsersion : 1.0.0
 */


/**
 *
 * This the controller which handles user related requests.
 *
 */
@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    private UserHandlerService userHandlerService;

    @Autowired
    public UserController(final UserHandlerService userHandlerService){
        this.userHandlerService = userHandlerService;
    }

    /**
     *
     * @param usersDTO
     * @return @string json
     */
    @PostMapping
    public ResponseEntity<String> createNewUser(@RequestBody UsersDTO usersDTO){

        //handles createuser method
        String val = this.userHandlerService.createUser(usersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Created");
    }

    /**
     *
     * @param id
     * @return @string json
     */
    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<UsersDTO> getUserDetails(@PathVariable(name ="id") @Valid Long id){

        return null;
    }
}
