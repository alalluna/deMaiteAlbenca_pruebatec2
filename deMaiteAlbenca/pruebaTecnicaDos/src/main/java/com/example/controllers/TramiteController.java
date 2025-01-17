package com.example.controllers;

import com.example.entities.Tramite;
import com.example.persistence.GenericoJPA;

import java.util.List;

public class TramiteController {
    private final GenericoJPA<Tramite, Long> tramiteJPA = new GenericoJPA<>(Tramite.class);
    //He creado el crud completo tb
    public void createTramite(Tramite tramite) {
        tramiteJPA.create(tramite);
    }

    public Tramite findOneTramite(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El no puede ser nulo.");
        }
        return tramiteJPA.findOne(id);
    }

    public List<Tramite> findAllTramite() {
        return tramiteJPA.findAll();
    }

    public void updateTramite(Tramite tramite) {
        tramiteJPA.update(tramite);
    }

    public void deleteTramite(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        tramiteJPA.delete(id);
    }
}
