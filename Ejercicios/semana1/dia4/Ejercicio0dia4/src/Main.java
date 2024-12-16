import entities.Box;

public class Main {
    public static void main(String[] args) {
        //vacio
        Box box1 = new Box();
        box1.setSize("S");
        box1.setColor("red");
        box1.setOpening(false);
        System.out.println(box1);

        // Abrir la caja
        box1.open();
        System.out.println(box1);

        // Cerrar la caja
        box1.close();
        System.out.println(box1);

        // Con parámetros
        Box box2 = new Box("blue", "XL", false);
        System.out.println(box2);
    }
}
