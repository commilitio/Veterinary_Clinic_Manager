package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;

@Entity
public class Pet {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Pet name")
    private String name;
    @Column(name = "Age")
    private int age;            // int? data obecna - data urodzenia
    @Column(name = "Type")
    private String type;        // enum? api ?
    @Column(name = "Breed")
    private String breed;
    @Column(name = "Color")
    private String color;
    @Column(name = "Gender")
    private String gender;
    @ManyToOne
    @JoinColumn(name = "Owner id")
    private Client petOwner;

    public Pet() {
    }

    public Pet(Long id, String name, int age, String type, String breed, String color, String gender, Client petOwner) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.breed = breed;
        this.color = color;
        this.gender = gender;
        this.petOwner = petOwner;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Client getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(Client petOwner) {
        this.petOwner = petOwner;
    }
}
















