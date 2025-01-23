<!-- formulario ocupara el 40% del ancho por la clase col-md-4 -->
    <div class="card p-3 w-100">
        <h2 class="text-center mb-4">Registrar</h2>
        <form action="ciudadanos" method="POST">
            <div class="form-group mb-3">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group mb-3">
                <label for="apellidos">Apellidos</label>
                <input type="text" class="form-control" id="apellidos" name="apellidos" required>
            </div>
            <div class="form-group mb-3">
                <label for="documentoIdentidad">(DNI/NIE)</label>
                <input type="text" class="form-control" id="documentoIdentidad" name="documentoIdentidad" required>
            </div>
            <div class="form-group mb-3">
                <label for="numSS">Num Seguridad Social</label>
                <input type="text" class="form-control" id="numSS" name="numSS" required>
            </div>
            <div class="form-group mb-3">
                <label for="fechaNacimiento">Fecha Nacimiento</label>
                <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
            </div>
            <button type="submit" class="btn btn-outline-secondary w-100">Insertar</button>
        </form>
    </div>
<!-- final formulario -->