package com.example.myappexample.controller;

import com.example.myappexample.exceptions.BadRequestException;
import com.example.myappexample.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> ResourceNotFoundExceptionHandler(RuntimeException rx, WebRequest request){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message: ", rx.getMessage());
        body.put("Error:", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity(body, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> ResourceBadRequestExceptionHandler(RuntimeException rx, WebRequest request){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message: ", rx.getMessage());
        body.put("Error:", HttpStatus.BAD_REQUEST.toString());

        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);

    }

}
