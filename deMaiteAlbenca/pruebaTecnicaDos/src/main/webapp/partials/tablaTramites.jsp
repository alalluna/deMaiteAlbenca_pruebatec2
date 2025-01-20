 <div class="col-md-9 d-flex justify-content-center">
    <div class="card p-4 w-100">
        <h2 class="text-center mb-4">Tramites</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                 <th>Nombre</th>
                 <th>Descripcion</th>
                 <th>Duracion Estimada (hh:mm:ss)</th>
                </tr>
            </thead>
            <tbody>
                <%  
                    List<Tramite> tramites = (List<Tramite>) request.getAttribute("tramites");
                    if (tramites != null) {
                        for (Tramite tramite : tramites) {
                %>
                    <tr>
                        <td><%= tramite.getNombre() %></td>
                        <td><%= tramite.getDescripcion() %></td>
                         <!-- da error porque hay que convertir el formato para introducir el tiempo -->
                        <td><%= tramite.getDuracionEstimada() %></td>
                    </tr>
                <%  }
                 // necesito comprobar que salgan datos o no
                       } else {
                           out.println("<tr><td colspan='4'>No hay trámites disponibles.</td></tr>");
                       } %>
            </tbody>
        </table>
    </div>
</div>
