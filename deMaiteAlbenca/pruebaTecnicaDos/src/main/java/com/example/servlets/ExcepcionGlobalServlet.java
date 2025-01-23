package com.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")  // Aplica a todas las URLs
public class ExcepcionGlobalServlet implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Capturar cualquier excepción global de cualquier pagina para devolver error y atras
        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {

            request.setAttribute("errorMessage", ex.getMessage());

            // Obtener la URL de la página anterior con referer y previous page (si es null,ej:inicio)
            String previousPage = ((HttpServletRequest) request).getHeader("Referer");
            if (previousPage == null) {
                previousPage = "/";
            }

            request.setAttribute("redirectUrl", previousPage);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
