package com.example.springservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceDiscoveryApplication.class, args);
	}

}
