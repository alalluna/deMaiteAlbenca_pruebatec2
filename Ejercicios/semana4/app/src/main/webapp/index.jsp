<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%-- Importar las clases --%>
<%@ page import="java.util.List, com.ejemplo.entities.Persona" %>

<!DOCTYPE html>
<html lang="en">
    <%@ include file="partials/head.jsp" %>
<body class="bg-success-subtle" "container mt-5 mb-5">
    <%@ include file="partials/header.jsp" %>

    <section id="home" class="d-flex align-items-center mb-5">
    </section>

    <section id="listadoPersonas" class="d-flex align-items-center mb-5 mt-5">
        <div class="col-md-6 text-center">
            <h1 class="mb-2 mt-2">Votos del centro de Estudios</h1>


       </div>
       <div class="col-md-6 text-center">
            <ul>
                <% List<Persona> listado = (List<Persona>) request.getAttribute("listado");
                    for(Persona persona: listado) { %>
    
                    <li>Persona: <%= persona.getNombre() %>, <%= persona.getApellido() %></li>

                <% } %>
            </ul>
       </div>
    </section>
    <%@ include file="partials/footer.jsp" %>
</body>
</html>
