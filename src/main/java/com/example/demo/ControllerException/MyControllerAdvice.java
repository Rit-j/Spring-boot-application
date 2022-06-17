package com.example.demo.ControllerException;

import com.example.demo.Exception.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> response(ResourceNotFound e){
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
