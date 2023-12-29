package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//                          ZAIMPLEMENTUJ TOSTRING !! ??
    @Column(name = "First Name")
    private String firstName;
    @Column(name = "Last Name")
    private String lastName;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "Account", precision = 10, scale = 2)        // max 10 cyfr, 2 po przecinku
    private double account;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petOwner")           // HibernateNauka 3
    private List <Pet> pet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List <Visit> visits;


    public Client(){                 // koniecznie pamietac o bezparametrowym konstruktorze
    }


    public Client(Long id, String firstName, String lastName, String telephone, double account, Address address, List<Pet> pet, List<Visit> visits) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.account = account;
        this.address = address;
        this.pet = pet;
        this.visits = visits;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
























