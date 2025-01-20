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

@WebServlet("/turnos")
public class TurnosServlet extends HttpServlet {
    private TurnoController turnoController = new TurnoController();
    private CiudadanoController ciudadanoController = new CiudadanoController();
    private TramiteController tramiteController = new TramiteController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener todos los turnos
        List<Turno> turnos = turnoController.findAllTurno();
        // Obtener los ciudadanos y trámites para el formulario
        List<Ciudadano> ciudadanos = ciudadanoController.findAllCiudadano();
        List<Tramite> tramites = tramiteController.findAllTramite();
        //para que pueda distinguir las horas libres de las ocupadas necesitaremos listarlas
        LocalDate fechaActual = LocalDate.now();
        List<LocalTime> horasDisponibles = turnoController.horasLibres(fechaActual);

        // Pasar los atributos
        req.setAttribute("turnos", turnos);
        req.setAttribute("ciudadanos", ciudadanos);
        req.setAttribute("tramites", tramites);
        req.setAttribute("horasDisponibles", horasDisponibles);

        // Mostrar la página turnos
        req.getRequestDispatcher("/turnos.jsp").forward(req, resp);
    }

    // Crear un nuevo turno
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String documentoIdentidad = req.getParameter("documentoIdentidad"); // DNI o NIE
        String fecha = req.getParameter("fecha");
        String hora = req.getParameter("hora");
        String descripcion = req.getParameter("descripcion");

        // Llamar al controlador para crear el turno
        turnoController.createTurno(documentoIdentidad, fecha, hora, descripcion);

        // Redirigir al listado turnos
        resp.sendRedirect("turnos");
    }


}


