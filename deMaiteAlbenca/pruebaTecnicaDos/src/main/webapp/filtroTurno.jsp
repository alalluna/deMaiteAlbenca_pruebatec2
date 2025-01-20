<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- imports -->
    <%@ page import="java.util.List,java.time.LocalTime,com.example.entities.Turno,com.example.entities.Ciudadano,com.example.entities.Tramite" %>
        <!DOCTYPE html>

        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body>

                <%@ include file="partials/header.jsp" %>

                    <!-- Contenedor para centrar el contenido -->
                    <div class="container mt-1 mb-1" style="min-height: 78vh;">
                     <!-- Contenedor row -->
                        <div class="row">
                            <%@ include file="partials/filtro.jsp" %>
                            <%@ include file="partials/tablaTurnos.jsp" %>
                        </div>
                    </div>

                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>