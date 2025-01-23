package com.example.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity  // Aquí es donde se marca como una entidad de JPA y se me olvido
@Table(name = "Ciudadano",
uniqueConstraints = @UniqueConstraint(columnNames = {"documentoIdentidad", "numSS"}))

public class Ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    @Column(nullable = false, unique = true)
    private String documentoIdentidad; // DNI o equivalente, único
    @Column(nullable = false, unique = true)
    private String numSS; // Número de Seguridad Social
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "ciudadano", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Turno> turnos;

    public Ciudadano() {
    }

    public Ciudadano(String nombre, String apellidos, String documentoIdentidad, String numSS, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
        this.numSS = numSS;
        this.fechaNacimiento = fechaNacimiento;
        this.turnos = new HashSet<>();
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Ciudadano{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", numSS='" + numSS + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
