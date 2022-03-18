package com.adjusted.vaadin.groceryapp.backend.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class WeightData extends AbstractEntity {

    @Column
    @NotNull(message = "{weight.required}")
    private float weight;

    @NotNull(message = "{date.required}")
    private LocalDate dueDate;
    private java.sql.Date Date;


    @NotNull(message = "{person.required}")
    private Person person;

}
