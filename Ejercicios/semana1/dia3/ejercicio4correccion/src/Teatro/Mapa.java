package Teatro;

public class Mapa {
    public static void dibujarMapa(char[][] asientos){
        //dibujar mi mapa con un metodo
        for (int f = 0; f < asientos.length; f ++){
            System.out.println( f + " ");

            for (int c = 0; c < asientos[0].length; c++){
                System.out.println( f + "[ "+ asientos[f][c] +" ]");
            }
            System.out.println(" ");

        }
    }
}
