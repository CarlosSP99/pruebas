package com.example.pruebaExamen.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "coche")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coche_id_gen")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "platenumber", nullable = false)
    private String platenumber;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private Integer year;

    @ColumnDefault("true")
    @Column(name = "available")
    private Boolean available;

    @Column(name = "csp_precio")
    private String cspPrecio;

    @OneToMany(mappedBy = "carid")
    private Set<Alquiler> alquilers = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getCspPrecio() {
        return cspPrecio;
    }

    public void setCspPrecio(String cspPrecio) {
        this.cspPrecio = cspPrecio;
    }

    public Set<Alquiler> getAlquilers() {
        return alquilers;
    }

    public void setAlquilers(Set<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }

}