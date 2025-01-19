<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- importar clase tramite y util list-->
    <%@ page import="java.util.List, com.example.entities.Tramite" %>
        <!DOCTYPE html>

        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body>

                <%@ include file="partials/header.jsp" %>

                    <!-- Contenedor para centrar el contenido -->
                    <div class="container mt-3 mb-2" style="min-height: 75vh;">
                     <!-- Contenedor row -->
                        <div class="row">
                            <%@ include file="partials/formularioTramites.jsp" %>

                            <%@ include file="partials/tablaTramites.jsp" %>
                        </div>
                    </div>

                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>