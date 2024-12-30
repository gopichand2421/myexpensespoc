package com.expenses.userservice.exceptions;

/**
 * @Author Gopichand
 *
 * This class for handling User already exists in DB
 *
 */
public class UserAlreadyExistException extends RuntimeException{

    //constructor with error message
    public UserAlreadyExistException(String message){
        super(message);
    }
}
