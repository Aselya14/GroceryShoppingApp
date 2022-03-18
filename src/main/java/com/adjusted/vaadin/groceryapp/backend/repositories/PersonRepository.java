package com.adjusted.vaadin.groceryapp.backend.repositories;

import com.adjusted.vaadin.groceryapp.backend.data.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {


	Page<Person> findByNameContainingIgnoreCase(String searchQuery, Pageable pageable);

	@Override
	List<Person> findAll();

	@Override
	Page<Person> findAll(Pageable pageable);

	@Override
	Optional<Person> findById(Long id);

	long countByNameContainingIgnoreCase(String searchQuery);

}
