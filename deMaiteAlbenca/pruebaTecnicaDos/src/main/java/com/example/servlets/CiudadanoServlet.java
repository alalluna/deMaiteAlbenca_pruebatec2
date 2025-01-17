package com.example.servlets;

import com.example.controllers.CiudadanoController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet(urlPatterns = "/ciudadanos")
public class CiudadanoServlet extends HttpServlet {
    private CiudadanoController ciudadanoController = new CiudadanoController();

}