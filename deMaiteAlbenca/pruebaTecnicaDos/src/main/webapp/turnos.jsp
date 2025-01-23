<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- imports -->
    <%@ page import="java.util.List,java.time.LocalTime,com.example.entities.Turno,com.example.entities.Ciudadano,com.example.entities.Tramite" %>
        <!DOCTYPE html>

        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body class="d-flex flex-column vh-100">

                <%@ include file="partials/header.jsp" %>

                    <!-- Contenedor para centrar el contenido -->
                    <div class="container-fluid flex-grow-1 overflow-auto py-3 px-2">
                     <!-- Contenedor row -->
                        <div class="row">
                            <div class="col-md-3 overflow-auto" style="max-height: 600px;">
                                <%@ include file="partials/formularioTurnos.jsp" %>
                            </div>
                            <div class="col-md-9 overflow-auto" style="max-height: 600px;">
                                <%@ include file="partials/tablaTurnos.jsp" %>
                            </div>
                            
                        </div>
                    </div>

                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>