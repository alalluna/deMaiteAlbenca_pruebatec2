<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <%@ include file="partials/head.jsp" %>
<body>

    <%@ include file="partials/header.jsp" %>

    <!-- Contenedor Bootstrap para centrar el contenido -->
    <div class="container mt-5" style="min-height: 71vh;">
        <h1>TURNOS</h1>
    </div>
    <div>
     <h2>Agregar Nuevo Turno</h2>
            <form action="turnos" method="POST">
                <div class="form-group">
                    <label for="numeroTurno">Número de Turno</label>
                    <input type="number" class="form-control" id="numeroTurno" name="numeroTurno" required>
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha</label>
                    <input type="date" class="form-control" id="fecha" name="fecha" required>
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                </div>
                <div class="form-group">
                    <label for="estado">Estado</label>
                    <select class="form-control" id="estado" name="estado" required>
                        <option value="En espera">En espera</option>
                        <option value="Ya atendido">Ya atendido</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="ciudadanoId">Ciudadano</label>
                    <select class="form-control" id="ciudadanoId" name="ciudadanoId" required>
                        <!-- Aquí las opciones de los ciudadanos disponibles -->
                        <% for (Ciudadano ciudadano : ciudadanos) { %>
                            <option value="<%= ciudadano.getId() %>"><%= ciudadano.getNombre() + " " + ciudadano.getApellidos() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="tramiteId">Trámite</label>
                    <select class="form-control" id="tramiteId" name="tramiteId" required>
                        <!-- Aquí las opciones de los trámites disponibles -->
                        <% for (Tramite tramite : tramites) { %>
                            <option value="<%= tramite.getId() %>"><%= tramite.getNombre() %></option>
                        <% } %>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Añadir Turno</button>
            </form>

    </div>
    <div>
        <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Numero</th>
                        <th>Fecha</th>
                        <th>Estado</th>
                        <th>Ciudadano</th>
                        <th>Tramite</th>
                        <th>Descripcion</th>
                    </tr>
                </thead>
                <tbody><%
                    //obtener los datos con get para mostrar la tabla
                    for (Turno turno : turnos) {
                %>
                    <tr>
                        td><%= turno.getId() %></td>
                        <td><%= turno.getNumeroTurno() %></td>
                        <td><%= turno.getFecha() %></td>
                        <td><%= turno.getEstado() %></td>
                        <td><%= turno.getCiudadano().getNombre() + " " + turno.getCiudadano().getApellidos() %></td>
                        <td><%= turno.getTramite().getNombre() %></td>
                         <td><%= turno.getDescripcion() %></td>
                    </tr>
                <% } %>
            </tbody>
            </table>
    </div>

    <%@ include file="partials/footer.jsp" %>

</body>
</html>
