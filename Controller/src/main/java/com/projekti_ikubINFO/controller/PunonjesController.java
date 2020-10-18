package com.projekti_ikubINFO.controller;

import com.projekti_ikubINFO.entity.Punonjes;
import com.projekti_ikubINFO.exceptions.ResourceNotFoundException;
import com.projekti_ikubINFO.services.PunonjesServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/punonjes")
public class PunonjesController {

    private static final Logger logger = LoggerFactory.getLogger(Punonjes.class);

    @Autowired
    private PunonjesServices punonjesServices;

    // CreatMapping
    @PostMapping("/add")
    public void insertPunonjes(@RequestBody Punonjes punonjes) {
        punonjesServices.addPunonjes(punonjes);
        logger.info(" THE PUNONJES IS ADDED INTO DATABASE!");
    }

    // ReadMapping (All Punonjesit, PunonjesById)
    @GetMapping("/all")
    public List<Punonjes> getAllPunonjesit() {
        List<Punonjes> punonjes = punonjesServices.showAllPunonjesit();
        if(punonjes != null) {
            logger.info(" DISPLAY ALL PUNONJESIT!");
            return punonjes;
        }
        logger.error(" NO PUNONJES TO DISPLAY!");
        return null;
    }

    @GetMapping("/{id}")
    public Punonjes getPunonjesinById(@PathVariable int id) throws ResourceNotFoundException {
        if(id < 0)
            logger.error(" NO NEGATIVE NUMBER AS ID!");
        else
            logger.info(" DISPLAY PUNONJES BY ID: " + id);

        return punonjesServices.getPunonjesin(id);
    }

    // UpdateMapping
    @PutMapping("/update/{id}")
    public Punonjes updatePunonjes(@RequestBody Punonjes punonjes, @PathVariable int id) throws ResourceNotFoundException {
        if(id < 0)
            logger.error(" NO NEGATIVE NUMBER AS ID!");
        else
            logger.info("THE PUNONJES: '" + punonjes.getEmri_punonjes() +"' WITH ID: '"+ id + "' IS UPDATED");
        return punonjesServices.updatePunonjes(punonjes, id);
    }

    // DeleteMapping
    @DeleteMapping("/delete/{id}")
    public void deletePunonjesin(@PathVariable int id) throws ResourceNotFoundException {
        if(id < 0)
            logger.error(" NO NEGATIVES NUMBER IN ID!");
        else
            logger.info(" PUNONJES WITH ID: '" + id +"' IS ELIMINATED");
        punonjesServices.deletePunonjesById(id);
    }
}
