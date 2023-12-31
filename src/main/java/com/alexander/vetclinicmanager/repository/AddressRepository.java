package com.alexander.vetclinicmanager.repository;

import com.alexander.vetclinicmanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository <Address, Long> {

    List <Address> findAddressByStreetStartingWith (String prefix);
}






















