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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Para la lista de resultados
        List<Ciudadano> ciudadanos = ciudadanoController.findAllCiudadano();
        req.setAttribute("ciudadanos", ciudadanos);

        // (Muestra el formulario)ahora redirige a las dos, a formulario y lista
        req.getRequestDispatcher("/ciudadanos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recibir los parámetros del formulario
        String nombre = req.getParameter("nombre");
        String apellidos = req.getParameter("apellidos");
        String documentoIdentidad = req.getParameter("documentoIdentidad");
        String numSS = req.getParameter("numSS");
        LocalDate fechaNacimiento = LocalDate.parse(req.getParameter("fechaNacimiento"));

        // Crear un nuevo ciudadano
        Ciudadano ciudadano = new Ciudadano(nombre, apellidos, documentoIdentidad, numSS, fechaNacimiento);

        // Guardar el ciudadano
        ciudadanoController.createCiudadano(ciudadano);

        // Redirigire
        resp.sendRedirect(req.getContextPath() + "/ciudadanos");
    }
}