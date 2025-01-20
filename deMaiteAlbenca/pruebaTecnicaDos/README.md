Desarrollo del proyecto de Citas con la Seguridad Social

- He creado la estructura inicial, editando pom con las dependecias necesarias, 
añadiendo el archivo persistence e incluyendo la configuración de la fábrica y el crud genérico.
- También he incluido un footer, un head y en header para las vistas. Tengo reciclada una maquetación bootstrap.
- 
- He creado tres entidades. Ciudadano y Tramite tienen relación one to many con la tercera relación (Turno).
que tiene many to one para corresponderse correctamente con las anteriores.
- 
- Ahora he hecho CiudadanoController, TramiteController y TurnoController. En las dos primeras he realizado todo el crud, 
pero se que no me hará falta todo. En TurnoController he incluido crear el turno, listar y filtrar para poder tener el programa.
- 
- He creado los archivos CiudadanoServlet, TramiteServlet y TurnoServlet, aunque aún no he realizado el doget, dopost,
- También he hecho lo mismo con las vistas ciudadanos.jsp, tramites.jsp y turnos.jsp mas index.
- Tengo tres validaciones para objetos nulos, strings y colecciones nulas, asi no tengo que repetir código en los métodos.
- Ahora he incluido los get y post de CiudadanoServlet para las solicitudes http del formulario y la tabla de ciudadanos.
- 
- También he creado la vista de ciudadanos.jsp y después lo he separado en dos partials para que el código esté más limpio.
- Ahora voy a hacer lo mismo con los trámites, encuentro errores a la hora de generar la duración estimada. 
- He cambiado el tipo de dato en sql a TIME y en mi entidad a Duration, en el servlet lo parseo para recibir el parámetro.
- Me hará falta un método que convierta este tipo de enumeración al formato que deseo incluir en el formulario (Duration)
- He encontrado un método mejor, utilizando la librería util.calendar creo que es más directa y mejor. 
- Los parámetros para utilizar en el método util.calendar serán de tipo TIME. Con esto manejaré las horas minutos y segundos.
- 
- Ahora tengo un método para crear números aleatorios que los agregará si no existen en la base de datos de turno
- Crearé la lista de turnos y el formulario para dar nueva cita y para filtrar los turnos.
- Para ello necesito métodos auxiliares para generar un código numérico (ya está) y para las horas libre y ocupadas y un filtro que está basado en otro que ya hicimos
- las horas las he gestionado tb en una lista para que se pueda ir cogiendo de hora en hora, supongo que desde las 8 a las 15 h.
- Cometí errores en el método generateNumber que hace el código y findByDescripcion que recoge el nombre del trámite, pero ya se pueden visualizar y crear turnos.
- 
- He limpiado y ordenado un poco el código y el readme.
- Genero el formulario para filtrar turnos, modifico TurnoController y TurnosServlets para que se filtren correctamente.
-
- Solo me faltará cubrir detalles como que las citas se vuelvan atendidas cuando pase su fecha y hora.
- También necesitaré realizar excepciones propias y me planteo realizar un método genérico findByString que me sirva para encontrar por dni y porn nombre de trámite.
- 
