package com.projekti_ikubINFO.services;

import com.projekti_ikubINFO.entity.Punonjes;
import com.projekti_ikubINFO.exceptions.ResourceNotFoundException;
import com.projekti_ikubINFO.repository.PunonjesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunonjesServices {

    @Autowired
    private PunonjesRepository punonjesRepository;

    // Create Punonjes
    public void addPunonjes(Punonjes punonjes){
        punonjesRepository.save(punonjes);
    }

    // Read All Punonjes
    public List<Punonjes> showAllPunonjesit() {
        return punonjesRepository.findAll();
    }

    // Read 1 Punonjes nepermjet id-se
    public Punonjes getPunonjesin(int id_punonjes) throws ResourceNotFoundException {
        Punonjes punonjes = null;
        if(id_punonjes < 0)
            throw new ResourceNotFoundException("Nuk mund te vendosni vlera negative si id!");
        else {
            punonjes = this.punonjesRepository.findById(id_punonjes).orElseThrow(() -> new ResourceNotFoundException("Punonjesi nuk gjendet me id: " + id_punonjes));
        }
        return punonjes;
    }

    // Update Punonjes
    public Punonjes updatePunonjes(Punonjes punonjes, int id_punonjes) throws ResourceNotFoundException {
        Punonjes punonjesEkziston  = this.punonjesRepository.findById(id_punonjes)
                    .orElseThrow(() -> new ResourceNotFoundException("Nuk ekzistion Punonjes me id: " + id_punonjes));

        if(punonjes.getEmri_punonjes().trim() != null && !punonjes.getEmri_punonjes().trim().isEmpty()) {
            punonjesEkziston.setEmri_punonjes(punonjes.getEmri_punonjes());
        } else {
            throw new ResourceNotFoundException("Keni harruar te vendosni Emrin e Punonjesit!");
        }

        if(punonjes.getMbiemri_punonjes().trim() != null && !punonjes.getMbiemri_punonjes().trim().isEmpty()) {
            punonjesEkziston.setMbiemri_punonjes(punonjes.getMbiemri_punonjes());
        } else {
            throw new ResourceNotFoundException("Keni harruar te vendosni Mbiemrin e Punonjesit!");
        }

        if(punonjes.getEmail().trim() != null && !punonjes.getEmail().trim().isEmpty()) {
            punonjesEkziston.setEmail(punonjes.getEmail());
        } else {
            throw new ResourceNotFoundException("Keni harruar te vendosni Email-in e Punonjesit!");
        }

        if(punonjes.getPassword().trim() != null && !punonjes.getPassword().trim().isEmpty()) {
            punonjesEkziston.setPassword(punonjes.getPassword());
        } else {
            throw new ResourceNotFoundException("Keni harruar te vendosni Password-in e Punonjesit!");
        }

        punonjesEkziston.setDepartament(punonjes.getDepartament());
        punonjesEkziston.setRoles(punonjes.getRoles());

        return this.punonjesRepository.save(punonjesEkziston);
    }

    // Delete Punonjes
    public void deletePunonjesById(int id_punonjes) throws ResourceNotFoundException {

        if(id_punonjes < 0)
            throw new ResourceNotFoundException("Nuk mund te vendosni vlera negative si id!");
        else {
            Punonjes punonjesEkzistion = this.punonjesRepository.findById(id_punonjes)
                    .orElseThrow(() -> new ResourceNotFoundException("Punonjesi nuk gjendet me id: " + id_punonjes));
            this.punonjesRepository.delete(punonjesEkzistion);
        }
    }
}
