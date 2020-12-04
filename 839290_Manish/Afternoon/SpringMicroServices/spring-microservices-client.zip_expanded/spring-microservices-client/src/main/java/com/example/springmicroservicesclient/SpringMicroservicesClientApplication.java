package com.example.springmicroservicesclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringMicroservicesClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesClientApplication.class, args);
	}

}
