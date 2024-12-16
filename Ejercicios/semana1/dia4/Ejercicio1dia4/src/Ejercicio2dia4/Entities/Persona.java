package Ejercicio2dia4.Entities;

public class Persona {
    Integer id;
    String nombre;
    Integer edad;
    String direccion;
    String telf;


    //constructor vacio

    public Persona() {
    }

    //contructor con parametros


    public Persona(Integer id, String nombre, Integer edad, String direccion, String telf) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telf = telf;
    }
    //getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    //tostring

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", telf='" + telf + '\'' +
                '}';
    }
}
