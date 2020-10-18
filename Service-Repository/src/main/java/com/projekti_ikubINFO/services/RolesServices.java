package com.projekti_ikubINFO.services;

import com.projekti_ikubINFO.entity.Roles;
import com.projekti_ikubINFO.exceptions.ResourceNotFoundException;
import com.projekti_ikubINFO.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServices {

    @Autowired
    private RolesRepository rolesRepository;

    // Create Roles
    public Roles addRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    // Read All Roles
    public List<Roles> showAllRoles() {
        List<Roles> roles = rolesRepository.findAll();
        System.out.println("Getting data from DB : " + roles);
        return  roles;
    }

    // Read 1 Roles nepermjet id-se
    public Roles getRoles(int id_roles) throws ResourceNotFoundException {
        Roles roles = null;
        if(id_roles < 0) {
            throw new ResourceNotFoundException("Nuk mund te vendosni vlera negative si id!");
        }else {
            roles = this.rolesRepository.findById(id_roles)
                    .orElseThrow(() -> new ResourceNotFoundException("Roli nuk gjendet me id: " + id_roles));
        }
        return roles;
    }
    // Update Roles
    public Roles updateRoles(Roles roles, int id_roles) throws ResourceNotFoundException {
        Roles roliEkziston = this.rolesRepository.findById(id_roles)
                .orElseThrow(() -> new ResourceNotFoundException("Roli nuk gjendet me id: " + id_roles));

        if(roles.getEmri_role().trim() != null && !roles.getEmri_role().trim().isEmpty()) {
            roliEkziston.setEmri_role(roles.getEmri_role());
        } else {
            throw new ResourceNotFoundException("Keni harruar te vendosni Emrin e Rolit!");
        }

        return this.rolesRepository.save(roliEkziston);
    }

    // Delete Roles
    public void deleteRolesById(int id_roles)throws ResourceNotFoundException {
        if(id_roles < 0)
            throw new ResourceNotFoundException("Nuk mund te vendosni vlera negative si id!");
        else {
            Roles roliEkziston = this.rolesRepository.findById(id_roles)
                    .orElseThrow(() -> new ResourceNotFoundException("Roli nuk gjendet me id: " + id_roles));
            this.rolesRepository.delete(roliEkziston);
        }
    }
}
