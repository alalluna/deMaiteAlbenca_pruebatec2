package ejercicioPoo.Entities;

public class JabonRopa extends Jabon {
    protected boolean esParaLavadora;

    // Constructor vacío
    public JabonRopa() {}

    // Constructor con parámetros
    //llamar a JabonRopa no al padre
    public JabonRopa(String marca, Integer precio, String fragancia, boolean esParaLavadora, String uso) {
        super(marca, precio, fragancia, "la ropa");
        this.esParaLavadora = esParaLavadora;
    }

    public JabonRopa(boolean esParaLavadora) {
        this.esParaLavadora = esParaLavadora;
    }

    // Getters y setters
    public boolean isEsParaLavadora() {
        return esParaLavadora;
    }

    public void setEsParaLavadora(boolean esParaLavadora) {
        this.esParaLavadora = esParaLavadora;
    }

    //metodo
    @Override
    public void aplicar() {
        System.out.println("Se está aplicando el producto en " + this.getUso() + ".");
    }

    //metodo para jabon para la lavadora
    public void descripcion(){
        System.out.println("El producto " + this.getMarca() + "existe con frangancia" + this.getFragancia() + "y cuesta un total de" + this.getPrecio()+ ".");
        System.out.println("Este producto es para lavadora: " + (esParaLavadora ? "Sí" : "No"));
    }

}
