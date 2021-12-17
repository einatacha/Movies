package com.example.Movies.service.exception;

public class ResourceInternalServerError  extends RuntimeException{
    public ResourceInternalServerError(String message) {
        super(message);
    }
}
