package com.kiroule.vaadin.bakeryapp.backend.service;


import com.kiroule.vaadin.bakeryapp.backend.data.entity.User;
import com.kiroule.vaadin.bakeryapp.backend.data.entity.WeightData;
import com.kiroule.vaadin.bakeryapp.backend.repositories.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeightService implements FilterableCrudService<WeightData>{

    @Autowired
    private WeightRepository weightRepository;

    @Override
    public Page<WeightData> findAnyMatching(Optional<String> filter, Pageable pageable) {

        
        return null;
    }

    @Override
    public long countAnyMatching(Optional<String> filter) {
        return 0;
    }

    @Override
    public JpaRepository<WeightData, Long> getRepository() {
        return null;
    }

    @Override
    public WeightData createNew(User currentUser) {
        return null;
    }
}
