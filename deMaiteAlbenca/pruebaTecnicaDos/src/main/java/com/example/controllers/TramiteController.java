package com.example.controllers;

import com.example.entities.Tramite;
import com.example.persistence.GenericoJPA;
import com.example.utils.Validations;

import java.util.List;

public class TramiteController {
    private final GenericoJPA<Tramite, Long> tramiteJPA = new GenericoJPA<>(Tramite.class);
    //He creado el crud completo tb
    public void createTramite(Tramite tramite) {
        Validations.notNull(tramite, "El tramite no puede ser nulo.");
        Validations.StringNotEmpty(tramite.getNombre()),"El nombre no puede estar vacio";
        Validations.StringNotEmpty(tramite.getDescripcion(), "La descripcion del tramite no puede estar vacia.");
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
