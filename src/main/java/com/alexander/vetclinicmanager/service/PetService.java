package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Pet;
import com.alexander.vetclinicmanager.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet not found"));
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public void updatePet(Pet pet) {
        Pet existingPet = petRepository.findById(pet.getId())
                .orElseThrow(() -> new IllegalArgumentException("Pet not found"));

        existingPet.setName(pet.getName());
        existingPet.setAge(pet.getAge());
        existingPet.setBreed(pet.getBreed());
        existingPet.setColor(pet.getColor());
        existingPet.setGender(pet.getGender());

        petRepository.save(existingPet);
    }

    public List<Pet> findPetByNameStartingWith(String prefix) {
        return petRepository.findPetByNameStartingWith(prefix);
    }
}





















