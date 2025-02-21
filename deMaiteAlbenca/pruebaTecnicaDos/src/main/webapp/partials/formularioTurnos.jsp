    <div class="card p-3 w-100">
        <h2 class="text-center mb-4">Citar</h2>
        <form action="turnos" method="POST">
            <!--Documento de Identidad -->
            <div class="form-group mb-3">
                <label for="documentoIdentidad">DNI/NIE</label>
                <input type="text" class="form-control" id="documentoIdentidad" name="documentoIdentidad" required>
            </div>

            <!--Fecha -->
            <div class="form-group mb-3">
                <label for="fecha">Fecha</label>
                <input type="date" class="form-control" id="fecha" name="fecha" required>
            </div>

            <!--Hora -->
            <div class="form-group mb-3">
                <label for="hora">Hora</label>
                <select class="form-control" id="hora" name="hora" required>
                    <% List<LocalTime> horasDisponibles = (List<LocalTime>)request.getAttribute("horasDisponibles");
                            for (LocalTime hora : horasDisponibles) {
                            %>
                            <option value="<%= hora.toString() %>">
                                <%= hora.toString() %>
                            </option>
                            <% } %>
                </select>
            </div>

            <!--Descripcion (nombre del tramite) -->
            <div class="form-group mb-3">
                <label for="descripcion">Tramite</label>
                <select class="form-control" id="descripcion" name="descripcion" required>
                    <!-- Aquí las opciones de los trámites disponibles -->
                    <% List<Tramite> tramites = (List<Tramite>)request.getAttribute("tramites");
                            for (Tramite tramite : tramites) {
                            %>
                            <option value="<%= tramite.getNombre() %>">
                                <%= tramite.getNombre() %>
                            </option>
                            <% } %>
                </select>
            </div>

            <!-- Botón de enviar -->
            <button type="submit" class="btn btn-outline-secondary w-100">Citar</button>
        </form>

    </div>