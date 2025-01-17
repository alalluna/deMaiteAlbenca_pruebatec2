package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.persistence.GenericoJPA;
import com.example.utils.Validations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TurnoController {
    private final GenericoJPA<Turno, Long> turnoJPA = new GenericoJPA<>(Turno.class);
    private final GenericoJPA<Ciudadano, Long> ciudadanoJPA = new GenericoJPA<>(Ciudadano.class);
    private final GenericoJPA<Tramite, Long> tramiteJPA = new GenericoJPA<>(Tramite.class);
    //los metodos de turno incluyendo un filtro para las busquedas

    //para agregar un nuevo turno
    public void createTurno(Long ciudadanoId, Long tramiteId, Turno turno) {
        Validations.notNull(ciudadanoId, "El ID del ciudadano no puede ser nulo.");
        Validations.notNull(tramiteId, "El ID del tramite no puede ser nulo.");
        Validations.notNull(turno, "El turno no puede ser nulo.");

        // Buscar ciudadano y trámite con findOne
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
        Validations.notNull(id, "El ID del turno no puede ser nulo.");
        return turnoJPA.findOne(id);
    }

    public List<Turno> findAllTurno() {
        return turnoJPA.findAll();
    }

    public void updateTurno(Turno turno) {
        Validations.notNull(turno, "El ID del turno no puede ser nulo.");
        turnoJPA.update(turno);
    }
    //Para eliminar turnos
    public void deleteTurno(Long id) {
        Validations.notNull(id, "El ID del turno no puede ser nulo.");
        turnoJPA.delete(id);
    }

    //para filtrar los turnos
    public List<Turno> filterTurno(LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        Validations.notNull(fechaInicio, "La fecha de inicio no puede ser nula.");
        Validations.notNull(fechaFin, "La fecha de fin no puede ser nula.");

        List<Turno> todosLosTurnos = turnoJPA.findAll();
        Validations.notEmpty(todosLosTurnos, "no se encontraron turnos");

        // Validar los dos estados con optional.ofNullable
        Optional<String> optionalEstado = Optional.ofNullable(estado)
                .filter(e -> e.equalsIgnoreCase("En espera") || e.equalsIgnoreCase("Ya atendido"));

        return todosLosTurnos.stream()
                .filter(turno -> !turno.getFecha().isBefore(fechaInicio)) // Fecha mayor o igual que inicio
                .filter(turno -> !turno.getFecha().isAfter(fechaFin))     // Fecha menor o igual que fin
                .filter(turno -> optionalEstado
                        .map(e -> turno.getEstado().equalsIgnoreCase(e)) // Validar el estado si está presente
                        .orElse(true))
                .collect(Collectors.toList());
    }
}
