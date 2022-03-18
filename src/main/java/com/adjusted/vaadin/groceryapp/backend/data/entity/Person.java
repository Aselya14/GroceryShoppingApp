package com.adjusted.vaadin.groceryapp.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Person extends AbstractEntity {

    @NotBlank(message = "{person.name.required}")
    @Size(max = 255)
    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
