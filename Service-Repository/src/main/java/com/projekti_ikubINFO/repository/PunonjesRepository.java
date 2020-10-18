package com.projekti_ikubINFO.repository;

import com.projekti_ikubINFO.entity.Punonjes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunonjesRepository extends JpaRepository<Punonjes, Integer> {
}
