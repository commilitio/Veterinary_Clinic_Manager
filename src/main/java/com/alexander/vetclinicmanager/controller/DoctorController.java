package com.alexander.vetclinicmanager.controller;


import com.alexander.vetclinicmanager.model.Doctor;
import com.alexander.vetclinicmanager.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/{id}")
    public Doctor findById (@PathVariable Long id){
        return doctorService.findById(id);
    }

    @GetMapping("/doctors")
    public List<Doctor> findAllDoctors(){
        return doctorService.findAllDoctors();
    }


    @PostMapping("/newDoctor")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
    }
}





















