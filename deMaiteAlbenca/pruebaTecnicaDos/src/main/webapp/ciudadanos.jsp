<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- esto es importantisimo, si no no funciona porque no encuentra al ciudadano -->
    <%@ page import="java.util.List, com.example.entities.Ciudadano" %>
        <!DOCTYPE html>

        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body>

                <%@ include file="partials/header.jsp" %>

                    <!-- Contenedor Bootstrap para centrar el contenido 72vh para que se vea header y footer-->
                    <div class="container mt-3 mb-2" style="min-height: 70vh;">
                        <div class="row">
                            <!-- formulario -->
                            <div class="col-md-6 d-flex justify-content-center">
                                <div class="card p-3 w-100">
                                    <h2 class="text-center mb-4">Registrar</h2>
                                    <form action="ciudadanos" method="POST">
                                        <div class="form-group mb-3">
                                            <label for="nombre">Nombre</label>
                                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="apellidos">Apellidos</label>
                                            <input type="text" class="form-control" id="apellidos" name="apellidos"
                                                required>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="documentoIdentidad">Documento de Identidad (DNI/NIE)</label>
                                            <input type="text" class="form-control" id="documentoIdentidad"
                                                name="documentoIdentidad" required>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="numSS">Número de Seguridad Social</label>
                                            <input type="text" class="form-control" id="numSS" name="numSS" required>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="fechaNacimiento">Fecha de Nacimiento</label>
                                            <input type="date" class="form-control" id="fechaNacimiento"
                                                name="fechaNacimiento" required>
                                        </div>
                                        <button type="submit" class="btn btn-outline-secondary w-100">Insertar</button>
                                    </form>
                                </div>
                            </div>
                            <!-- final formulario -->

                            <!-- tabla -->
                           
                            <div class="col-md-6 d-flex justify-content-center">
                                <div class="card p-4 w-100">
                                    <h2 class="text-center mb-4">Ciudadanos</h2>
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Nombre</th>
                                                <th>Apellidos</th>
                                                <th>DNI/NIE</th>
                                                <th>Num SS</th>
                                                <th>F.Nacimiento</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% List<Ciudadano> ciudadanos = (List<Ciudadano>)
                                                    request.getAttribute("ciudadanos");
                                                    if (ciudadanos != null) {
                                                    for (Ciudadano ciudadano : ciudadanos) {
                                                    %>
                                                    <tr>
                                                        <td>
                                                            <%= ciudadano.getId() %>
                                                        </td>
                                                        <td>
                                                            <%= ciudadano.getNombre() %>
                                                        </td>
                                                        <td>
                                                            <%= ciudadano.getApellidos() %>
                                                        </td>
                                                        <td>
                                                            <%= ciudadano.getDocumentoIdentidad() %>
                                                        </td>
                                                        <td>
                                                            <%= ciudadano.getNumSS() %>
                                                        </td>
                                                        <td>
                                                            <%= ciudadano.getFechaNacimiento() %>
                                                        </td>
                                                    </tr>
                                                    <% } } %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- final de la tabla -->
                        </div>
                    </div>

                    <%@ include file="partials/footer.jsp" %>

            </body>

        </html>