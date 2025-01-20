package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.entities.Tramite;
import com.example.entities.Turno;
import com.example.persistence.GenericoJPA;
import com.example.utils.Validations;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TurnoController {
    private final GenericoJPA<Turno, Long> turnoJPA = new GenericoJPA<>(Turno.class);
    private final CiudadanoController ciudadanoController = new CiudadanoController();
    private final TramiteController tramiteController = new TramiteController();

    // Generar un número único para el turno
    public int generateNumber() {
        Random random = new Random();
        int numeroTurno = 0;
        List<Turno> turnos = turnoJPA.findAll();  // Obtener todos los turnos una vez

        // Generar un número aleatorio único
        boolean isUnique = false;
        while (!isUnique) {
            numeroTurno = random.nextInt(9000) + 1000;  // Generar número entre 1000 y 9999

            // Verificar si el número ya existe
            final int finalNumeroTurno = numeroTurno;  // Hacerlo final para usarlo en la lambda
            isUnique = turnos.stream()
                    .noneMatch(t -> t.getNumeroTurno() == finalNumeroTurno);  // Verificar que no haya coincidencias
        }

        return numeroTurno;
    }

        // Verificar si una hora esta ocupada para una fecha especifica
    public boolean horaOcupada(LocalTime hora, LocalDate fecha) {
        List<Turno> turnos = findAllTurno(); // Obtener todos los turnos
        return turnos.stream()
                .anyMatch(turno -> turno.getFecha().equals(fecha) && turno.getHora().toLocalTime().equals(hora));
    }

    // Obtener las horas libres en un dia especifico
    public List<LocalTime> horasLibres(LocalDate fecha) {
        // Generar franjas horarias desde las 8:00 hasta las 14:00
        return IntStream.range(8, 15)
                .mapToObj(hora -> LocalTime.of(hora, 0))
                .filter(hora -> !horaOcupada(hora, fecha)) // Filtrar horas ocupadas
                .collect(Collectors.toList());
    }

    // Crear un nuevo turno
    public void createTurno(String documentoIdentidad, String fecha, String hora, String descripcion) {
        Validations.StringNotEmpty(documentoIdentidad, "El documento de identidad es obligatorio.");
        Validations.StringNotEmpty(fecha, "La fecha del turno es obligatoria.");
        Validations.StringNotEmpty(hora, "La hora del turno es obligatoria.");
        Validations.StringNotEmpty(descripcion, "La descripción del trámite es obligatoria.");

        // Buscar ciudadano y tramite

        Ciudadano ciudadano = ciudadanoController.FindOneByDni(documentoIdentidad);
        Tramite tramite = tramiteController.findByDescripcion(descripcion);

        if (ciudadano == null) {
            throw new IllegalArgumentException("El ciudadano con DNI " + documentoIdentidad + " no existe.");
        }
        if (tramite == null) {
            throw new IllegalArgumentException("El trámite " + descripcion + " no existe.");
        }
        //ahora si esta bien porque parseo las fecha y hora  y mas tare lo seteo
        LocalDate fechaTurno = LocalDate.parse(fecha);
        LocalTime horaTurno = LocalTime.parse(hora);

        // Verificar si la hora esta ocupada
        if (horaOcupada(horaTurno, fechaTurno)) {
            throw new IllegalArgumentException("La hora seleccionada ya está ocupada.");
        }

        // Configurar y guardar el turno
        Turno turno = new Turno();
        turno.setNumeroTurno(generateNumber());
        turno.setFecha(fechaTurno);             // Fecha convertida
        turno.setHora(Time.valueOf(horaTurno));
        turno.setDescripcion(descripcion);
        turno.setCiudadano(ciudadano);  // Relacion con el ciudadano
        turno.setTramite(tramite); //relacion con trmaite
        turno.setEstado("EN_ESPERA");
        turnoJPA.create(turno);
    }

    // Encontrar un turno por ID
    public Turno findOneTurno(Long id) {
        Validations.notNull(id, "El ID del turno no puede ser nulo.");
        return turnoJPA.findOne(id);
    }

    // Obtener todos los turnos
    public List<Turno> findAllTurno() {
        return turnoJPA.findAll();
    }

    // Actualizar un turno
    public void updateTurno(Turno turno) {
        Validations.notNull(turno, "El turno no puede ser nulo.");
        turnoJPA.update(turno);
    }

    // Eliminar un turno
    public void deleteTurno(Long id) {
        Validations.notNull(id, "El ID del turno no puede ser nulo.");
        turnoJPA.delete(id);
    }

    // Filtrar turnos por rango de fechas y estado
    public List<Turno> filterTurno(LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        // Esto no puedo validarlo asi porque si no no puedo filtrar por unos campos si y otros no
        //        Validations.notNull(fechaInicio, "La fecha de inicio no puede ser nula.");
        //        Validations.notNull(fechaFin, "La fecha de fin no puede ser nula.");

        List<Turno> todosLosTurnos = turnoJPA.findAll();
        Validations.notEmpty(todosLosTurnos, "No se encontraron turnos.");

        Optional<String> optionalEstado = Optional.ofNullable(estado)
                .filter(e -> e.equalsIgnoreCase("EN_ESPERA") || e.equalsIgnoreCase("YA_ATENDIDO"));

        return todosLosTurnos.stream()
                //modifico los filter para que tenga dos opciones si es null o si no
                .filter(turno -> (fechaInicio == null || !turno.getFecha().isBefore(fechaInicio)))
                .filter(turno -> (fechaFin == null || !turno.getFecha().isAfter(fechaFin)))
                .filter(turno -> optionalEstado.map(e -> turno.getEstado().equalsIgnoreCase(e)).orElse(true))
                .collect(Collectors.toList());
    }
}
