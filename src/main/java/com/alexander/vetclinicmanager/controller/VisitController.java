package com.alexander.vetclinicmanager.controller;

import com.alexander.vetclinicmanager.model.Visit;
import com.alexander.vetclinicmanager.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }


    @GetMapping("/{id}")
    public Visit findById(@PathVariable Long id){
        return visitService.findById(id);
    }


    @PostMapping("/newVisit")
    public Visit createVisit(@RequestBody Visit visit){
        return visitService.createVisit(visit);
    }


    @PatchMapping("/update/{id}")
    public Visit updateVisit(@PathVariable Long id, @RequestBody Visit visit){
        return visitService.updateVisit(id, visit);
    }


    @GetMapping("/search")              // param czy body ?
    public List <Visit> findByDateCreated (@RequestParam LocalDateTime date){
        return visitService.findByDateCreated(date);
    }
}
























