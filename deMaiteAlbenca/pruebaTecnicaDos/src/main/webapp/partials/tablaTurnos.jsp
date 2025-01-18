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