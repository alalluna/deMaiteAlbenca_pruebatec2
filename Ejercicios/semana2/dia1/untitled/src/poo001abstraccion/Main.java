package poo001abstraccion;

public class Main {
    public static void main(String[] args) {

        Automovil autoNormal = new Automovil("toyota", "corolla", "azul", 0);
        autoNormal.acelerar();
        autoNormal.acelerar();

        autoNormal.frenar();

    }
}