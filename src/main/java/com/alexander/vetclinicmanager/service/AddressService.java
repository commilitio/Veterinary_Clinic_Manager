package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Address;
import com.alexander.vetclinicmanager.model.Client;
import com.alexander.vetclinicmanager.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ClientService clientService;


    public Address findById(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }

    @Transactional
    public Address createAddress(Address address){
        Client client = address.getClient();
        if (client != null) {
            client.setAddress(address);
            clientService.createClient(client);
        }
        return addressRepository.save(address);
    }


    @Transactional
    public Address updateAddress(Long id, Address address){
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));

        existingAddress.setCity(address.getCity());
        existingAddress.setZipCode(address.getZipCode());
        existingAddress.setStreet(address.getStreet());
        existingAddress.setHouseNumber(address.getHouseNumber());
        existingAddress.setApartmentNumber(address.getApartmentNumber());

        return addressRepository.save(existingAddress);
    }

    public List <Address> findAddressByStreetStartingWith(String prefix){
        return addressRepository.findAddressByStreetStartingWith(prefix);
    }
}























