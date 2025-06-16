package com.milestone.Rental_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milestone.Rental_System.model.Category;
import com.milestone.Rental_System.model.Customer;
import com.milestone.Rental_System.repository.CustomerInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerInterface cr;
	
	public void saveCustomer(Customer customer) {
		cr.save(customer);
	}
	
	public List<Customer> getAll() {
		return  cr.findAll();
	}
	
	public Customer getCustomerById(Long id) {
		return cr.findById(id).get();
	}
	
	

}
