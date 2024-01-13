package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Medicine;
import com.alexander.vetclinicmanager.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepository;


    public List<Medicine> findAllMedicine (){
        return medicineRepository.findAll();
    }


    public Medicine createMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }


    @Transactional
    public Medicine updateMedicine(Long id, Medicine medicine){
        Medicine existingMedicine = medicineRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Medicine not found"));

        existingMedicine.setName(medicine.getName());
        existingMedicine.setPrice(medicine.getPrice());
        existingMedicine.setStock(medicine.getStock());

        return medicineRepository.save(existingMedicine);
    }


    public void deleteMedicine(Long id){
        Medicine existingMedicine = medicineRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Medicine not found"));

        medicineRepository.delete(existingMedicine);
    }
}





















