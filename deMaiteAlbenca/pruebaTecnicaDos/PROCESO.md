            -- Desarrollo del proyecto en el tiempo --

- He creado la estructura inicial, editando pom con las dependencias necesarias, 
añadiendo el archivo persistence e incluyendo la configuración de la fábrica y el crud genérico.
- También he incluido un footer, un head y en header para las vistas. Tengo reciclada una maquetación bootstrap.

- He creado tres entidades. Ciudadano y Tramite tienen relación one to many con la tercera relación (Turno).
que tiene many to one para corresponderse correctamente con las anteriores.

- Ahora he hecho CiudadanoController, TramiteController y TurnoController. En las dos primeras he realizado todo el crud, luego omitiré lo que no pueda utilizar. En TurnoController he incluido crear el turno, listar y filtrar para poder tener el programa.

- He creado los archivos CiudadanoServlet, TramiteServlet y TurnoServlet sin el código.
- También he hecho lo mismo con las vistas ciudadanos.jsp, tramites.jsp y turnos.jsp mas index.

- Todos los datos como fechas, horas y numeros los concentraré en FormatNumbers y los otros en Validations.
- Los nombro en ingles para diferenciarlos de los controllers, ya que en controller los tengo en spainglish.

- Tengo tres validaciones para objetos nulos, strings y colecciones nulas, asi no tengo que repetir código.
- Ahora he incluido los get y post de CiudadanoServlet para las solicitudes http del formulario y la tabla ciudadanos.

- También he creado la vista ciudadanos.jsp y después lo he separado en dos partials para que el código esté más limpio.
- Ahora voy a hacer lo mismo con los trámites, encuentro errores a la hora de generar la duración estimada.
 
- He cambiado el tipo de dato en sql a TIME y en mi entidad a Duration, en servlet lo parseo para recibir el parámetro.
- Me hará falta un método que convierta este tipo de números al formato que deseo incluir en el formulario (Duration), unque encuentro problemas.
- He encontrado un método mejor, utilizando la librería util.calendar creo que es más directa y mejor. 
- Los parámetros para utilizar util.calendar serán de tipo TIME. Con esto manejaré las horas minutos y segundos.
 
- Ahora tengo un método para crear números aleatorios que los agregará si no existen en la base de datos.
- Crearé la lista de turnos y el formulario para dar nueva cita y para filtrar los turnos.
- Para ello necesito métodos auxiliares para generar horas libres y ocupadas y un filtro de fecha de inicio y fin y estado que está basado en otro que ya hicimos.

- Las horas las he gestionado tb en una lista para que se pueda ir cogiendo de hora en hora, suponiendo que los 
funcionarios trabajan desde las 8 a las 15 h y tardan una hora en gestionar un trámite.
 
- Cometí errores en el método generateNumber que hace el código y findByDescripcion que recoge el nombre del trámite, pero ya se pueden visualizar y crear turnos.
 
- He limpiado y ordenado un poco el código y el readme.

- Genero el formulario para filtrar turnos, modifico TurnoController y TurnosServlets para que se filtren correctamente.
- Corregí el método filterTurno para que las citas se vuelvan atendidas cuando pase su fecha y hora (del día actual).
 
- En lugar de realizar excepciones personalizadas he investigado y he encontrado una forma de redirigir a una página de error en cualquier excepción.@WebFilter("/*"): Esta anotación te permite realizar una vista de error en todas las excepciones de todas las páginas y volver atrás para mejorar la navegación por la página.
- Con request.setAttribute("errorMessage", ex.getMessage()) se obtiene la página de error y me dirá qué hay mal y con .getHeader("Referer") obtiene la url y va hacia atrás. Y con previousPage me redirigirá atrás si es el inicio.
 
- Después de añadir la página de excepción he hecho más pruebas y compruebo que puedo introducir fechas de nacimiento incorrectas, repetir trámites y añadir turnos en horas y fechas que pasaron. Debo corregirlo.

- Una vez corregidos  con validoBorn, uniquevalue y compareDatesAndHours hago nuevas comprobaciones para ver que todo funciona.

- De nuevo limpio el codigo , para tenerlo mas ordenado, delegando las obligaciones a controladores, utils y servlets. 

- Por ultimo , cambio ligeramente aspectos esteticos que hacen que la página se vea mejor.Incluido el Readme
 
- Me planteo realizar un método genérico findByString que me sirva para encontrar por cualquier string (para buscar por dni en Ciudadano y por nombre de trámite).

