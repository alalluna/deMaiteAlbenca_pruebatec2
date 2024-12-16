import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edad;

        // Solicitar edad al usuario
        System.out.println("Introduce tu edad para acceder a la disco. Debe ser un valor superior a 1 e inferior a 100:");
        edad = scanner.nextInt();

        // Validar que la edad esté en el rango permitido
        while (edad <= 1 || edad >= 100) {
            System.out.println("Debes introducir una edad válida:");
            edad = scanner.nextInt();
        }

        // Determinar si puede ingresar a la disco
        if (edad >= 18) {
            System.out.println("Puedes entrar en la disco.");
        } else if (edad >= 16) {
            System.out.println("Puedes pasar a la disco acompañado de un adulto.");
        } else {
            System.out.println("No puedes acceder a la disco.");
        }

        scanner.close();
    }
}