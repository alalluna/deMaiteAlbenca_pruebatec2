<div class="col-md-4 d-flex justify-content-center">
    <div class="card p-3 w-100">
        <h2 class="text-center mb-1">Filtrar</h2>
        <!-- es metodo get porque no crea nuevos turnos sino que los filtra -->
        <form action="busquedas" method="GET">
            <!-- Inicio -->
            <div class="form-group">
                <label for="fechaInicio">Fecha Inicio</label>
                <input type="date" class="form-control" id="fechaInicio" name="fechaInicio">
            </div>

            <!-- Fin -->
            <div class="form-group">
                <label for="fechaFin">Fecha Fin</label>
                <input type="date" class="form-control" id="fechaFin" name="fechaFin">
            </div>

            <!-- Estado  -->
            <div class="form-group">
                <label for="estado">Estado</label>
                <select class="form-control" id="estado" name="estado">
                    <option value="">-- Seleccione --</option>
                    <option value="EN_ESPERA">Espera</option>
                    <option value="YA_ATENDIDO">Atendido</option>
                </select>
            </div>

            <!-- Filtrar -->
            <button type="submit" class="btn btn-outline-secondary w-100">Filtrar</button>
        </form>
    </div>
</div>