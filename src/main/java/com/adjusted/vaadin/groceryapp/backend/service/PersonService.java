package com.adjusted.vaadin.groceryapp.backend.service;

import com.adjusted.vaadin.groceryapp.backend.data.entity.Person;
import com.adjusted.vaadin.groceryapp.backend.data.entity.User;


import com.adjusted.vaadin.groceryapp.backend.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService implements FilterableCrudService<Person> {

	private final PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Page<Person> findAnyMatching(Optional<String> filter, Pageable pageable) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return personRepository.findByNameContainingIgnoreCase(repositoryFilter, pageable);
		} else {
			return personRepository.findAll(pageable);
		}
	}

	@Override
	public long countAnyMatching(Optional<String> filter) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return personRepository.countByNameContainingIgnoreCase(repositoryFilter);
		} else {
			return count();
		}
	}

	@Override
	public JpaRepository<Person, Long> getRepository() {
		return personRepository;
	}

	@Override
	public Person createNew(User currentUser) {
		return new Person();
	}

	@Override
	public Person save(User currentUser, Person entity) {
		try {
			return FilterableCrudService.super.save(currentUser, entity);
		} catch (DataIntegrityViolationException e) {
			throw new UserFriendlyDataException(
					"There is already a product with that name. Please select a unique name for the product.");
		}

	}

}
