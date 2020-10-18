package com.projekti_ikubINFO.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Departament")
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_departament;

    @Column(name = "emri_departament")
    private String emri_departament;

    @JsonBackReference
    @OneToMany(mappedBy = "departament", cascade = CascadeType.ALL)
    private Set<Punonjes> punonjes;

    public int getId_departament() {
        return id_departament;
    }

    public void setId_departament(int id_departament) {
        this.id_departament = id_departament;
    }

    public String getEmri_departament() {
        return emri_departament;
    }

    public void setEmri_departament(String emri_departament) {
        this.emri_departament = emri_departament;
    }

    public Set<Punonjes> getPunonjes() {
        return punonjes;
    }

    public void setPunonjes(Set<Punonjes> punonjes) {
        this.punonjes = punonjes;
    }

    public Departament() {
    }

    public Departament(int id_departament, String emri_departament) {
        this.id_departament = id_departament;
        this.emri_departament = emri_departament;
    }
}
