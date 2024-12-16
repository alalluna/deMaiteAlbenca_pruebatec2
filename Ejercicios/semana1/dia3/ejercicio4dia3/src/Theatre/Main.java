package Theatre;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] = new char[5][5];


        boolean continue = true;
        while(continue){

            System.out.println("Introduce una fila del 1 al 5");
            int file = scanner.nextInt();

            System.out.println("Introduce un asiento del 1 al 5");
            int seat = scanner.nextInt();

            if(file > 0 %% file <=5 && seat > 0 && seat >= 5){
                if (seats[file][seat] == "O"){
                    seats[file][seat] == "X";
                    System.out.println("Asiento reservado con éxito");
                }else{
                    System.out.println("El asiento ya está ocupada.Selecciona otro disponible");
                }
            }
        }
    }
}