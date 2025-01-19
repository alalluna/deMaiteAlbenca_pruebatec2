<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- esto es importantisimo, si no no funciona porque no encuentra al ciudadano -->
    <%@ page import="java.util.List, com.example.entities.Ciudadano" %>
        <!DOCTYPE html>

        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body>

                <%@ include file="partials/header.jsp" %>

                    <!-- Contenedor Bootstrap para centrar el contenido 72vh para que se vea header y footer-->
                    <div class="container mt-3 mb-2" style="min-height: 71vh;">
                     <!-- Contenedor row para dividir en dos el ancho y que se vea tabla y formulario-->
                        <div class="row">
                            <%@ include file="partials/formularioCiudadanos.jsp" %>

                            <%@ include file="partials/tablaCiudadanos.jsp" %>
                        </div>
                    </div>

                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>