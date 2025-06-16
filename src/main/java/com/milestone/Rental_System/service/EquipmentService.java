package com.milestone.Rental_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milestone.Rental_System.model.Equipment;
import com.milestone.Rental_System.model.Rental;
import com.milestone.Rental_System.repository.EquipmentInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EquipmentService {
	@Autowired
	EquipmentInterface er;
	
	public void addEquipment(Equipment equipment) {
		er.save(equipment);
	}
	
	public List<Equipment> getAll() {
		return  er.findAll();
	}
	
	public Equipment getEquipmentById(Long id) {
		return er.findById(id).get();
	} 
	
	public void deleteEquipment(Long id) {
		Equipment e=er.findById(id).get();
		e.setCategory(null);
		er.delete(e);
		}
	
}
