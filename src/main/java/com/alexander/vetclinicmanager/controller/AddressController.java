package com.alexander.vetclinicmanager.controller;

import com.alexander.vetclinicmanager.model.Address;
import com.alexander.vetclinicmanager.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id){
        return addressService.findById(id);
    }


    @PostMapping("/newAddress")
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }


    @PutMapping("/update/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }


    @GetMapping("/search")
    public List<Address> findAddressByStreetStartingWith(@RequestParam String prefix){
        return addressService.findAddressByStreetStartingWith(prefix);
    }
}






















