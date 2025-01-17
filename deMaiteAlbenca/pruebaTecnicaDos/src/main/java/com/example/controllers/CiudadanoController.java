package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.persistence.GenericoJPA;

import java.util.List;

public class CiudadanoController{
    private final GenericoJPA<Ciudadano, Long> ciudadanoJPA = new GenericoJPA<>(Ciudadano.class);
    //He creado el crud completo basado en generico aunque no se aun si me hará falta tanto
    public void createCiudadano(Ciudadano ciudadano){
        ciudadanoJPA.create(ciudadano);
    }

    public Ciudadano findOneCiudadano(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El no puede ser nulo.");
        }
        return ciudadanoJPA.findOne(id);
    }

    public List<Ciudadano> findAllCiudadano() {
        return ciudadanoJPA.findAll();
    }

    public void updateCiudadano(Ciudadano ciudadano) {
        ciudadanoJPA.update(ciudadano);
    }

    public void deleteCiudadano(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El no puede ser nulo.");
        }
        ciudadanoJPA.delete(id);
    }
}
