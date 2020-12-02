package com.light.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private DependencyService dependencyService;

    @Override
    public String test() {
        return "service test";
    }

    @Override
    public String dependency(String value) {
        return dependencyService.dependency(value);
    }
}
