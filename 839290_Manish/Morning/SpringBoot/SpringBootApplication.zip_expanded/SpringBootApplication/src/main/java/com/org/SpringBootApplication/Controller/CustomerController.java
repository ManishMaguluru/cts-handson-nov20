package com.org.SpringBootApplication.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.SpringBootApplication.Entities.Customer;
import com.org.SpringBootApplication.Exception.CustomerAlreadyExistsException;
import com.org.SpringBootApplication.Exception.CustomerNotFoundException;
import com.org.SpringBootApplication.Service.CustomerService;
import com.org.SpringBootApplication.util.ResponseMessage;

@RequestMapping("customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer)
	{
		ResponseEntity<Object> response = null;
		try {
			Customer addCustomer = customerService.addCustomer(customer);
			response = ResponseEntity.status(200).body(addCustomer);
		} catch (CustomerAlreadyExistsException e) {
			ResponseMessage responseMessage = new ResponseMessage();
			responseMessage.setMessage(e.getMessage());
			responseMessage.setStatus(404);
			response = ResponseEntity.status(404).body(responseMessage);
		}
		return response;
	}
	
	@GetMapping
	public ResponseEntity<Object> fetchAllCustomers()
	{
		ResponseEntity<Object> response = null;
		try {
			List<Customer> customer = customerService.getAllCustomers();
			response = ResponseEntity.status(200).body(customer);
		} catch (CustomerNotFoundException e) {
			ResponseMessage responseMessage = new ResponseMessage();
			responseMessage.setMessage(e.getMessage());
			responseMessage.setStatus(404);
			response = ResponseEntity.status(404).body(responseMessage);
		}
		return response;
	}
	
	@GetMapping("{customerId}")
	public ResponseEntity<Object> fetchCustomerById(@PathVariable("customerId") int customerId)
	{
		ResponseEntity<Object> response = null;
		try {
				Customer customer = customerService.getCustomerById(customerId);
				response = ResponseEntity.status(200).body(customer);
				
		} catch (CustomerNotFoundException e) {
			ResponseMessage responseMessage = new ResponseMessage();
			responseMessage.setMessage(e.getMessage());
			responseMessage.setStatus(404);
			response = ResponseEntity.status(404).body(responseMessage);
		}
		return response;
	}
	
	@PutMapping("{customerId}/{dob}")
	public ResponseEntity<Object> updateCustomerDobAPI(@PathVariable("customerId") int id, @PathVariable("dob") String stringDob) {
		ResponseEntity<Object> response = null;
		try {
			Customer customer = customerService.updateCustomer(id, LocalDate.parse(stringDob));
			response = ResponseEntity.status(200).body(customer);
		} catch (CustomerNotFoundException e) {
			ResponseMessage responseMessage = new ResponseMessage();
			responseMessage.setMessage(e.getMessage());
			responseMessage.setStatus(404);
			response = ResponseEntity.status(404).body(responseMessage);
		}
		return response;
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<Object> deleteCustomerById(@PathVariable("customerId") int id)
	{
		ResponseEntity<Object> response = null;
			try {
				customerService.deleteCustomerById(id);
				response = ResponseEntity.status(200).body(new ResponseMessage("Customer with id "+id+" deleted",200));
				
			} catch (CustomerNotFoundException e) {
				ResponseMessage responseMessage = new ResponseMessage();
				responseMessage.setMessage(e.getMessage());
				responseMessage.setStatus(404);
				response = ResponseEntity.status(404).body(responseMessage);
			}
			return response;
	}
}
