package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.persistence.GenericoJPA;
import com.example.utils.FormatNumbers;
import com.example.utils.Validations;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TurnoController {
    private final GenericoJPA<Turno, Long> turnoJPA = new GenericoJPA<>(Turno.class);
    private final CiudadanoController ciudadanoController = new CiudadanoController();
    private final TramiteController tramiteController = new TramiteController();

    // Generar un número único, mapeando y listando los numeros para evitarlos y despues hacer el random.
    public int generarNumero() {
        List<Turno> turnos = turnoJPA.findAll();  // Obtener todos los turnos
        List<Integer> existingNumbers = turnos.stream()
                .map(Turno::getNumeroTurno)
                .collect(Collectors.toList());

        return FormatNumbers.generateCode(1000, 9999, existingNumbers);
    }

    // Verificar la hora buscando coincidencias en fecha y hora
    public boolean horaOcupada(LocalTime hora, LocalDate fecha) {
        return findAllTurno().stream()
                .anyMatch(turno -> turno.getFecha().equals(fecha) &&
                        turno.getHora().toLocalTime().equals(hora));
    }

    // Obtener las horas segun todas las condiciones, horario laboral, fechas validas y horas ocupadas
    public List<LocalTime> horasLibres(LocalDate fecha) {
        // Generar franjas horarias desde las 8:00 hasta las 14:00
        return IntStream.range(8, 15)
                .mapToObj(hora -> LocalTime.of(hora, 0))
                .filter(hora -> !horaOcupada(hora, fecha)) // Filtrar horas ocupadas
                .collect(Collectors.toList());
    }

    public void createTurno(String documentoIdentidad, String fecha, String hora, String descripcion) {
        Validations.StringNotEmpty(documentoIdentidad, "El documento de identidad es obligatorio.");
        Validations.StringNotEmpty(fecha, "La fecha del turno es obligatoria.");
        Validations.StringNotEmpty(hora, "La hora del turno es obligatoria.");
        Validations.StringNotEmpty(descripcion, "La descripción del trámite es obligatoria.");

        // Validar y parsear fecha y hora con los metodos para evitar dar cita en tiempo pasado
        LocalDate fechaTurno = FormatNumbers.parseDate(fecha, "Formato de fecha inválido. Use yyyy-MM-dd.");
        LocalTime horaTurno = FormatNumbers.parseTime(hora, "Formato de hora inválido. Use HH:mm:ss.");

        if (FormatNumbers.compareDatesAndHours(fechaTurno, horaTurno) <= 0) {
            throw new IllegalArgumentException("No se pueden crear turnos en fechas u horas pasadas.");
        }

        // Buscar el ciudadano y el trámite para poder referirme a él en la creación
        Ciudadano ciudadano = ciudadanoController.FindOneByDni(documentoIdentidad);
        Validations.notNull(ciudadano, "El ciudadano con DNI " + documentoIdentidad + " no existe.");
        Tramite tramite = tramiteController.findByDescripcion(descripcion);
        Validations.notNull(tramite, "El trámite " + descripcion + " no existe.");

        if (horaOcupada(horaTurno, fechaTurno)) {
            throw new IllegalArgumentException("La hora seleccionada ya está ocupada.");
        }

        Turno turno = new Turno();
        turno.setNumeroTurno(generarNumero());
        turno.setFecha(fechaTurno);
        turno.setHora(Time.valueOf(horaTurno));
        turno.setDescripcion(descripcion);
        turno.setCiudadano(ciudadano);
        turno.setTramite(tramite);
        turno.setEstado("EN_ESPERA");
        turnoJPA.create(turno);
    }

    public List<Turno> findAllTurno() {
        return turnoJPA.findAll();
    }

    // Filtrar listas con los requisitos, optional para dar dos opciones y
    public List<Turno> filterTurno(String fechaInicioStr , String fechaFinStr, String estado) {
        LocalDate fechaInicio = FormatNumbers.formatDate(fechaInicioStr);
        LocalDate fechaFin = FormatNumbers.formatDate(fechaFinStr);

        List<Turno> todosLosTurnos = turnoJPA.findAll();
        Validations.notEmpty(todosLosTurnos, "No se encontraron turnos.");

        todosLosTurnos.forEach(turno -> {
            int comparison = FormatNumbers.compareDatesAndHours(turno.getFecha(), turno.getHora().toLocalTime());
            if (comparison < 0) {
                turno.setEstado("YA_ATENDIDO");
                turnoJPA.update(turno);//cambiando el estado de los turnos si es necesario
            } else {
                turno.setEstado("EN_ESPERA");
            }
        });

        Optional<String> optionalEstado = Optional.ofNullable(estado)
                .filter(e -> e.equalsIgnoreCase("EN_ESPERA") || e.equalsIgnoreCase("YA_ATENDIDO"));

        return todosLosTurnos.stream()
                .filter(turno -> (fechaInicio == null || !turno.getFecha().isBefore(fechaInicio)))
                .filter(turno -> (fechaFin == null || !turno.getFecha().isAfter(fechaFin)))
                .filter(turno -> optionalEstado.map(e -> turno.getEstado()
                        .equalsIgnoreCase(e)).orElse(true))
                .collect(Collectors.toList());
    }
}
