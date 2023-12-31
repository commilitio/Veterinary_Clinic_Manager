package com.alexander.vetclinicmanager.repository;

import com.alexander.vetclinicmanager.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository <Pet, Long> {

    List <Pet> findPetByNameStartingWith (String prefix);
}
