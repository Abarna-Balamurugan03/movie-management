package com.milestone.Rental_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milestone.Rental_System.model.Category;
@Repository
public interface CategoryInterface extends JpaRepository<Category, Long> {

}
