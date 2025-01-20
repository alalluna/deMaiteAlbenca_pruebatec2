<div class="col-md-6 d-flex justify-content-center">
    <div class="card p-4 w-100">
        <h2 class="text-center mb-4">Turnos</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Estado</th>
                    <th>Ciudadano</th>
                    <th>Tramite</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<Turno> turnos = (List<Turno>)request.getAttribute("turnos");
                if (turnos != null) {
                    // obtener los datos con get para mostrar la tabla
                    for (Turno turno : turnos) {
                %>
                <tr>
                    <td><%= turno.getNumeroTurno() %></td>
                    <td><%= turno.getFecha() %></td>
                    <td><%= turno.getHora() %></td>
                    <td><%= turno.getEstado() %></td>
                    <td><%= turno.getCiudadano().getNombre() + " " + turno.getCiudadano().getApellidos() %></td>
                    <td><%= turno.getTramite().getNombre() %></td>
                </tr>
                <%  }
                } else {
                    out.println("<tr><td colspan='4'>No hay trámites disponibles.</td></tr>");
                }
                %>

            </tbody>
        </table>
    </div>
</div>
