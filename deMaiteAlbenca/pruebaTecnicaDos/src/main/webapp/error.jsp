<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@ include file="partials/head.jsp" %>
    <body class="d-flex flex-column vh-100">

        <%@ include file="partials/header.jsp" %>

        <!-- Contenedor para centrar el contenido -->
        <div class="container d-flex flex-column justify-content-center align-items-center flex-grow-1 text-center p-3">
                <!-- Alert con estructura clara -->
                <div class="alert alert-danger mt-5 text-center w-100">
                    <!-- Encabezado -->
                    <h4 class="alert-heading">¡Ha ocurrido un error!</h4>
                    <!-- Mensaje de error -->
                    <p><%= request.getAttribute("errorMessage") %></p>
                    <!-- Botón debajo del mensaje -->
                    <p class="mb-0">
                        <a href="<%= request.getAttribute("redirectUrl") %>" class="btn btn-secondary">Volver al formulario</a>
                    </p>
                </div>
        </div>

        <%@ include file="partials/footer.jsp" %>

    </body>
</html>
