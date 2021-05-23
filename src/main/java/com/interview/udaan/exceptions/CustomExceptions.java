package com.interview.udaan.exceptions;


public class CustomExceptions extends RuntimeException{
    private String message;

    public CustomExceptions(String message) {
        this.message = message;
        throw new RuntimeException(message);
    }
}
