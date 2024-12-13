package com.conceptile.quizzapp.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class QuizzExceptionHandler {

        @ExceptionHandler(UserSessionException.class)
        public ResponseEntity<String> UserSessionHandler(UserSessionException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<String> AnswerSubmittedExceptionHandler(DataIntegrityViolationException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer is already Submitted");
        }
}
