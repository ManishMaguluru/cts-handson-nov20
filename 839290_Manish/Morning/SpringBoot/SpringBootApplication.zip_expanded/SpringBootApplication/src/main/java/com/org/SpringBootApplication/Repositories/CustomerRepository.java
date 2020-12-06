package com.org.SpringBootApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.SpringBootApplication.Entities.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

