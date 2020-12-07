package com.org.SpringBootApplication.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.SpringBootApplication.Entities.Customer;
import com.org.SpringBootApplication.Exception.CustomerAlreadyExistsException;
import com.org.SpringBootApplication.Exception.CustomerNotFoundException;
import com.org.SpringBootApplication.Repositories.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository dao;
	
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException{
		
		List<Customer> customers = dao.findAll();
		for(Customer customerold: customers){
			if(customer.getName().equals(customerold.getName()))
				throw new CustomerAlreadyExistsException("User name already Exists... You can try with another username");
		}
		Customer createdCustomer = dao.save(customer);
		return createdCustomer;
	
	}
	
	public List<Customer> getAllCustomers() throws CustomerNotFoundException{
		if(dao.findAll().isEmpty())
			throw new CustomerNotFoundException("Customer data is empty");
		else
			return dao.findAll();
	}
	
	public Customer getCustomerById(int id) throws CustomerNotFoundException
	{
		Optional<Customer> option = dao.findById(id);
		if(option.isPresent())
		{
				return option.get();
		}
		else
		{
			throw new CustomerNotFoundException("Sorry Customer with id number "+id+" not found");
		}
	}
	
	public Customer updateCustomer(int id, LocalDate dob) throws CustomerNotFoundException {
		Customer customer = getCustomerById(id);
		if(customer != null) {
			customer.setDob(dob);
			return dao.save(customer);
		} 
		else 
			throw new CustomerNotFoundException("Sorry Customer with id number "+id+" not found");
	}
	
	public void deleteCustomerById(int id) throws CustomerNotFoundException
	{
		Customer customer = getCustomerById(id);
		if(customer != null) {
			dao.deleteById(id);
		} 
		else 
			throw new CustomerNotFoundException("Sorry Customer with id number "+id+" not found");
	}

}
