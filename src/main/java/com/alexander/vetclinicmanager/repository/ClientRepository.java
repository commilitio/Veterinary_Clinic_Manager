package com.alexander.vetclinicmanager.repository;

import com.alexander.vetclinicmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// <klasa naszej encji ktora zarzadza (Client, typ naszego ID z klasy Client (Long)>
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
                // ponizsze metody okreslaja co bedzie robic ta klasa

    List <Client> findClientByLastNameStartingWith(String string);

    // Metoda save jest już dostarczana przez JpaRepository, więc nie musisz jej dodawać.
    // W przypadku korzystania z JpaRepository, zapisywanie i aktualizowanie odbywa się automatycznie.

}






















