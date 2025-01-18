<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- imports -->
    <%@ page import="java.util.List, com.example.entities.Turno" %>
        <!DOCTYPE html>

        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body>

                <%@ include file="partials/header.jsp" %>

                    <!-- Contenedor para centrar el contenido -->
                    <div class="container mt-3 mb-2" style="min-height: 70vh;">
                     <!-- Contenedor row -->
                        <div class="row">
                            <%@ include file="partials/formularioTurnos.jsp" %>

                            <%@ include file="partials/tablaTurnos.jsp" %>
                        </div>
                    </div>

                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>