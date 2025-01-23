package com.example.servlets;

import com.example.controllers.CiudadanoController;
import com.example.entities.Ciudadano;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ciudadanos")
public class CiudadanoServlet extends HttpServlet {
    private CiudadanoController ciudadanoController = new CiudadanoController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //se recogen datos del formulario con getParameter y se envia la lista a la pagina con setAttribute
        List<Ciudadano> ciudadanos = ciudadanoController.findAllCiudadano();
        req.setAttribute("ciudadanos", ciudadanos);
        req.getRequestDispatcher("/ciudadanos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellidos = req.getParameter("apellidos");
        String documentoIdentidad = req.getParameter("documentoIdentidad");
        String numSS = req.getParameter("numSS");
        String fechaNacimientoStr = req.getParameter("fechaNacimiento");


        ciudadanoController.createCiudadano(nombre, apellidos, documentoIdentidad, numSS, fechaNacimientoStr);

        resp.sendRedirect(req.getContextPath() + "/ciudadanos");
    }
}