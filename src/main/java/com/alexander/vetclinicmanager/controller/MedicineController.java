package com.alexander.vetclinicmanager.controller;

import com.alexander.vetclinicmanager.model.Medicine;
import com.alexander.vetclinicmanager.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }


    @GetMapping("/medicine")
    public List <Medicine> findAllMedicine(){
        return medicineService.findAllMedicine();
    }


    @PostMapping("/newMedicine")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineService.createMedicine(medicine);
    }


    @PatchMapping("/update/{id}")
    public Medicine updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine){
        return medicineService.updateMedicine(id, medicine);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMedicine(@PathVariable Long id){
        medicineService.deleteMedicine(id);
    }
}























