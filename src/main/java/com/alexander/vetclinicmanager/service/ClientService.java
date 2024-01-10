package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Address;
import com.alexander.vetclinicmanager.model.Client;
import com.alexander.vetclinicmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;          // wstrzykuje repo
 //   @Lazy
 //   @Autowired
 //   private AddressService addressService;


    public Client findById (Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }


    public List <Client> findAllClients(){
        return clientRepository.findAll();
    }


    @Transactional
    public Client createClient(Client client){
        Address address = client.getAddress();
        if (address != null)
            address.setClient(client);
        return clientRepository.save(client);
    }


    @Transactional
    public void updateClient(Long id, Client client){
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setTelephone(client.getTelephone());
        existingClient.setAccount(client.getAccount());
        existingClient.setAddress(client.getAddress());

        clientRepository.save(existingClient);          // zapis do bazy danych
    }

    public void deleteClient(Long id) {
        Client clientToDelete = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
        clientRepository.delete(clientToDelete);
    }


    public List <Client> findClientByLastNameStartingWith (String prefix){      // prefiks, czyli początkowy fragment nazwiska klienta
        return clientRepository.findClientByLastNameStartingWith(prefix);
    }
}


























