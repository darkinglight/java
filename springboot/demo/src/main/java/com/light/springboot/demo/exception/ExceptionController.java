package com.light.springboot.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = TestException.class)
    public ResponseEntity<Object> exception(TestException exception) {
        return new ResponseEntity<>("error handler return ok", HttpStatus.NOT_FOUND);
    }
}
