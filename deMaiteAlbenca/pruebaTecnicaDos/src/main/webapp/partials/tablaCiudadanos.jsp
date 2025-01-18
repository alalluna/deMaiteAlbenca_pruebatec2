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