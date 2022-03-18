package com.adjusted.vaadin.groceryapp.backend.repositories;

import com.adjusted.vaadin.groceryapp.backend.data.entity.WeightData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WeightRepository extends JpaRepository<WeightData, Long> {

    //Page<WeightData> findByPersonNameContainingIgnoreCase(String searchQuery, Pageable pageable);

    @Override
    List<WeightData> findAll();

    @Override
    Page<WeightData> findAll(Pageable pageable);

    @Override
    Optional<WeightData> findById(Long id);

    //long countByPersonNameContainingIgnoreCase(String searchQuery);

}
