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
        List<Turno> turnos = turnoController.findAllTurno();
        List<Ciudadano> ciudadanos = ciudadanoController.findAllCiudadano();
        List<Tramite> tramites = tramiteController.findAllTramite();

        //para que pueda distinguir las horas libres de las ocupadas necesitaremos listarlas
        LocalDate fechaActual = LocalDate.now();
        List<LocalTime> horasDisponibles = turnoController.horasLibres(fechaActual);

        req.setAttribute("turnos", turnos);
        req.setAttribute("ciudadanos", ciudadanos);
        req.setAttribute("tramites", tramites);
        req.setAttribute("horasDisponibles", horasDisponibles);
        // Mostrar la página turnos
        req.getRequestDispatcher("/turnos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String documentoIdentidad = req.getParameter("documentoIdentidad"); // DNI o NIE
        String fecha = req.getParameter("fecha");
        String hora = req.getParameter("hora");
        String descripcion = req.getParameter("descripcion");

        turnoController.createTurno(documentoIdentidad, fecha, hora, descripcion);
        resp.sendRedirect(req.getContextPath()+ "/turnos");
    }


}


