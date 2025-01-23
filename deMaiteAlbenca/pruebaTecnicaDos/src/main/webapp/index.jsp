<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <%@ include file="partials/head.jsp" %>
    <body class="d-flex flex-column vh-100">

        <%@ include file="partials/header.jsp" %>
    
        <!-- Contenedor Bootstrap para centrar el contenido -->
        <div class="container d-flex flex-column justify-content-center align-items-center flex-grow-1 text-center p-3">
            <h1 class="mb-4">BIENVENIDO AL SERVICIO DE CITAS DE LA SEGURIDAD SOCIAL</h1>
            <img 
                src="./public/img/cabecera.jpg"
                alt="Imagen de cabecera"
                class="img-fluid" 
                style="max-height: 500px; object-fit: cover;"
            >
        </div>
    
        <%@ include file="partials/footer.jsp" %>
    
    </body>
</html>
