package com.example.Movies.service.exception;

import java.util.Date;

import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);


    }
    @ExceptionHandler (DataIntegratyViolationException.class)
    public ResponseEntity<?> handleResourceNotFoundException(DataIntegratyViolationException e){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);


    }


}
