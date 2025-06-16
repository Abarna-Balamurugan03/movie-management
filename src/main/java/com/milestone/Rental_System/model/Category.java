package com.milestone.Rental_System.model;
import java.util.*;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String name;
    
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    private List<Equipment> equipmentList;
    
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
	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}
	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category() {}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
    
 
}
