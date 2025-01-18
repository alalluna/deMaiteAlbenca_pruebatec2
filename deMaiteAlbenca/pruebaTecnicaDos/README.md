Desarrollo del proyecto de Citas con la Seguridad Social

-He creado la estructura inicial, editando pom con las dependecias necesarias, 
añadiendo el archivo persistence e incluyendo la configuración de la fabrica y el crud generico.
Tambien he incluido un footer, un head y en header para las vistas 
-He creado tres entidades. Ciudadano y Tramite tienen relacion one to many con la tercera relación (Turno) 
que tiene many to one para corresponderse correctamente con las anteriores.
-Ahora he hecho CiudadanoController,TramiteController y TurnoController. En las dos primeras he realizado todo el crud, 
pero se que no me hará falta todo. En TurnoController he incluido crear el turno, listar y filtrar para poder tener el programa.
-He creado los archivos CiudadanoServlet, TramiteServlet y TurnoServlet, aunque aun no he realizado el doget, dopost,
también he hecho lo mismo con las vistas ciudadanos, tramites y turnos mas index.
-He creado tres validaciones para objetos nulos, strings y collecciones nulas, asi no tengo que repetir codigo en los metodos.
-Ahora he incluido los get y post de CiudadanoServlet para las solicitudes http del formulario y la tabla de ciudadanos.
-Tambien he creado la vista de ciudadanos.jsp y despues lo he separado en dos partials para que el codigo este mas limpio.
-Ahora voy a hacer lo mismo con los tramites, encuentro errores a la hora de generar la duracion estimada, 
-he cambiado el tipo de dato en sql a TIME, y en mi entitie a Duration, en el servlet lo parseo para recibir el parametro
pero ahora me hara falta un metodo que convierta este tipo de enumeracion al formato que deseo incluir en el formulario
