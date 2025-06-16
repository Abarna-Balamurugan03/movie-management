package com.milestone.Rental_System.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Rental> getRentals() {
		return rentals;
	}
	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}
	public Customer(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Customer() {}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
    
    
    

}
