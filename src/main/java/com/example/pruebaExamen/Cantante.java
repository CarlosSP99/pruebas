package com.example.pruebaExamen;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cantante")
public class Cantante {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duracion")
    private Integer duracion;

    @OneToMany(mappedBy = "cantante")
    private Set<Cancion> cancions = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Set<Cancion> getCancions() {
        return cancions;
    }

    public void setCancions(Set<Cancion> cancions) {
        this.cancions = cancions;
    }


    public Cantante(Long id, String name, Integer duracion, Set<Cancion> cancions) {
        this.name = name;
        this.duracion = duracion;
        this.cancions = cancions;
    }

    public Cantante() {
    }
}