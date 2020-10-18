package com.projekti_ikubINFO.controller;

import com.projekti_ikubINFO.entity.Roles;
import com.projekti_ikubINFO.exceptions.ResourceNotFoundException;
import com.projekti_ikubINFO.services.RolesServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private static final Logger logger = LoggerFactory.getLogger(Roles.class);

    @Autowired
    private RolesServices rolesServices;

    // CreateMapping
    @PostMapping("/add")
    public void insertRoles(@RequestBody Roles roles) {
        rolesServices.addRoles(roles);
        logger.info(" THE ROLE IS ADDED INTO DATABASE!");
    }

    // ReadMapping (All Roles, RolesById)
    @GetMapping("/all")
    public List<Roles> getAllRoles() {
        List<Roles> roles = rolesServices.showAllRoles();
        if(roles != null) {
            logger.info(" DISPLAY ALL ROLES!");
            return roles;
        }
        logger.error(" NO ROLES TO DISPLAY!");
        return null;
    }

    @GetMapping("/{id}")
    public Roles getRolesById(@PathVariable int id) throws ResourceNotFoundException {
        if(id < 0)
            logger.error(" NO NEGATIVE NUMBER AS ID!");
        else
            logger.info(" DISPLAY ROLES BY ID: " + id);
        return rolesServices.getRoles(id);
    }

    // UpdateMapping
    @PutMapping("/update/{id}")
    public Roles updateRoles(@RequestBody Roles roles, @PathVariable int id) throws ResourceNotFoundException{
        if(id < 0)
            logger.error(" NO NEGATIVE NUMBER AS ID!");
        else
            logger.info("THE ROLES IS UPDATED");
        return rolesServices.updateRoles(roles, id);
    }

    // DeleteMapping
    @DeleteMapping("/delete/{id}")
    public void deleteRoles(@PathVariable int id) throws ResourceNotFoundException {
        if(id < 0)
            logger.error(" NO NEGATIVES NUMBER IN ID!");
        else
            logger.info(" ROLES WITH ID: '" + id +"' IS ELIMINATED");

        rolesServices.deleteRolesById(id);
    }
}
