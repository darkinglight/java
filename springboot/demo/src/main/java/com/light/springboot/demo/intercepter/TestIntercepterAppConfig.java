package com.light.springboot.demo.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class TestIntercepterAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private TestIntercepter testIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testIntercepter);
    }
}
