package com.adjusted.vaadin.groceryapp.backend.repositories;

import com.adjusted.vaadin.groceryapp.backend.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
