package com.adjusted.vaadin.groceryapp.backend.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Product extends AbstractEntity {

    @NotBlank(message = "{bakery.name.required}")
    @Size(max = 255)
    @Column(unique = true)
    private String name;

    @NotBlank(message = "{bakery.url.required}")
    @Size(max = 1000)
    @Column(unique = true)
    private String url;

    @Column
    private Integer amount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                super.toString() +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
