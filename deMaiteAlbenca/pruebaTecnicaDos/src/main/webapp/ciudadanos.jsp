<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- esto es importantisimo, si no no funciona porque no encuentra al ciudadano -->
    <%@ page import="java.util.List, com.example.entities.Ciudadano" %>
        <!DOCTYPE html>

        <html lang="en">
        <%@ include file="partials/head.jsp" %>
            <body class="d-flex flex-column vh-100">

                <%@ include file="partials/header.jsp" %>

                    <!-- Contenedor Bootstrap para centrar el contenido-->
                     <div class="container-fluid flex-grow-1 overflow-auto py-3 px-2">
                     <!-- Contenedor row para dividir en dos el ancho y que se vea tabla y formulario-->
                        <div class="row">
                            <div class="col-md-3 overflow-auto" style="max-height: 600px;">
                                <%@ include file="partials/formularioCiudadanos.jsp" %>
                            </div>
                            <div class="col-md-9 overflow-auto" style="max-height: 600px;">
                                <%@ include file="partials/tablaCiudadanos.jsp" %>
                            </div>
                            
                        </div>
                    </div>

                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>