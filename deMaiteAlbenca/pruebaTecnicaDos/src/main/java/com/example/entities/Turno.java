package com.example.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;

@Entity  // Aquí es donde se marca como una entidad de JPA y se me olvido
@Table(name = "Turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int numeroTurno;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    //sin el parametro hora no se puede gestionar las citas
    private Time hora;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String estado; // "En espera" o "Ya atendido"

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Ciudadano ciudadano;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tramite_id", nullable = false)
    private Tramite tramite;

    //constructor

    public Turno() {
    }

    public Turno(Long id, int numeroTurno, LocalDate fecha, Time hora, String descripcion, String estado, Ciudadano ciudadano, Tramite tramite) {
        this.id = id;
        this.numeroTurno = numeroTurno;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ciudadano = ciudadano;
        this.tramite = tramite;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }
//tostring

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", numeroTurno=" + numeroTurno +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", ciudadano=" + ciudadano +
                ", tramite=" + tramite +
                '}';
    }
}
