package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
//    @OneToMany(mappedBy = "doctor")     // trzeba wskazac nazwe pola po przeciwnej stronie, dwukierunkowa relacja jeden do wielu
//    private List<Visit> visits;         // lista wizyt doktora


    public Doctor() {
    }

    public Doctor(Long id, String firstName, String lastName){ // }, List<Visit> visits) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
 //       this.visits = visits;
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

//    public List<Visit> getVisits() {
//        return visits;
//    }
//
//    public void setVisits(List<Visit> visits) {
//        this.visits = visits;
//    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
 //               ", visits=" + visits +
                '}';
    }
}




















