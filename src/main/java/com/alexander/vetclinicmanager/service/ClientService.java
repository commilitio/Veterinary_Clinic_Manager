package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Client;
import com.alexander.vetclinicmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;          // wstrzykuje repo


    public Client findById (Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }


    public List <Client> findAllClients(){
        return clientRepository.findAll();
    }


    public Client createClient(Client client){            // dobrze ?
        return clientRepository.save(client);
    }


    @Transactional
    public void updateClient(Client client){
        Client existingClient = clientRepository.findById(client.getId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setTelephone(client.getTelephone());
        existingClient.setAccount(client.getAccount());
        existingClient.setAddress(client.getAddress());

        clientRepository.save(existingClient);          // zapis do bazy danych
    }


    public void deleteClient(Client client){            // void !
        clientRepository.delete(client);
    }


    public List <Client> findClientByLastNameStartingWith (String prefix){      // prefiks, czyli początkowy fragment nazwiska klienta
        return clientRepository.findClientByLastNameStartingWith(prefix);
    }
}


























