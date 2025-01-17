package com.example.servlets;

import com.example.controllers.TurnoController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/turnos")
public class TurnosServlet extends HttpServlet {
    private TurnoController turnoController = new TurnoController();


}


