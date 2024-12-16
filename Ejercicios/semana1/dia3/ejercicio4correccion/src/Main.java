import Teatro.Mapa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hola!");
        char [][] asientos = new char[5][5];
        Integer fila, asiento, opcion;
        Boolean continuar = false;

        Scanner sc = new Scanner(System.in);

        for (int f = 0; f < asientos.length; f++){
            for (int c = 0; c < asientos[0].length; c++){
               asientos[f][c] = 'O';
            }
        }
        Mapa.dibujarMapa(asientos);

        while(continuar != true){
            System.out.println ( "ingrese la fila entre 0 y 4");
            fila = sc.nextInt();
        }
    }
}