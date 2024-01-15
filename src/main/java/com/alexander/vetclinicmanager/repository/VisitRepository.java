package com.alexander.vetclinicmanager.repository;

import com.alexander.vetclinicmanager.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    List <Visit> findByDateCreated(LocalDate date);             // wyszukuje po dacie wizyty
}




















