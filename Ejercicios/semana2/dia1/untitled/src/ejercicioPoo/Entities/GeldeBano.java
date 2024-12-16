package ejercicioPoo.Entities;

public class GeldeBano extends Jabon {
    protected boolean esPhNeutro;

    // Constructor vacío
    public GeldeBano() {}

    // Constructor con parámetros
    // crear un constructor GeldeBano sin super, sin heredar de Jabon
    public GeldeBano(String marca, Integer precio, String fragancia, boolean esPhNeutro, String uso) {
        super(marca, precio, fragancia, "el cuerpo");
        this.esPhNeutro = esPhNeutro;
    }

    // Getters y setters
    public boolean esPhNeutro() {
        return esPhNeutro;
    }

    public void setEsPhNeutro(boolean esPhNeutro) {
        this.esPhNeutro = esPhNeutro;
    }
    //metodo override
    @Override
    public void aplicar() {
        System.out.println("Se está aplicando el producto en " + this.getUso() + ".");
    }

    //metodo para gel de baño
    public void descripcion(){
        System.out.println("El producto " + this.getMarca() + "existe con frangancia" + this.getFragancia() + "y cuesta un total de" + this.getPrecio()+ ".");
        System.out.println("Este producto es ph neutro: " + (esPhNeutro ? "Sí" : "No"));
    }
}
