package com.light.springboot.demo;

import com.light.springboot.demo.service.DependencyService;
import com.light.springboot.demo.service.TestService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DependencyTest {


    @MockBean
    private DependencyService dependencyService;

    @Autowired
    private TestService testService;


    @Test
    public void dependencyTest() {
        Mockito.when(dependencyService.dependency("test")).thenReturn("test");
        String result = testService.dependency("test");
        Assertions.assertThat(result).isEqualTo("test");
    }
}
