<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <%@ include file="partials/head.jsp" %>
<body>

    <%@ include file="partials/header.jsp" %>

    <!-- Contenedor Bootstrap para centrar el contenido -->
    <div class="container mt-5" style="min-height: 71vh;">
        <h1>LISTA DE TURNO</h1>
    </div>
    <table>
        <thead>
            <tr>
                <th>Número</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Ciudadano</th>
                <th>Trámite</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="turno" items="${turnos}">
                <tr>
                    <td>${turno.numeroTurno}</td>
                    <td>${turno.fecha}</td>
                    <td>${turno.estado}</td>
                    <td>${turno.ciudadano.nombre} ${turno.ciudadano.apellidos}</td>
                    <td>${turno.tramite.nombre}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%@ include file="partials/footer.jsp" %>

</body>
</html>
