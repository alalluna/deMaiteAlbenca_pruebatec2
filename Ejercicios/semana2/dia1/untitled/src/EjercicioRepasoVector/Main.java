package EjercicioRepasoVector;

import EjercicioRepasoVector.Entities.Verdura;

public class Main {
    public static void main(String[] args) {
        //a) Crear un vector (array) de tipo Verdura que pueda almacenar 5 verduras. Crear 5 verduras y guardarlas en el vector.
        Verdura[] verduras = new Verdura[5];

        verduras[0] = new Verdura(1, "naranja", "zanahoria", 35, false);
        verduras[1] = new Verdura(1, "verde", "pimiento", 40, false);
        verduras[2] = new Verdura(1, "blanca", "colifor", 25, true);
        verduras[3] = new Verdura(1, "verde", "espinacas", 23, true);
        verduras[4] = new Verdura(1, "verde", "tomate", 18, false);

        //b) Recorrer el vector creado y mostrar por pantalla el nombre y las calorías de las verduras almacenadas.
        System.out.println("\nNombre y calorias:");
        for (Verdura verdura : verduras) {
            System.out.println("El/la " + verdura.getNombre() + " tiene " + verdura.getCalorias() + " calorias.");
        }

        //c) Cambiar todos los datos de dos verduras. Mostrar por pantalla los datos de todas las verduras luego del cambio.
        System.out.println("\nDatos de todas las verduras antes del cambio:");
        for (Verdura verdura : verduras) {
            System.out.println(verdura);
        }
        verduras[0].setColor("marron");
        verduras[0].setNombre("yuca");
        verduras[0].setCalorias(50);
        verduras[0].setDebeCocinarse(true);

        verduras[2].setColor("morada");
        verduras[2].setNombre("cebolla");
        verduras[2].setCalorias(15);
        verduras[2].setDebeCocinarse(false);

        System.out.println("\nDatos de todas las verduras después del cambio:");
        for (Verdura verdura : verduras) {
            System.out.println(verdura);
        }
        // d) Recorrer el vector y mostrar por pantalla únicamente a las verduras que sean de color verde.
        System.out.println("\nVerduras de color verde:");
        for (Verdura verdura : verduras) {
            if (verdura.getColor().equals("verde")) {
                System.out.println(verdura);
            }
        }
    }
}
