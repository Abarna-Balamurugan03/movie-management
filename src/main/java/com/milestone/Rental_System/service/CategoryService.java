package com.milestone.Rental_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milestone.Rental_System.model.Category;
import com.milestone.Rental_System.model.Rental;
import com.milestone.Rental_System.repository.CategoryInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
	@Autowired
	CategoryInterface cr;
	
	public void saveCat(Category category) {
		cr.save(category);
	}
	
	public List<Category> getAll() {
		return  cr.findAll();
	}
	
	public Category getCategoryById(Long id) {
		return cr.findById(id).get();
	}

}
