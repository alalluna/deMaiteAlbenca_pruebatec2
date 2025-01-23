# Proyecto: Sistema de Gestión de Citas con la Seguridad Social

Este proyecto implementa un sistema para la gestión de citas en la Seguridad Social. 
Utiliza tecnologías como **Java**, **JSP**, **Servlets** y **Bootstrap** para la interfaz. 

---

## 🛠️ Desarrollo del Proyecto

### 1. Configuración Inicial
- Creación de la estructura de carpetas del proyecto.
- Configuración del archivo `pom.xml` con las dependencias necesarias.
- Inclusión del archivo `persistence.xml` en META-INF.
- Configuración de la fábrica de entidades(ConfigJPA) y CRUD genérico(GenericoJPA).

### 2. Diseño de la Interfaz
- Inclusión de componentes reutilizados y reutilizables:
  - **Header**
  - **Footer**
  - **Head**
  - **Index**
  - **Estructura fundamental para las páginas**
  - **Estructura fundamental para los formularios**
- Uso de una maquetación basada en **Bootstrap** y **FontAwesome** para lograr un diseño responsivo y limpio.
- Uso de imágenes que tengo en mi pc de mi marca personal.

### 3. Modelado de Datos
- Creación de las entidades principales:
  - **Ciudadano**
  - **Trámite**
  - **Turno**
- Relaciones entre las entidades:
  - **Ciudadano** y **Trámite** tienen una relación **One-to-Many** con **Turno**.
  - **Turno** tiene una relación **Many-to-One** con **Ciudadano** y **Trámite**.

---

## 🚀 Funcionalidades Implementadas

### 1. Controladores
- **CiudadanoController**, **TramiteController** y **TurnoController**:
  - Gestión del CRUD para las entidades:
  - Métodos para crear, listar y encontrar por datos en Ciudadano y Tramite.
  - Método para  crear turnos con sus metodos auxiliares:
      - generar numero aleatorio
      - filtrar horas ocupadas
      - listar horas libres
  - Métodos para listar y filtrar turnos, dentro de los cuales hay otro metodos auxiliares.


### 2. Servlets y Vistas
- **CiudadanoServlet**:
  - Implementación de métodos `GET` y `POST` para manejar exclusivamente solicitudes HTTP.
- **Vistas JSP**:
  - Diseño inicial en `ciudadanos.jsp`.
  - Separación en partials para mayor limpieza y reutilización del código.
  - Imitación del resto de vistas a partir de ciudadanos.

- A partir de estos archivos, creación de nuevos servlets 
**TurnosServlet**, **TramitesServlet** ,**FiltroServlet**

### 3. Gestión numérica **FormatNumbers**
- Gestión de las fechas:
  - Aprendizaje de utils Duration (aunque luego no lo use)
  - Cambio del tipo de dato para el uso de utils Calendar:
    - **SQL**: `DATE` y`TIME`.
    - **Entidad**: `LOCALDATE` y`TIME`.
  - Fechas de nacimiento válidas(nadie vive mas de 110 años)
- Métodos auxiliares para:
  - Parseo de parámetros.(Validación y parseo tb)
  - Conversión entre formatos.
  - Generación de horarios disponibles, considerando:
    - Horario laboral: 8:00 - 15:00.
    - Duración de trámites: 1 hora.

### 4. Corrección de errores en la ejecución del código
- Validaciones generales para evitar duplicación de código:
    - Objetos nulos.
    - Strings vacíos.
    - Colecciones nulas.
  - Crear turnos no repetidos.
  - Gestionar horarios libres y ocupados.
  - Filtrar turnos por fecha de inicio, fin y/o estado.

---

## ⚙️ Optimización y Manejo de Errores WebFilter

- Implementación de un **WebFilter** para manejar excepciones globales:
  - Redirección a una página de error personalizada.
  - Uso de `request.setAttribute("errorMessage", ex.getMessage())` para mostrar mensajes detallados.
  - Navegación de regreso con `.getHeader("Referer")`.

---

## 🔧 Corrección de Errores

### Errores Identificados y Solucionados
1. Fechas de nacimiento incorrectas (nadie vive mas de 110 años).
2. Trámites con nombres y/o descripción duplicados.
3. Turnos realizados en horas y fechas pasadas.

### Soluciones que se implementaron
- Validaciones:
  - Propiedad `unique=true` en columnas relevantes (como "nombre" en **Trámite**).
  - Métodos auxiliares para:
    - Validar fechas de nacimiento.
    - Evitar duplicados en listas.
- Lógica de creación de turnos:
  - Solo permite citas futuras.
  - Actualización automática del estado de los turnos al pasar su fecha/hora.

---

## 🧹 Limpieza y Revisión Final

- Reorganización y limpieza del código.
- Refactorización de métodos para mejorar legibilidad:
  - Delegación de funciones a clases auxiliares, como `FormatNumbers`.
  - Delegación de la lógica al controlador para que el servlet solo se ocupe de las solicitudes http. 
- Pruebas exhaustivas de todas las funcionalidades y manejo de excepciones.

---

## 📌 Ideas para Implementar
- Generar mas metodos genericos como FindByParameter para la busqueda por dni y nombre.
- Mejorar el diseño y usabilidad de la interfaz.
