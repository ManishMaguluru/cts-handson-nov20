package com.org.SpringBootApplication.Tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.org.SpringBootApplication.Controller.CustomerController;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private CustomerController customerController;
	
	@Test
	public void testControllerInstance() {
		assertThat(customerController).isNotNull();
	}
}
