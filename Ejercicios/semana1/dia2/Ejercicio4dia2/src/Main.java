import java.util.Scanner;

public class Main {
    static int numberOne;
    static int numberTwo;
    static int add;
    static int substract;
    static int multiplication;
    static double division;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("VAMOS A REALIZAR OPERACIONES MATEMATICAS :) ");

        System.out.println("Introduce un número entero para empezar: ");
        numberOne = scanner.nextInt();

        System.out.println("Introduce otro número más pequeño para poder realizar las operaciones: ");
        numberTwo = scanner.nextInt();

        //validar
        //while(numberTwo > numberOne){
        //  System.out.println("Introduce un número más bajo para poder operar");
        //numberTwo = scanner.nextInt();
        //}

        add = numberOne + numberTwo;
        substract = numberOne - numberTwo;
        multiplication = numberOne * numberTwo;

        // Manejar la división por cero
        if (numberTwo != 0) {
            division = (double) numberOne / numberTwo;
        } else {
            System.out.println("No se puede dividir por cero");
            division = 0; // Valor por defecto
        }
        System.out.println("La suma de tus dos números es: "+ add);
        System.out.println("La resta de tus dos números es: "+ substract);
        System.out.println("La multiplicación de tus dos números es: "+ multiplication);
        System.out.println("La división de tus dos números es: " + division);

    }
}