import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[7];
        double suma = 0.0;
        double promedio = 0.0;

        System.out.println("calculamos la suma de las temperaturas máximas");

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.println("Introduce la temperatura máxima del día " + (i + 1) + ":");
            temperaturas[i] = sc.nextDouble();

        }

        System.out.println("calculamos el promedio");

        for (int i = 0; i < temperaturas.length; i++) {
            suma += temperaturas[i];
        }

        // Calculo
        promedio = suma / temperaturas.length;
        System.out.println("El promedio de temperatura máxima de la última semana es: " + promedio);
        sc.close();
    }
}
