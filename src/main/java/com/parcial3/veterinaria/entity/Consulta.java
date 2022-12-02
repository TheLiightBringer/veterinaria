package com.parcial3.veterinaria.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "consultas")
public class Consulta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String raza;
    private String nombre;
    @Column(name = "nombrepet")
    private String nombrePet;
    private String causa;
    private String img;

    public Consulta() {
    }

    public Consulta(String raza, String nombre, String nombrePet, String causa, String img) {
        this.raza = raza;
        this.nombre = nombre;
        this.nombrePet = nombrePet;
        this.causa = causa;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePet() {
        return nombrePet;
    }

    public void setNombrePet(String nombrePet) {
        this.nombrePet = nombrePet;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
