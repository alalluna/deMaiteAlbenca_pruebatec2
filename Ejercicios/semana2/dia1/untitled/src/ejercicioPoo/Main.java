package ejercicioPoo;

import ejercicioPoo.Entities.GeldeBano;
import ejercicioPoo.Entities.JabonRopa;

public class Main {
    public static void main(String[] args) {

        JabonRopa aloeVera = new JabonRopa("AloeVera", 5,"Aloe", true, "la ropa");
        aloeVera.aplicar();
        aloeVera.descripcion();

        JabonRopa aMano = new JabonRopa("quitamanchas", 5,"sinFragancia", false, "la ropa");
        aMano.aplicar();
        aMano.descripcion();

        GeldeBano gelNatural = new GeldeBano("Super Natural", 3,"fresca", true, "el cuerpo");
        gelNatural.aplicar();
        gelNatural.descripcion();

        GeldeBano gelNova = new GeldeBano("Nova", 3,"rosas", false, "el cuerpo");
        gelNova.aplicar();
        gelNova.descripcion();

    }

}