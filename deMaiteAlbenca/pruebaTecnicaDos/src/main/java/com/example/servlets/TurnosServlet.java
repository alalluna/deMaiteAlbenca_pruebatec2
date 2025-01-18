package com.example.servlets;

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
import java.util.List;

@WebServlet("/turnos")
public class TurnosServlet extends HttpServlet {
    private TurnoController turnoController = new TurnoController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener todos los turnos
        List<Turno> turnos = turnoController.findAllTurno();

        // Pasar los turnos al JSP
        request.setAttribute("turnos", turnos);

        // Mostrar la página con los turnos
        request.getRequestDispatcher("/turnos.jsp").forward(request, response);
    }

    // Crear un nuevo turno
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        Long ciudadanoId = Long.parseLong(request.getParameter("ciudadanoId"));
        Long tramiteId = Long.parseLong(request.getParameter("tramiteId"));
        int numeroTurno = Integer.parseInt(request.getParameter("numeroTurno"));
        String descripcion = request.getParameter("descripcion");
        String estado = request.getParameter("estado");

        // Crear un nuevo turno con los datos del formulario
        Turno turno = new Turno();
        // setear número de turno dinámico
        turno.setNumeroTurno(1234);

        // Llamar al controlador para crear el turno
        turnoController.createTurno(ciudadanoId, tramiteId, turno);

        // Redirigir al listado de turnos
        response.sendRedirect("turnos");
    }


}


