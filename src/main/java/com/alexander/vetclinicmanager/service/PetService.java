package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Pet;
import com.alexander.vetclinicmanager.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;


    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found"));
    }


    public List<Pet> findAllPets(){
        return petRepository.findAll();
    }


    public Pet createPet(Pet pet) {
        pet.calculateAge();
        return petRepository.save(pet);
    }


    @Transactional
    public Pet updatePet(Long id, Pet pet) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found"));

        existingPet.setName(pet.getName());
        existingPet.setBirthdate(pet.getBirthdate());
        existingPet.setType(pet.getType());
        existingPet.setBreed(pet.getBreed());
        existingPet.setColor(pet.getColor());
        existingPet.setGender(pet.getGender());
        existingPet.calculateAge();

        return petRepository.save(existingPet);
    }


    public List<Pet> findPetByNameStartingWith(String prefix) {
        return petRepository.findPetByNameStartingWith(prefix);
    }
}





















