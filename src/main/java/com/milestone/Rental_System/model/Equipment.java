package com.milestone.Rental_System.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Equipment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double rentalPricePerDay;
	
	
	@ManyToOne
	//@JoinColumn(name="id")
	private Category category;
	 
	@OneToMany(mappedBy = "equipment",cascade = CascadeType.ALL)
	private List<Rental> rentals;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	public void setRentalPricePerDay(double rentalPricePerDay) {
		this.rentalPricePerDay = rentalPricePerDay;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public Equipment(Long id, String name, String description, double rentalPricePerDay) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rentalPricePerDay = rentalPricePerDay;
	}
	
	public Equipment() {}
	
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", description=" + description + ", rentalPricePerDay="
				+ rentalPricePerDay + "]";
	}
	
   

}
