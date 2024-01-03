package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @Column(precision = 10, scale = 2)
    private double price;
    @Column(precision = 10, scale = 1)
    private double stock;


    public Medicine() {
    }


    public Medicine(Long id, String name, double price, double stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}






















