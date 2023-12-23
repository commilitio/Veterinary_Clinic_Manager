package com.alexander.vetclinicmanager.repository;

import com.alexander.vetclinicmanager.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository <Pet, Long> {

    List <Pet> findPetByNameStartingWith (String name);
}