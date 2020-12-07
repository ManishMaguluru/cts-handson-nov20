package com.org.SpringBootApplication.Exception;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundException() {
		super("Customer not found");
		// TODO Auto-generated constructor stub
	}
	
	

}
