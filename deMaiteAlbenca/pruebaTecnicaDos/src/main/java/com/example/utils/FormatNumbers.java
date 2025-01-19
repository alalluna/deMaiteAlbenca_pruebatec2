package com.example.utils;

import com.example.entities.Turno;
import com.example.persistence.GenericoJPA;

import java.sql.Time;
import java.util.Calendar;
import java.util.Random;

public class FormatNumbers {
    //el metodo necesita un String y devuelve un tipo de dato Time
    public static Time formatTime(String timeString) {
        if (timeString == null || timeString.isEmpty()) {
            throw new IllegalArgumentException("La cadena de tiempo no puede estar vacía.");
        }

        String[] timeArray = timeString.split(":");
        if (timeArray.length != 3) {
            throw new IllegalArgumentException("El tiempo debe estar en formato hh:mm:ss.");
        }

        try {
            int hours = Integer.parseInt(timeArray[0]);
            int minutes = Integer.parseInt(timeArray[1]);
            int seconds = Integer.parseInt(timeArray[2]);

            // Uso de Calendar para construir el tiempo
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hours);
            calendar.set(Calendar.MINUTE, minutes);
            calendar.set(Calendar.SECOND, seconds);
            calendar.set(Calendar.MILLISECOND, 0);

            // Convertir a java.sql.Time
            return new Time(calendar.getTimeInMillis());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El tiempo contiene valores no numéricos.");
        }
    }

    public int generateNumber(GenericoJPA<Turno, Long> turnoJPA) {
        //hago el numero random
        Random random = new Random();
        int numeroTurno;

        do {
            // Generar un número aleatorio de 4 dígitos (entre 1000 y 9999)
            numeroTurno = random.nextInt(9999 - 1000) + 1000;
            //que no coincida con ninguno existente
        } while (turnoJPA.findAll().stream().anyMatch(t -> t.getNumeroTurno() == numeroTurno));

        return numeroTurno;
    }
}


