import java.util.Scanner;

public class Main {
    static int edad;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduce tu edad para el acceso al Recital");
        edad = sc.nextInt();
        if (edad >= 18) {
            System.out.println("Puedes acceder al Recital");
        } else {
            System.out.println("No puedes acceder al Recital");
        }
        //sc.close(); se supone que esto es de buena práctica
    }
}