package com.expenses.userservice.exceptions;

public class BadRequestException  extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
