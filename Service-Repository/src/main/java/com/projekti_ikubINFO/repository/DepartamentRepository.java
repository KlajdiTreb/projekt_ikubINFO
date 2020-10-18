package com.projekti_ikubINFO.repository;

import com.projekti_ikubINFO.entity.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
