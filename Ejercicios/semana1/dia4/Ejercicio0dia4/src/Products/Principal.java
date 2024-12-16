package Products;

public class Principal {
    public static void main (String[] args){
        //void product
    Product product = new Product();

    product.setName("bread");
    product.setPrize(2.50);
    product.setDescription("integral bread");
    product.setStock(20);
    product.setCategory("Breads");

    //primer producto
    Product product1 = new Product("Cookies",2.5 , "cookies with sugar", 20, "Sweet food" );
    }
}
