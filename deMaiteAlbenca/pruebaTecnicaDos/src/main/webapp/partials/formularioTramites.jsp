<!-- formulario -->
<div class="col-md-3 d-flex justify-content-center">
    <div class="card p-3 w-100">
        <h2 class="text-center mb-4">Registrar</h2>
        <form action="tramites" method="POST">
            <div class="form-group mb-3">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group mb-3">
                <label for="descripcion">Descripcion</label>
                <input type="text" class="form-control" id="descripcion" name="descripcion" required>
            </div>
            <div class="form-group mb-3">
                <label for="duracionEstimada">Duracion hh:mm:ss</label>
                <input type="text" class="form-control" id="duracionEstimada" name="duracionEstimada" required>
            </div>
            <button type="submit" class="btn btn-outline-secondary w-100">Insertar</button>
        </form>
    </div>
</div>
<!-- final formulario -->