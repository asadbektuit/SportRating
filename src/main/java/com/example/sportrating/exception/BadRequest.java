package com.example.sportrating.exception;

public class BadRequest extends RuntimeException{

    public BadRequest(String message) {
        super(message);
    }
}
