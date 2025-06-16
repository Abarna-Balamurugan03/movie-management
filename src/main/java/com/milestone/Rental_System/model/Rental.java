package com.milestone.Rental_System.model;

import jakarta.persistence.*;

@Entity
public class Rental {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String startDate;
	private String endDate;
	private String actualReturnDate;
	
	@ManyToOne
	//@JoinColumn(name="id")
	private Equipment equipment;
	@ManyToOne
	//@JoinColumn(name="id")
	private Customer customer;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(String actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Rental(Long id, String startDate, String endDate, String actualReturnDate) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.actualReturnDate = actualReturnDate;
	}
	public Rental() {}
	
	@Override
	public String toString() {
		return "Rental [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", actualReturnDate="
				+ actualReturnDate + "]";
	}
	
    

}
