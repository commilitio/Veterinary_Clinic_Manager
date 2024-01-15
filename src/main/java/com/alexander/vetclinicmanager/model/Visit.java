package com.alexander.vetclinicmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "visit_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "doctor_id")         // referencja do doktora
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "client_id")               // do klienta
    private Client client;

    @CreationTimestamp
    private LocalDate dateCreated;
    @UpdateTimestamp
    private LocalDate lastUpdated;
    @CreationTimestamp
    private LocalTime timeCreated;
    @UpdateTimestamp
    private LocalTime timeUpdated;


    public Visit() {
    }

    public Visit(Long id, String description, Doctor doctor, Client client, LocalDate dateCreated, LocalDate lastUpdated, LocalTime timeCreated, LocalTime timeUpdated) {
        this.id = id;
        this.description = description;
        this.doctor = doctor;
        this.client = client;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalTime getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(LocalTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", doctor=" + doctor +
                ", client=" + client +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", timeCreated=" + timeCreated +
                ", timeUpdated=" + timeUpdated +
                '}';
    }
}


















