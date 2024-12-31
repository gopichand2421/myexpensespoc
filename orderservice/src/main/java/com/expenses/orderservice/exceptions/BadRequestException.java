package com.expenses.orderservice.exceptions;

public class BadRequestException  extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
