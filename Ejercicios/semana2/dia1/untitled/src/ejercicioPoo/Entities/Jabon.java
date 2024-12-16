package ejercicioPoo.Entities;

public class Jabon {
    private String marca;
    private Integer precio;
    private String fragancia;
    private String uso;

    // Constructor vacío
    public Jabon() {}

    // Constructor con parámetros
    public Jabon(String marca, Integer precio, String fragancia, String uso) {
        this.marca = marca;
        this.precio = precio;
        this.fragancia = fragancia;
        this.uso = uso;
    }

    // Getters and setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getFragancia() {
        return fragancia;
    }

    public void setFragancia(String fragancia) {
        this.fragancia = fragancia;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @Override
    public String toString() {
        return "Jabon{" +
                "marca='" + marca + '\'' +
                ", precio=" + precio +
                ", fragancia='" + fragancia + '\'' +
                ", uso='" + uso + '\'' +
                '}';
    }

    // Métodos
    public void aplicar() {
        uso = "";
        System.out.println("Se está aplicando el producto en " + uso + ".");
    }


}



