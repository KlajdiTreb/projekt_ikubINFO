package com.projekti_ikubINFO.entity;

import javax.persistence.*;

@Entity
@Table(name = "Punonjes")
public class Punonjes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_punonjes;

    @Column(name = "emri_punonjes")
    private String emri_punonjes;

    @Column(name = "mbiemri_punonjes")
    private String mbiemri_punonjes;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "departament_id")
    private Departament departament;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Roles roles;

    public int getId_punonjes() {
        return id_punonjes;
    }

    public void setId_punonjes(int id_punonjes) {
        this.id_punonjes = id_punonjes;
    }

    public String getEmri_punonjes() {
        return emri_punonjes;
    }

    public void setEmri_punonjes(String emri_punonjes) {
        this.emri_punonjes = emri_punonjes;
    }

    public String getMbiemri_punonjes() {
        return mbiemri_punonjes;
    }

    public void setMbiemri_punonjes(String mbiemri_punonjes) {
        this.mbiemri_punonjes = mbiemri_punonjes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Punonjes() {
    }

    public Punonjes(int id_punonjes, String emri_punonjes, String mbiemri_punonjes, String password, String email, Departament departament, Roles roles) {
        super();
        this.id_punonjes = id_punonjes;
        this.emri_punonjes = emri_punonjes;
        this.mbiemri_punonjes = mbiemri_punonjes;
        this.password = password;
        this.email = email;
        this.departament = departament;
        this.roles = roles;
    }
}
