package poo001abstraccion;

public class Automovil {

    public String marca;
    private String modelo;
    protected String color;
    private Integer velocidad;


    public Automovil() {
    }

    public Automovil(String marca, String modelo, String color, Integer velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidad = velocidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }
    //métodos personalizados
    public void frenar(){
        velocidad += 10;
        System.out.println("El automovil está acelerando. Velocidad actual " + velocidad + "km/h");
    }
    public void acelerar(){
        velocidad -= 10;
        System.out.println("El automovil está frenando. Velocidad actual " + velocidad + "km/h");
    }
}

