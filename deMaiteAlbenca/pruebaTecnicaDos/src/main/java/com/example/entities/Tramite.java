package com.example.entities;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
@Entity  // Aquí es donde se marca como una entidad de JPA y se me olvido
@Table(name = "Tramite")
public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;

    //inlcuyo el tipo Duration que es util para contabilizar el tiempo, en la base de datos es de tipo TIME
    @Column(nullable = false)
    private Duration duracionEstimada;

    @OneToMany(mappedBy = "tramite", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Turno> turnos = new HashSet<>();
    //contructor

    public Tramite() {
    }
    public Tramite(String nombre, String descripcion, Duration duracionEstimada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionEstimada = duracionEstimada;
        this.turnos = new HashSet<>();
    }

    //getters and setters

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

    public Duration getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(Duration duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    //tostring

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
