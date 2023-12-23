package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Visit {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Visit Description")
    private String description;

    @Column(name = "Last Update By")
    @ManyToOne
    @JoinColumn(name = "doctor id")         // referencja do doktora
    private Doctor doctor;

    @CreationTimestamp
    private LocalDateTime dateCreated;                  // czy poprawnie ? patrz notatki


    public Visit() {
    }

    public Visit(Long id, String description, Doctor doctor, LocalDateTime dateCreated) {
        this.id = id;
        this.description = description;
        this.doctor = doctor;
        this.dateCreated = dateCreated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}


















