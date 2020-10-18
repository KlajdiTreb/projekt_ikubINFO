package com.projekti_ikubINFO.services;

import com.projekti_ikubINFO.entity.Departament;
import com.projekti_ikubINFO.exceptions.ResourceNotFoundException;
import com.projekti_ikubINFO.repository.DepartamentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(Departament.class);

    @Autowired
    private DepartamentRepository departamentRepository;

    // Create Departament
    public void addDepartament(Departament departament) {
        departamentRepository.save(departament);
    }

    // Read All Departament
    public List<Departament> showAllDepartament() {
        return departamentRepository.findAll();
    }

    // Read 1 Departament nepermjet id-se
    public Departament getDepartament(int id_departament) throws ResourceNotFoundException{
        Departament departament = null;
        if(id_departament < 0) {
            throw new ResourceNotFoundException("Nuk mund te vendosni vlera negative si id!");
        } else {
            departament = this.departamentRepository.findById(id_departament)
                    .orElseThrow(() -> new ResourceNotFoundException("Departamenti nuk gjendet me id: " + id_departament));
        }
        return departament;
    }

    // Update Departament
    public Departament updateDepartament(Departament departament, int id_departament) throws ResourceNotFoundException {
        Departament departamentEkziston = this.departamentRepository.findById(id_departament)
                .orElseThrow(() -> new ResourceNotFoundException("Departamenti nuk gjendet me id: " + id_departament));

        if(departament.getEmri_departament().trim() != null && !departament.getEmri_departament().trim().isEmpty()) {
            departamentEkziston.setEmri_departament(departament.getEmri_departament());
        } else {
            throw new ResourceNotFoundException("Keni harruar te vendosni Emrin e Departamentit!");
        }

        return this.departamentRepository.save(departamentEkziston);
    }

    // Delete Departament
    public void deleteDepartamentById(int id_departament)throws ResourceNotFoundException {
        if(id_departament < 0)
            throw new ResourceNotFoundException("Nuk mund te vendosni vlera negative si id!");
        else {
            Departament departamentEkzistion = this.departamentRepository.findById(id_departament)
                    .orElseThrow(() -> new ResourceNotFoundException("Departamenti nuk gjendet me id: " + id_departament));
            this.departamentRepository.delete(departamentEkzistion);
        }
    }
}
