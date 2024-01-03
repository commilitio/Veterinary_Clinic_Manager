package com.alexander.vetclinicmanager.service;

import com.alexander.vetclinicmanager.model.Visit;
import com.alexander.vetclinicmanager.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;


    public Visit findById(Long id){
        return visitRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Visit not found"));
    }


    public Visit createVisit(Visit visit){
        return visitRepository.save(visit);
    }

    @Transactional
    public Visit updateVisit(Long id, Visit visit){
        Visit existingVisit = visitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found"));

        existingVisit.setDescription(visit.getDescription());
        existingVisit.setLastUpdated(visit.getLastUpdated());

        return visitRepository.save(existingVisit);
    }


    public List <Visit> findByDateCreated(LocalDateTime date){
        return visitRepository.findByDateCreated(date);
    }
}




















