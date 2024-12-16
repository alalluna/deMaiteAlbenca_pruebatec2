package ejercicioComplementario1;

import ejercicioComplementario1.Entities.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        boolean continuar = false;

        while (!continuar) {
            System.out.println("Lista de estudiantes:");
            System.out.println("1. Introducir estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                introducirEstudiante(scanner, listaEstudiantes);
            } else if (opcion == 2) {
                mostrarEstudiantes(listaEstudiantes);
            } else if (opcion == 3) {
                System.out.println("Saliendo del programa...");
                continuar = true;
                scanner.close();
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    private static void introducirEstudiante(Scanner scanner, List<Estudiante> listaEstudiantes) {
        scanner.nextLine();  // Limpiar el buffer
        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad del estudiante: ");
        int edad = scanner.nextInt();
        System.out.print("Número de calificaciones: ");
        int numCalificaciones = scanner.nextInt();

        double[] calificaciones = new double[numCalificaciones];
        for (int i = 0; i < numCalificaciones; i++) {
            System.out.print("Calificación " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextDouble();
        }

        Estudiante estudiante = new Estudiante(nombre, edad, calificaciones);
        listaEstudiantes.add(estudiante);
        System.out.println("Estudiante añadido exitosamente.");
    }

    private static void mostrarEstudiantes(List<Estudiante> listaEstudiantes) {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes para mostrar.");
        } else {
            for (Estudiante estudiante : listaEstudiantes) {
                System.out.println(estudiante);
            }
        }
    }
}
