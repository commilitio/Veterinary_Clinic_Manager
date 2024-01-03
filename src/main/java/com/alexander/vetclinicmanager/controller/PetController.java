package com.alexander.vetclinicmanager.controller;

import com.alexander.vetclinicmanager.model.Pet;
import com.alexander.vetclinicmanager.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    public final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/{id}")
    public Pet findById(@PathVariable Long id){
        return petService.findById(id);
    }


    @PostMapping("/newPet")
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }


    @PutMapping("/update/{id}")
    public void updatePet(@PathVariable Long id, @RequestBody Pet pet){
        petService.updatePet(id, pet);
    }


    @GetMapping("/search")
    public List <Pet> findPetByNameStartingWith(@RequestParam String prefix){
        return petService.findPetByNameStartingWith(prefix);
    }
}































