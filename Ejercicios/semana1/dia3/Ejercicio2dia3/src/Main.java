import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double precio;
        Double total = 0.0;
        boolean continuar = false;

        while (!continuar) {
            System.out.println("Introduce el precio del producto (o 0 para finalizar):");
            precio = sc.nextDouble();

            if (precio > 0)  total += precio;
                else continuar = true;

            //try {
            //  precio = sc.nextDouble();
            //    if (precio == 0) {
            //        break;
            //    }
            //    total += precio;
            //} catch (Exception e) {
            //    System.out.println("Introduce un número correcto.Ejem: 2,5.");
            //    sc.nextDouble();
            //}
        }
        System.out.println("Tu compra tine un valor total de: " + total);
    }
}
