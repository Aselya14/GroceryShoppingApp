package com.adjusted.vaadin.groceryapp.backend.repositories;

import com.adjusted.vaadin.groceryapp.backend.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findBy(Pageable page);

	Page<Product> findByNameLikeIgnoreCase(String name, Pageable page);

	int countByNameLikeIgnoreCase(String name);

}
