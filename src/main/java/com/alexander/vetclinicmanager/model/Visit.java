package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Visit Description")
    private String description;

    @Column(name = "Last Update By")
    @ManyToOne
    @JoinColumn(name = "doctor id")         // referencja do doktora
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "client id")         // do klienta
    private Client client;

    @CreationTimestamp
    private LocalDateTime dateCreated;                  // czy poprawnie ? patrz notatki
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    public Visit() {
    }

    public Visit(Long id, String description, Doctor doctor, Client client, LocalDateTime dateCreated, LocalDateTime lastUpdated) {
        this.id = id;
        this.description = description;
        this.doctor = doctor;
        this.client = client;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
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

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}


















