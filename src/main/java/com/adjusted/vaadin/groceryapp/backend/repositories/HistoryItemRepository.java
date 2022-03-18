package com.adjusted.vaadin.groceryapp.backend.repositories;

import com.adjusted.vaadin.groceryapp.backend.data.entity.HistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
