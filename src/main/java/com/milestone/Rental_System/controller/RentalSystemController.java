package com.milestone.Rental_System.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.milestone.Rental_System.model.*;
import com.milestone.Rental_System.service.CategoryService;
import com.milestone.Rental_System.service.CustomerService;
import com.milestone.Rental_System.service.EquipmentService;
import com.milestone.Rental_System.service.RentalService;

@Controller
public class RentalSystemController {
	@Autowired
	CategoryService cats;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	EquipmentService es;
	
	@Autowired
	RentalService rs;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/category")
	public String showCategory(Model model) {
		model.addAttribute("category",new Category());
		return "category";
		
	}
	
	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category) {
		cats.saveCat(category);
		return "redirect:/";
	}
	
	@GetMapping("/customer")
	public String showCustomer(Model model) {
		model.addAttribute("customer",  new Customer());
		return "customer";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer customer) {
		cs.saveCustomer(customer);
		return "redirect:/";
	}
	
	
	@GetMapping("/equipment")
	public String showEquipment(Model model) {
		List<Category> category=cats.getAll();
		model.addAttribute("equipment",  new Equipment());
		model.addAttribute("category", category);
		return "equipment";
	}
	
	@PostMapping("/saveEquipment")
	public String saveEquipment(@ModelAttribute("equipment")Equipment equipment,@RequestParam Long cId) {
		Category c=cats.getCategoryById(cId);
		equipment.setCategory(c);
		es.addEquipment(equipment);
		return "redirect:/";
	}
	
	@GetMapping("/rental")
	public String showRental(Model model) {
		List<Customer> customer=cs.getAll();
		List<Equipment> equipment=es.getAll();
		model.addAttribute("rental",  new Equipment());
		model.addAttribute("customer", customer);
		model.addAttribute("equipment", equipment);
		return "rental";
	}
	
	@PostMapping("/saveRental")
	public String saveRental(@ModelAttribute("rental")Rental rental,@RequestParam Long cId,@RequestParam Long eId) {
		Customer c=cs.getCustomerById(cId);
		Equipment e=es.getEquipmentById(eId);
		rental.setEquipment(e);
		rental.setCustomer(c);
		rs.saveRental(rental);
		
		return "redirect:/";
	}
	
	@GetMapping("/view")
	public String viewRental(Model model) {
		List<Rental> rental=rs.getAll();
		List<Equipment> equipment=es.getAll();
		model.addAttribute("equipment", equipment);
		model.addAttribute("rental", rental);
		return "/view";
	}
	
	@GetMapping("/viewById")
	public String viewBy(Model model) {
		return "viewById";
	}
	
	
	@GetMapping("/viewByEquipment")
	public String viewByEquipment( @RequestParam Long id, Model model) {
		Equipment equipment = es.getEquipmentById(id);
		
		Category c=equipment.getCategory();

		model.addAttribute("category", c);
		model.addAttribute("equipment", equipment);
		return "viewByEquipment";
	}
	
	@RequestMapping("/deleteEquipment/{id}")
	public String deleteEquipment(@PathVariable Long id,Model model) {
		es.deleteEquipment(id);
		return "redirect:/view";
	}
}
	
	

	

	
	

