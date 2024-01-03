package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String city;
    @NonNull
    private String street;
    @NonNull
    private int houseNumber;
    private int apartmentNumber;
    @Column(precision = 5)
    private int zipCode;

    public Address(){
    }

    public Address(Long id, String city, String street, int houseNumber, int apartmentNumber, int zipCode) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int streetNumber) {
        this.houseNumber = streetNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int flatNumber) {
        this.apartmentNumber = flatNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}




























