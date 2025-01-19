package com.example.controllers;

import com.example.entities.Tramite;
import com.example.persistence.GenericoJPA;
import com.example.utils.FormatNumbers;
import com.example.utils.Validations;

import java.sql.Time;
import java.util.List;

public class TramiteController {
    private final GenericoJPA<Tramite, Long> tramiteJPA = new GenericoJPA<>(Tramite.class);
    //He creado el crud entero, aunque no se si me dará tiempo para usar todos los metodos
    public void createTramite(String nombre, String descripcion, String duracionEstimadaStr) {

        Validations.StringNotEmpty(nombre,"El nombre no puede estar vacio");
        Validations.StringNotEmpty(descripcion, "La descripcion del tramite no puede estar vacia.");
        Validations.StringNotEmpty(duracionEstimadaStr, "La duración estimada no puede estar vacía.");
        //convertir la duracion con el metodo
        Time duracionEstimada = FormatNumbers.formatTime(duracionEstimadaStr);
        //nueva instancia y crear
        Tramite tramite = new Tramite(nombre, descripcion, duracionEstimada);
        tramiteJPA.create(tramite);
    }

    public Tramite findOneTramite(Long id) {
        Validations.notNull(id, "El ID del tramite no puede ser nulo.");
        return tramiteJPA.findOne(id);
    }

    public List<Tramite> findAllTramite() {
        return tramiteJPA.findAll();
    }

    public void updateTramite(Tramite tramite) {
        tramiteJPA.update(tramite);
    }

    public void deleteTramite(Long id) {
        Validations.notNull(id, "El ID del tramite no puede ser nulo.");
        tramiteJPA.delete(id);
    }
}
