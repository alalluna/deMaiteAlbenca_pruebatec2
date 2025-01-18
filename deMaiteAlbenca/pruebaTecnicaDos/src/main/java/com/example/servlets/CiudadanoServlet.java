package com.example.servlets;

import com.example.controllers.CiudadanoController;
import com.example.entities.Ciudadano;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@WebServlet(urlPatterns = "/ciudadanos")
public class CiudadanoServlet extends HttpServlet {
    private CiudadanoController ciudadanoController = new CiudadanoController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Para la lista de resultados
        List<Ciudadano> ciudadanos = ciudadanoController.findAllCiudadano();
        request.setAttribute("ciudadanos", ciudadanos);

        // Muestra el formulario
        request.getRequestDispatcher("/ciudadanos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String documentoIdentidad = request.getParameter("documentoIdentidad");
        String numSS = request.getParameter("numSS");
        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));

        // Crear un nuevo ciudadano
        Ciudadano ciudadano = new Ciudadano(nombre, apellidos, documentoIdentidad, numSS, fechaNacimiento);

        // Guardar el ciudadano
        ciudadanoController.createCiudadano(ciudadano);

        // Redirigir
        response.sendRedirect(request.getContextPath() + "/ciudadanos");
    }
}