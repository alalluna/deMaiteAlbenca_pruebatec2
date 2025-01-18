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