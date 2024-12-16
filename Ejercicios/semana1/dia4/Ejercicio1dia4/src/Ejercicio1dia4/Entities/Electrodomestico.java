package Ejercicio1dia4.Entities;

public class Electrodomestico {
    Integer cod;
    String color;
    String marca;
    double consumo;
    String modelo;

    public Electrodomestico() {
    }

    public Electrodomestico(Integer cod, String color, String marca, double consumo, String modelo) {
        this.cod = cod;
        this.color = color;
        this.marca = marca;
        this.consumo = consumo;
        this.modelo = modelo;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Electrodomestico{" +
                "color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", consumo=" + consumo +
                ", modelo='" + modelo + '\'' +
                ", cod=" + cod +
                '}';
    }
}