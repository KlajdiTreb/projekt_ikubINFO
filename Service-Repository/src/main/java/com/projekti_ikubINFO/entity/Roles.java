package com.projekti_ikubINFO.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Roles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;

    @Column(name = "emri_role")
    private String emri_role;

    @JsonBackReference
    @OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<Punonjes> punonjes;

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getEmri_role() {
        return emri_role;
    }

    public void setEmri_role(String emri_role) {
        this.emri_role = emri_role;
    }

    public Set<Punonjes> getPunonjes() {
        return punonjes;
    }

    public void setPunonjes(Set<Punonjes> punonjes) {
        this.punonjes = punonjes;
    }

    public Roles() {
    }

    public Roles(String emri_role) {
        super();
        this.emri_role = emri_role;
    }

    public Roles(int id_role, String emri_role) {
        super();
        this.id_role = id_role;
        this.emri_role = emri_role;
    }

    public Roles(int id_role, String emri_role, Set<Punonjes> punonjes) {
        this.id_role = id_role;
        this.emri_role = emri_role;
        this.punonjes = punonjes;
    }
}
