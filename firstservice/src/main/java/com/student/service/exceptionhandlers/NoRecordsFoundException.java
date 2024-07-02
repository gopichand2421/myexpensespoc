package com.student.service.exceptionhandlers;

public class NoRecordsFoundException extends  RuntimeException{

    private  String message;
    public NoRecordsFoundException(String message){
        super(message);
        this.message = message;
    }
}
