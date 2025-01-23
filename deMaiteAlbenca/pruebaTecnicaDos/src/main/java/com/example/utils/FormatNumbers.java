package com.example.utils;

import com.example.entities.Turno;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FormatNumbers {
    //el metodo necesita un String y devuelve un tipo de dato Time
    public static Time formatTime(String timeString) {
        Validations.StringNotEmpty(timeString, "La cadena de tiempo no puede estar vacía.");

        String[] timeArray = timeString.split(":");//vector que separa elementos por : para validar el formato
        if (timeArray.length != 3) {
            throw new IllegalArgumentException("El tiempo debe estar en formato hh:mm:ss.");
        }

        try {
            int hours = Integer.parseInt(timeArray[0]);
            int minutes = Integer.parseInt(timeArray[1]);
            int seconds = Integer.parseInt(timeArray[2]);

            // Uso de Calendar para construir el tiempo tal y como investigué debe ser con milisegundos
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hours);
            calendar.set(Calendar.MINUTE, minutes);
            calendar.set(Calendar.SECOND, seconds);
            calendar.set(Calendar.MILLISECOND, 0);

            return new Time(calendar.getTimeInMillis());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El tiempo contiene valores no numéricos.");
        }
    }

    //Nadie vive mas de 110 años, restringgir esa edad para evitar errores en la asignacion del turno
    public static LocalDate validBorn(String fechaNacimientoStr) {
            //codigo depurado con el metodo parseDate
            LocalDate fechaNacimiento = parseDate(fechaNacimientoStr, "Formato de fecha inválido. Use yyyy-MM-dd.");
            LocalDate fechaLimite = LocalDate.now().minusYears(110);

            if (fechaNacimiento.isBefore(fechaLimite)) {
                throw new IllegalArgumentException("La fecha de nacimiento no puede ser mayor a 110 años.");
            }

            return fechaNacimiento;
    }

    public static LocalDate parseDate(String dateStr, String errorMessage) {
        try {
            return LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static LocalTime parseTime(String timeStr, String errorMessage) {
        try {
            return LocalTime.parse(timeStr);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static LocalDate formatDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        return parseDate(dateStr, "Formato de fecha inválido.Debe ser yyyy-mm-dd.");
    }

    //generar un numero pasando por todos los numeros listados para verificar que no exite
    public static int generateCode(int min, int max, List<Integer> existingNumbers) {
        Random random = new Random();
        int uniqueNumber;
        do {
            uniqueNumber = random.nextInt((max - min) + 1) + min;
        } while (existingNumbers.contains(uniqueNumber));
        return uniqueNumber;
    }

    //compare to now para saber si es atendido o es en espera
    public static int compareDatesAndHours(LocalDate date, LocalTime time) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTimeToCompare = LocalDateTime.of(date, time);

        return dateTimeToCompare.compareTo(now);
    }
}


