package com.alexander.vetclinicmanager.repository;

import com.alexander.vetclinicmanager.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// <klasa naszej encji ktora zarzadza (Owner), typ naszego ID z klasy Owner (Long)>
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
