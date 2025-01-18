package com.example.servlets;

import com.example.controllers.TramiteController;
import com.example.entities.Tramite;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


@WebServlet(urlPatterns = "/tramites")
public class TramiteServlet extends HttpServlet {
    private TramiteController tramiteController = new TramiteController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Para la lista
        List<Tramite> tramites = tramiteController.findAllTramite();
        req.setAttribute("tramites", tramites);

        // redirigir
        req.getRequestDispatcher("/tramites.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recibir parametros
        //nombre, descripcion, duracionEstimada;
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        //Parseo el tipo de dato duration
        Duration duracionEstimada = Duration.parse(req.getParameter("duracionEstimada"));

        Tramite tramite = new Tramite(nombre,descripcion,duracionEstimada);

        tramiteController.createTramite(tramite);

        resp.sendRedirect(req.getContextPath()+ "/tramites");
    }
}