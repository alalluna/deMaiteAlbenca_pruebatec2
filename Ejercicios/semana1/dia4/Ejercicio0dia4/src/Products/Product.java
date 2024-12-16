package Products;

public class Product {
    //atributos
    String name = "black product";
    double prize = 0.0;
    String description = "blank description";
    int stock = 0;
    String category = "blanck category";


    //contructor void
    public Product() {
    }


    //constructor con parámetros
    public Product(String name, double prize, String description, int stock, String category) {
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.stock = stock;
        this.category = category;
    }

    //getter
    public String getName() {
        return name;
    }

    public double getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //Métodos propios de la clase

    //calcular el iva

    public double ivaPrize() {
        double iva = this.prize * 0.21;  // Calculo IVA (21%)
        double priceWithIva = this.prize + iva;  // Suma
        return priceWithIva;
    }

    public double finalPrize (boolean clientRegistered){
        double prizeWithIva = ivaPrize();

        if (clientRegistered) {

            return priceWithIva / 2;
        } else {
            return priceWithIva;
        }
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", prize=" + prize +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }
}
