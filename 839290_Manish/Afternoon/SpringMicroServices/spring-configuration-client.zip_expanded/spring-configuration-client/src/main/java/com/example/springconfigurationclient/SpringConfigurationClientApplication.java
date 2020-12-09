package com.example.springconfigurationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringConfigurationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigurationClientApplication.class, args);
	}

}
