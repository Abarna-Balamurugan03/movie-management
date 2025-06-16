package com.milestone.Rental_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milestone.Rental_System.model.*;
@Repository
public interface CustomerInterface extends JpaRepository<Customer, Long>{

}
