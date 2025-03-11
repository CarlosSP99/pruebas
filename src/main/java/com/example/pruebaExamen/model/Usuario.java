package com.example.pruebaExamen.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_gen")
    @SequenceGenerator(name = "usuario_id_gen", sequenceName = "usuario_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "licensenumber", nullable = false)
    private String licensenumber;

    @Column(name = "csp_edad")
    private String cspEdad;

    @Column(name = "csp_color_de_pelo")
    private String cspColorDePelo;

    @OneToMany(mappedBy = "userid")
    private Set<Alquiler> alquilers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    public String getCspEdad() {
        return cspEdad;
    }

    public void setCspEdad(String cspEdad) {
        this.cspEdad = cspEdad;
    }

    public String getCspColorDePelo() {
        return cspColorDePelo;
    }

    public void setCspColorDePelo(String cspColorDePelo) {
        this.cspColorDePelo = cspColorDePelo;
    }

    public Set<Alquiler> getAlquilers() {
        return alquilers;
    }

    public void setAlquilers(Set<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }

}