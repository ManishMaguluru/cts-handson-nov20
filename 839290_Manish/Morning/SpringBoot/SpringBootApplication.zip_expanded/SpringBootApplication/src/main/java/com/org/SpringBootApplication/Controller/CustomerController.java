package com.org.SpringBootApplication.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.SpringBootApplication.Entities.Customer;
import com.org.SpringBootApplication.Service.CustomerService;

@RequestMapping("customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer customer)
	{
		System.out.println("Manish");
		Customer addCustomer = customerService.addCustomer(customer);
		return addCustomer;
	}
	
	@GetMapping
	public List<Customer> fetchAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping(value= "{customerId}")
	public Customer fetchCustomerById(int customerId)
	{
		return customerService.getCustomerById(customerId);
	}
	
	@PutMapping("{customerId}/{dob}")
	public Customer updateCustomerDobAPI(@PathVariable("customerId") int id, @PathVariable("dob") String stringDob) {
		return customerService.updateCustomer(id, LocalDate.parse(stringDob));
	}
	
	@DeleteMapping("{customerId}")
	public void deleteCustomerById(@PathVariable("customerId") int id)
	{
			customerService.deleteCustomerById(id);
	}
	
	
	
	
	
	

}
