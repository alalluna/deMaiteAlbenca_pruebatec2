package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.persistence.GenericoJPA;
import com.example.utils.FormatNumbers;
import com.example.utils.Validations;
import java.time.LocalDate;
import java.util.List;

public class CiudadanoController{
    private final GenericoJPA<Ciudadano, Long> ciudadanoJPA = new GenericoJPA<>(Ciudadano.class);

    public void createCiudadano(String nombre, String apellidos, String documentoIdentidad, String numSS, String fechaNacimientoStr) {
        // Validaciones
        Validations.StringNotEmpty(nombre, "El nombre del ciudadano no puede estar vacío.");
        Validations.StringNotEmpty(apellidos, "El apellido del ciudadano no puede estar vacío.");
        Validations.StringNotEmpty(documentoIdentidad, "El documento de identidad no puede estar vacío.");
        Validations.StringNotEmpty(numSS, "El número de Seguridad Social no puede estar vacío.");
        Validations.notNull(fechaNacimientoStr, "La fecha de nacimiento no puede ser nula.");

        //Reutilizando la validacion generica para delegar esta funcion en Validations
        List<Ciudadano> ciudadanos = ciudadanoJPA.findAll();
        Validations.uniqueValue(
                ciudadanos,
                ciudadano -> ciudadano.getDocumentoIdentidad().equalsIgnoreCase(documentoIdentidad.trim()),
                "Ya existe un dni como este."
        );
        Validations.uniqueValue(
                ciudadanos,
                ciudadano -> ciudadano.getNumSS().equalsIgnoreCase(numSS.trim()),
                "Ya existe un número de Seguridad Social como este."
        );

        // Convertir fechaNacimiento de String a LocalDate y validar desde el metodo auxiliar
        LocalDate fechaNacimiento = FormatNumbers.validBorn(fechaNacimientoStr);

        //He modificado el metodo porque delegaba la creacion en el servlet y no debe ser así
        // Primero cre el Ciudadano (intancia) y persistir desde el metodo generico.
        Ciudadano ciudadano = new Ciudadano(nombre, apellidos, documentoIdentidad, numSS, fechaNacimiento);
        ciudadanoJPA.create(ciudadano);
    }

    public List<Ciudadano> findAllCiudadano() {
        return ciudadanoJPA.findAll();
    }

    //para realizar correctamente el formulario de citas o turnos no busca por id
    public Ciudadano FindOneByDni( String documentoIdentidad){
        Validations.StringNotEmpty(documentoIdentidad, "El documento de identidad no puede estar vacío.");

        List<Ciudadano> ciudadanos = ciudadanoJPA.findAll();

        return ciudadanos.stream()
                .filter(ciudadano -> ciudadano.getDocumentoIdentidad().equals(documentoIdentidad))
                .findFirst()
                .orElse(null); // Si no se encuentra el ciudadano
    }
}
