package com.example.controllers;

import com.example.entities.Tramite;
import com.example.persistence.GenericoJPA;
import com.example.utils.FormatNumbers;
import com.example.utils.Validations;
import java.sql.Time;
import java.util.List;

public class TramiteController {
    private final GenericoJPA<Tramite, Long> tramiteJPA = new GenericoJPA<>(Tramite.class);

    public void createTramite(String nombre, String descripcion, String duracionEstimadaStr) {
        Validations.StringNotEmpty(nombre,"El nombre no puede estar vacío");
        Validations.StringNotEmpty(descripcion, "La descripción del tramite no puede estar vacía.");
        Validations.StringNotEmpty(duracionEstimadaStr, "La duración estimada no puede estar vacía.");

        // que tengan valores unicos con metodo generico de utils y quitar los espacios a los lados
        List<Tramite> tramites = tramiteJPA.findAll();
        Validations.uniqueValue(
                tramites,
                tramite -> tramite.getNombre().equalsIgnoreCase(nombre.trim()),
                "Ya existe un trámite con este nombre."
        );
        Validations.uniqueValue(
                tramites,
                tramite -> tramite.getDescripcion().equalsIgnoreCase(descripcion.trim()),
                "Ya existe un trámite con esta descripción."
        );

        //llamar al metodo para convertir la duracion con Calendar al formato de horas minutos y segundos
        Time duracionEstimada = FormatNumbers.formatTime(duracionEstimadaStr);

        Tramite tramite = new Tramite(nombre, descripcion, duracionEstimada);
        tramiteJPA.create(tramite);
    }

    public List<Tramite> findAllTramite() {
        return tramiteJPA.findAll();
    }

    //Error cometido: en tramite es el parametro nombre y en Turno es la descripcion
    public Tramite findByDescripcion(String nombre) {
        Validations.StringNotEmpty(nombre, "La descripción del trámite no puede estar vacía.");

        List<Tramite> tramites = tramiteJPA.findAll();

        return tramites.stream()
                .filter(tramite -> tramite.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null); // Si no se encuentra el trámite, devuelve null
    }
}
