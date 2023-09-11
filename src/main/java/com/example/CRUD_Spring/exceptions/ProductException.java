package com.example.CRUD_Spring.exceptions;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductException{

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(){
        return ResponseEntity.notFound().build();
    }

//    @ExceptionHandler()
//    public ResponseEntity threat400(){
//        return ResponseEntity.badRequest().build();
//    }
}
