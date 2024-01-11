package com.alexander.vetclinicmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.springframework.context.annotation.Lazy;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotNull
    private int houseNumber;
    private int apartmentNumber;
    @Column(precision = 5)
    private int zipCode;
    @OneToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore                             // bez tego StackOverflowwError; pole nie bedzie uwzględniane podczas przekształcania do formatu JSON, dane te nie są istotne dla klienta aplikacji klienckiej
    private Client client;                  // bedzie mozna znalezc klienta po ip adresu

    public Address(){
    }

    public Address(Long id, String city, String street, int houseNumber, int apartmentNumber, int zipCode){     // bez tego:  Client client) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.zipCode = zipCode;
//        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                ", zipCode=" + zipCode +
                ", client=" + client +
                '}';
    }
}




























