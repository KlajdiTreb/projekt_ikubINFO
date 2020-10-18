package com.projekti_ikubINFO.controller;

import com.projekti_ikubINFO.entity.Departament;
import com.projekti_ikubINFO.entity.Roles;
import com.projekti_ikubINFO.exceptions.ResourceNotFoundException;
import com.projekti_ikubINFO.services.DepartamentServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departament")
public class DepartamentController {

    private static final Logger logger = LoggerFactory.getLogger(Roles.class);

    @Autowired
    private DepartamentServices departamentServices;

    // CreateMapping
    @PostMapping("/add")
    public void insertDepartament(@RequestBody Departament departament) {
        departamentServices.addDepartament(departament);
        logger.info(" THE DEPARTAMENT IS ADDED INTO DATABASE!");
    }

    // ReadMapping (All Departament, DepartamentById)
    @GetMapping("/all")
    public List<Departament> getAllDepartament() {
        List<Departament> departaments = departamentServices.showAllDepartament();
        if(departaments != null) {
            logger.info(" DISPLAY ALL DEPARTAMENT!");
            return departaments;
        }
        logger.error(" NO DEPARTAMENT TO DISPLAY!");
        return null;
    }

    @GetMapping("/{id}")
    public Departament getDepartamentById(@PathVariable int id) throws ResourceNotFoundException {
        if(id < 0)
            logger.error(" NO NEGATIVE NUMBER AS ID!");
        else
            logger.info(" DISPLAY DEPARTAMENT BY ID: " + id);
        return departamentServices.getDepartament(id);
    }

    // UpdateMapping
    @PutMapping("/update/{id}")
    public Departament updateDepartament(@RequestBody Departament departament, @PathVariable int id) throws ResourceNotFoundException{
        if(id < 0)
            logger.error(" NO NEGATIVE NUMBER AS ID!");
        else
            logger.info("THE DEPARTAMENT IS UPDATED");
        return departamentServices.updateDepartament(departament, id);
    }

    // DeleteMapping
    @DeleteMapping("/delete/{id}")
    public void deleteDepartament(@PathVariable int id) throws ResourceNotFoundException {
        if(id < 0)
            logger.error(" NO NEGATIVES NUMBER IN ID!");
        else
            logger.info(" DEPARTAMENT WITH ID: '" + id +"' IS ELIMINATED");
        departamentServices.deleteDepartamentById(id);
    }
}
