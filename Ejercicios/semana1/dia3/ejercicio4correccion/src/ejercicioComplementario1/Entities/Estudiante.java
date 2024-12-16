package ejercicioComplementario1.Entities;

import java.util.Arrays;

public class Estudiante {
    String nombre;
    Integer edad;
    double[] calificaciones;

    //constructor vacio
    //public Estudiante(String nombre, int edad, double[] calificaciones) {}

    //constructor con parametros
    public Estudiante(String nombre, Integer edad, double[] calificaciones) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = calificaciones;
    }

    //getters and setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }
    public void setCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    //Metodos

    //Promedio
    public double promedio(){
        if(calificaciones == null || calificaciones.length == 0) {
            return 0.0 ;
        }
        double sumaCalificacion = 0.0 ;
        for(double calificacion : calificaciones){
            sumaCalificacion += calificacion;
        }
        return sumaCalificacion/calificaciones.length;
    }

    //Aprobado
    public boolean aprobado(){
        return promedio() >= 6.0 ;
    }

    //toString
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", calificaciones=" + Arrays.toString(calificaciones) +
                ", promedio=" + promedio() +
                ", aprobado=" + (aprobado() ? "Sí" : "No") +
                '}';
    }
}
