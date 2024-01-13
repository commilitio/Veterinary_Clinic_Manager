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


    @GetMapping("/pets")
    public List<Pet> findAllPets(){
        return petService.findAllPets();
    }

    @PostMapping("/newPet")
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }


    @PatchMapping("/update/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet){
        return petService.updatePet(id, pet);
    }


    @GetMapping("/search")
    public List <Pet> findPetByNameStartingWith(@RequestParam String prefix){
        return petService.findPetByNameStartingWith(prefix);
    }
}































