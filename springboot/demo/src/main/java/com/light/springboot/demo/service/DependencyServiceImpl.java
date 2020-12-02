package com.light.springboot.demo.service;

public class DependencyServiceImpl implements DependencyService {
    @Override
    public String dependency(String value) {
        return "dependency " + value;
    }
}
