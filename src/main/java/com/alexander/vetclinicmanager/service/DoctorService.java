package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Doctor;
import com.alexander.vetclinicmanager.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    List <Doctor> findAllDoctors(){
        return doctorRepository.findAll();
    }

}



















