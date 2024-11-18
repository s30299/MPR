package com.example.volleyball;

import com.example.volleyball.models.CustomException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<String> handleException(Exception e){
//        return ResponseEntity.internalServerError().body(e.getMessage());
        return ResponseEntity.of(e.getMessage());
    }
}
