package com.milestone.Rental_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milestone.Rental_System.model.Rental;
import com.milestone.Rental_System.repository.RentalInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RentalService {
	@Autowired
	RentalInterface rr;
	
	public void saveRental(Rental rental) {
		rr.save(rental);
	}
	
	public List<Rental> getAll() {
		return  rr.findAll();
	}
	
	public Rental getRentalById(Long id) {
		return rr.findById(id).get();
	}
	

}
