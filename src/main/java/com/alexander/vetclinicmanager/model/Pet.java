package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    private String age;
    private LocalDate birthdate;
    private String type;        // enum? api ?
    private String breed;
    private String color;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "owner id")      // ta kolumna jest wlascicielem relacji, jest kluczem obcym
    private Client petOwner;

    public Pet() {
    }

    public Pet(Long id, String name, LocalDate birthdate, String type, String breed, String color, String gender, Client petOwner) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.type = type;
        this.breed = breed;
        this.color = color;
        this.gender = gender;
        this.petOwner = petOwner;
        calculateAge();                 // !!
    }


    public void calculateAge(){
        LocalDate now = LocalDate.now();
        if (birthdate != null){
            Period petAge = Period.between(birthdate, now);
            this.age = petAge.getYears() + " years " + petAge.getMonths() + " months";
        }
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

    public String getAge() {            // bez settera
        return age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

//  @DateTimeFormat(pattern = "dd-MM-yyyy")             nie dziala
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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


    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthdate=" + birthdate +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", gender='" + gender + '\'' +
                ", petOwner=" + petOwner +
                '}';
    }
}
















