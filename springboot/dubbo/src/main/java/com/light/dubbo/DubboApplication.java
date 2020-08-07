package com.light.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DubboApplication {

	public static void main(String[] args) throws IOException {
		ServiceConfig<GreetingsService> service = new ServiceConfig<>(); // #1
		service.setApplication(new ApplicationConfig("first-dubbo-provider")); // #2
		service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181")); // #3
		service.setInterface(GreetingsService.class); // #4
		service.setRef(new GreetingsServiceImpl()); // #5
		service.export(); // #6

		System.out.println("dubbo service started");
		System.in.read(); // #7
	}

}
