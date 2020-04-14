package com.light.springboot.demo.controller;

import com.light.springboot.demo.exception.TestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>("index", HttpStatus.OK);
    }

    @RequestMapping("/exception")
    public void exception() {
        throw new TestException();
    }
}
