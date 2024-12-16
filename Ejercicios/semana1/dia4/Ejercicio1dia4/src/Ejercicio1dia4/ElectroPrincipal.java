package Ejercicio1dia4;

import Ejercicio1dia4.Entities.Electrodomestico;

public class ElectroPrincipal {

    public static void main(String[] args) {

        System.out.println("Electrodomesticos");
        //instancia con parametros
        Electrodomestico e1 = new Electrodomestico(1,"gray","samsung", 2.67 , "new");
        Electrodomestico e2 = new Electrodomestico(2,"white","bosh", 2.98 , "casual");
        Electrodomestico e3 = new Electrodomestico(3,"black","next", 2.03 , "modern");

        //instancia sin parametros
        Electrodomestico electrodomestico = new Electrodomestico();

        //imprimir por pantalla
        System.out.println(e1+"\n"+e2+"\n"+e3);

        //capturar info de un obj sin parametros
        System.out.println(electrodomestico);
    }

}

