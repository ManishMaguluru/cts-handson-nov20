package com.org.SpringBootApplication.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.SpringBootApplication.Entities.Customer;
import com.org.SpringBootApplication.Repositories.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository dao;
	
	public Customer addCustomer(Customer customer) {
		Customer createdCustomer = dao.save(customer);
		return createdCustomer;
	}
	
	public List<Customer> getAllCustomers(){
		return dao.findAll();
	}
	
	public Customer getCustomerById(int id)
	{
		Optional<Customer> option = dao.findById(id);
		return option.orElse(null);
	}
	
	public Customer updateCustomer(int id, LocalDate dob) {
		Customer customer = getCustomerById(id);
		if(customer != null) {
			customer.setDob(dob);
			return dao.save(customer);
		} 
		else 
			return null;
	}
	
	public void deleteCustomerById(int id)
	{
		dao.deleteById(id);
	}

}
