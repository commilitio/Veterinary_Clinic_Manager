package com.alexander.vetclinicmanager.repository;

import com.alexander.vetclinicmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// <klasa naszej encji ktora zarzadza (Client, typ naszego ID z klasy Client (Long)>
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List <Client> findClientByLastNameStartingWith(String prefix);

    // Metoda save jest już dostarczana przez JpaRepository, więc nie musisz jej dodawać.
    // W przypadku korzystania z JpaRepository, zapisywanie i aktualizowanie odbywa się automatycznie.
}






















