package com.example.pruebaExamen.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alquiler_id_gen")
    @SequenceGenerator(name = "alquiler_id_gen", sequenceName = "alquiler_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private Usuario userid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carid")
    private Coche carid;

    @Column(name = "rentaldate", nullable = false)
    private Instant rentaldate;

    @Column(name = "returndate")
    private Instant returndate;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "csp_ciudad")
    private String cspCiudad;

    @Column(name = "csp_pais")
    private String cspPais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUserid() {
        return userid;
    }

    public void setUserid(Usuario userid) {
        this.userid = userid;
    }

    public Coche getCarid() {
        return carid;
    }

    public void setCarid(Coche carid) {
        this.carid = carid;
    }

    public Instant getRentaldate() {
        return rentaldate;
    }

    public void setRentaldate(Instant rentaldate) {
        this.rentaldate = rentaldate;
    }

    public Instant getReturndate() {
        return returndate;
    }

    public void setReturndate(Instant returndate) {
        this.returndate = returndate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCspCiudad() {
        return cspCiudad;
    }

    public void setCspCiudad(String cspCiudad) {
        this.cspCiudad = cspCiudad;
    }

    public String getCspPais() {
        return cspPais;
    }

    public void setCspPais(String cspPais) {
        this.cspPais = cspPais;
    }

}