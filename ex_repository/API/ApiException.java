package com.example.ex_repository.API;

public class ApiException extends RuntimeException{

    public ApiException(String message){
        super(message);
    }
}
