package com.light.springboot.demo.template;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyTemplate {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
