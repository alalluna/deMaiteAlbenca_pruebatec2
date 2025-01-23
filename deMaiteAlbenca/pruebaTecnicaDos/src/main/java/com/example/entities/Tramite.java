package com.example.entities;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tramite", //no salia porque no lo asocie a una tabla sql Tramite.
uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))

public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //lo pongo unico para evitar el error de duplicidad aunque no ha sido suficiente, tendré que validar
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    //al final uso tipo de dato TIME compatible con utils.calendar en el metodo auxiliar
    @Column(nullable = false)
    private Time duracionEstimada;

    @OneToMany(mappedBy = "tramite", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Turno> turnos = new HashSet<>();

    //Me faltaba un constructor que tenga solo tres parametros para la solicitud post del formulario
    public Tramite() {
    }

    public Tramite(String nombre, String descripcion, Time duracionEstimada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionEstimada = duracionEstimada;
    }
    public Tramite(Long id, String nombre, String descripcion, Time duracionEstimada, Set<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionEstimada = duracionEstimada;
        this.turnos = turnos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(Time duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Tramite{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracionEstimada=" + duracionEstimada +
                '}';
    }
}
