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

    public List<Tramite> findAllTramite() {
        return tramiteJPA.findAll();
    }
    //necesitare un metodo que busque por la descripcion

    //Este metodo no esta bien porque no lo recoge el formulario, en lugar de obtener la descripcion tengo que obtener el nombre
    public Tramite findByDescripcion(String nombre) {
        Validations.StringNotEmpty(nombre, "La descripción del trámite no puede estar vacía.");

        List<Tramite> tramites = tramiteJPA.findAll();

        return tramites.stream()
                .filter(tramite -> tramite.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null); // Si no se encuentra el trámite, devuelve null
    }

//    public void updateTramite(Tramite tramite) {
//        tramiteJPA.update(tramite);
//    }
//
//    public void deleteTramite(Long id) {
//        Validations.notNull(id, "El ID del tramite no puede ser nulo.");
//        tramiteJPA.delete(id);
//    }
//    public Tramite findOneTramite(Long id) {
//        Validations.notNull(id, "El ID del tramite no puede ser nulo.");
//        return tramiteJPA.findOne(id);
//    }
}
