package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.persistence.GenericoJPA;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TurnoController {
    private final GenericoJPA<Turno, Long> turnoJPA = new GenericoJPA<>(Turno.class);
    private final GenericoJPA<Ciudadano, Long> ciudadanoJPA = new GenericoJPA<>(Ciudadano.class);
    private final GenericoJPA<Tramite, Long> tramiteJPA = new GenericoJPA<>(Tramite.class);
    //los metodos de turno incluyendo un filtro para las busquedas

    //para agregar un nuevo turno
    public void createTurno(Long ciudadanoId, Long tramiteId, Turno turno) {
        if (ciudadanoId == null || tramiteId == null) {
            throw new IllegalArgumentException("El ID del ciudadano y del trámite no pueden ser nulos.");
        }
        if (turno == null) {
            throw new IllegalArgumentException("El turno no puede ser nulo.");
        }

        // Buscar ciudadano y trámite
        Ciudadano ciudadano = ciudadanoJPA.findOne(ciudadanoId);
        Tramite tramite = tramiteJPA.findOne(tramiteId);

        if (ciudadano == null) {
            throw new IllegalArgumentException("El ciudadano con ID " + ciudadanoId + " no existe.");
        }
        if (tramite == null) {
            throw new IllegalArgumentException("El trámite con ID " + tramiteId + " no existe.");
        }

        // Configurar los datos del turno
        turno.setCiudadano(ciudadano);
        turno.setTramite(tramite);
        turno.setFecha(LocalDate.now());
        turno.setEstado("En espera");

        // Guardar el turno en la base de datos
        turnoJPA.create(turno);
    }

    //para encontrar un turno por id
    public Turno findOneTurno(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del turno no puede ser nulo.");
        }
        return turnoJPA.findOne(id);
    }

    public List<Turno> findAllTurno() {
        return turnoJPA.findAll();
    }

    public void updateTurno(Turno turno) {
        turnoJPA.update(turno);
    }
    //Para eliminar turnos
    public void deleteTurno(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        turnoJPA.delete(id);
    }

    //para filtrar los turnos
    public List<Turno> filterTurno(LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        List<Turno> todosLosTurnos = turnoJPA.findAll();
        return todosLosTurnos.stream()
                .filter(turno -> !turno.getFecha().isBefore(fechaInicio)) // Fecha mayor o igual que inicio
                .filter(turno -> !turno.getFecha().isAfter(fechaFin))     // Fecha menor o igual que fin
                .filter(turno -> estado == null || estado.isEmpty() || turno.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }
}
