package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Client;
import com.alexander.vetclinicmanager.model.Visit;
import com.alexander.vetclinicmanager.repository.ClientRepository;
import com.alexander.vetclinicmanager.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;          // wstrzykuje repo
    @Autowired
    private VisitRepository visitRepository;            // ?


    public Client findById (Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
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

    public Visit addVisit(Client client, Visit visit){
        visit.setClient(client);
        return visitRepository.save(visit);
    }

}


























