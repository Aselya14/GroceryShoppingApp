package com.kiroule.vaadin.bakeryapp.backend.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

 @Entity
public class WeightData extends AbstractEntity{

     @NotBlank(message = "{weight.required}")
     @Size(max = 255)
     @Column(unique = true)
     private float weight;
    @NotNull(message = "{date.required}")
    private LocalDate dueDate;
    private java.sql.Date Date;

    @Column
    @NotNull(message = "{weight.required}")
    private Double weight;

    @Column
    @NotNull(message = "{person.required}")
    private Person person;

}
