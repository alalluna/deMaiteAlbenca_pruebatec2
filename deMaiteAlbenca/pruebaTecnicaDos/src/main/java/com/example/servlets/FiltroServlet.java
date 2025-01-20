package com.example.servlets;

import com.example.controllers.CiudadanoController;
import com.example.controllers.TramiteController;
import com.example.controllers.TurnoController;
import com.example.entities.Ciudadano;
import com.example.entities.Tramite;
import com.example.entities.Turno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebServlet("/busquedas")
public class FiltroServlet extends HttpServlet {
    private TurnoController turnoController = new TurnoController();
    private CiudadanoController ciudadanoController = new CiudadanoController();
    private TramiteController tramiteController = new TramiteController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los parámetros de búsqueda desde la solicitud GET
        String estado = req.getParameter("estado");
        String fechaInicioStr = req.getParameter("fechaInicio");
        String fechaFinStr = req.getParameter("fechaFin");
        // Convertir las fechas de los parámetros a LocalDate (si están presentes)
        LocalDate fechaInicio = (fechaInicioStr != null && !fechaInicioStr.isEmpty()) ? LocalDate.parse(fechaInicioStr) : null;
        LocalDate fechaFin = (fechaFinStr != null && !fechaFinStr.isEmpty()) ? LocalDate.parse(fechaFinStr) : null;

        // Obtener los turnos del filtro
        List<Turno> turnos = turnoController.filterTurno(fechaInicio, fechaFin, estado);
        // Obtener los ciudadanos y trámites para el formulario
        List<Ciudadano> ciudadanos = ciudadanoController.findAllCiudadano();
        List<Tramite> tramites = tramiteController.findAllTramite();
        //para que pueda distinguir las horas
        LocalDate fechaActual = LocalDate.now();
        List<LocalTime> horasDisponibles = turnoController.horasLibres(fechaActual);

        // Pasar los atributos
        req.setAttribute("turnos", turnos);
        req.setAttribute("ciudadanos", ciudadanos);
        req.setAttribute("tramites", tramites);
        req.setAttribute("horasDisponibles", horasDisponibles);

        // Mostrar la página turnos
        req.getRequestDispatcher("/filtroTurno.jsp").forward(req, resp);
    }
}

