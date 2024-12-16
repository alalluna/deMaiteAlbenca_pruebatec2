public class Main {
    public static void main(String[] args) {

        int numero;
        double numbertwo;
        boolean boleano;
        String nombre;




        // Integer Double Boolean String para poder ponerle clases
        numero = 12;
        numbertwo = 10;
        boleano = false;
        nombre = "Maite";

        System.out.println(numero + " " + numbertwo + " " + boleano + " " + nombre);
    }
}

//si asigno un int en el String no pasa nada, toma el número por un string porque lo he puesto entre comillas
// si asigno un int a un string sin comillas , java me manda el siguiente mensaje: java: incompatible types: int cannot be converted to java.lang.String
//si asigno un 1 al boolean me lanza el siguiente mensaje de error: java: incompatible types: int cannot be converted to boolean
//si asigno un numero int en el double, me convierte el numero a double(10 = 10.00)
//si asigno un numero double a mi int me lanza el siguiente mensaje de error: java: incompatible types: possible lossy conversion from double to int