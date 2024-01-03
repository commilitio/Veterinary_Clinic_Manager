package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Client;
import com.alexander.vetclinicmanager.model.Doctor;
import com.alexander.vetclinicmanager.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    public Doctor findById (Long id){
        return doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
    }

    public List <Doctor> findAllDoctors(){
        return doctorRepository.findAll();
    }


    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }


    public void deleteDoctor(Long id){
        Doctor doctorToDelete = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        doctorRepository.delete(doctorToDelete);
    }
}



















