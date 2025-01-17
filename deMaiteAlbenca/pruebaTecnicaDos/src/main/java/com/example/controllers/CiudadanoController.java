package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.persistence.GenericoJPA;
import com.example.utils.Validations;

import java.util.List;
import java.util.Optional;

public class CiudadanoController{
    private final GenericoJPA<Ciudadano, Long> ciudadanoJPA = new GenericoJPA<>(Ciudadano.class);
    //He creado el crud completo basado en generico aunque no se aun si me hará falta tanto
    //He optimizado el crud usando validaciones
    public void createCiudadano(Ciudadano ciudadano){
        Validations.notNull(ciudadano, "El ciudadano no puede ser nulo.");
        Validations.StringNotEmpty(ciudadano.getNombre(), "El nombre del ciudadano no puede estar vacio.");
        Validations.StringNotEmpty(ciudadano.getApellidos(), "El apellido del ciudadano no puede estar vacio.");
        Validations.StringNotEmpty(ciudadano.getDocumentoIdentidad(), "El dni o nie no puede estar vacio.");
        Validations.StringNotEmpty(ciudadano.getNumSS(),"El numero ss no puede estar vacio.");

        ciudadanoJPA.create(ciudadano);
    }

    public Ciudadano findOneCiudadano(Long id) {
        Validations.notNull(id, "El ID del ciudadano no puede ser nulo.");
        return ciudadanoJPA.findOne(id);
    }
    public List<Ciudadano> findAllCiudadano() {
        return ciudadanoJPA.findAll();
    }
    //para realizar correctamente el fomrulario de citas o turnos
    public Ciudadano FindOneByDni( String documentoIdentidad){
        Validations.StringNotEmpty(documentoIdentidad, "El documento de identidad no puede estar vacío.");

        List<Ciudadano> ciudadanos = ciudadanoJPA.findAll();

        return ciudadanos.stream()
                .filter(ciudadano -> ciudadano.getDocumentoIdentidad().equals(documentoIdentidad))
                .findFirst()
                .orElse(null); // Si no se encuentra el ciudadano
    }


    public void updateCiudadano(Ciudadano ciudadano) {
        Validations.notNull(ciudadano, "El ciudadano no puede ser nulo.");
        ciudadanoJPA.update(ciudadano);
    }

    public void deleteCiudadano(Long id) {
        Validations.notNull(id, "El ID del ciudadano no puede ser nulo.");
        ciudadanoJPA.delete(id);
    }
}
