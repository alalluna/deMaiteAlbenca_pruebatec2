package com.example.servlets;

import com.example.controllers.TramiteController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet(urlPatterns = "/tramites")
public class TramiteServlet extends HttpServlet {
    private TramiteController tramiteController = new TramiteController();


}