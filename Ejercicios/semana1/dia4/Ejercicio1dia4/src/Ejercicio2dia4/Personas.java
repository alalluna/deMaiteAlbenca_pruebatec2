package Ejercicio2dia4;

import Ejercicio2dia4.Entities.Persona;

public class Personas {

    public static void main(String[]args){
        Persona[] personaVector = new Persona[5];
        //5 personas
        personaVector[0] = new Persona(1, "Lucia", 14, "direccion1","677489090");
        personaVector[1] = new Persona(2, "Lara", 15, "direccion2","650489190");
        personaVector[2] = new Persona(3, "Maria", 40, "direccion3","665409220");
        personaVector[3] = new Persona(4, "Patricia", 40, "direccion4","675909070");
        personaVector[4] = new Persona(5, "Alicia", 40, "direccion5","679409065");

        for ( Persona persona: personaVector){
            System.out.println( "Nombre"+ persona.getNombre() + "y su edad" +persona.getEdad());
        }

        System.out.println("Antes se llamaba: " + personaVector[0].getNombre());
        personaVector[0].setNombre("Antonia");
        System.out.println("Ahora se llama " + personaVector[0].getNombre());

        System.out.println("Antes se llamaba: " + personaVector[0].getNombre());
        personaVector[0].setNombre("Lucia");
        System.out.println("Ahora se llama " + personaVector[0].getNombre());

        for ( Persona persona: personaVector){
            if(persona.getEdad() > 30) System.err.println("Nombre "+ persona.getNombre()+ " y su edad es: " + persona.getTelf());
        }
    }
}
