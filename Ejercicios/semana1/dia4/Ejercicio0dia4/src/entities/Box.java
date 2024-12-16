package entities;

public class Box {
    String size;
    String color;
    boolean opening;

    //constructor void
    public Box(){
    }

    //constructor con parámetros
    public Box(String color,String size,boolean opening){
        this.size= size;
        this.color=color;
        this.opening=opening;

    }
    //getters
    public String getSize(){
        return size;
    }
    public String getColor(){
        return color;
    }
    public boolean getOpening(){
        return opening;
    }

    //setters
    public void setColor(String color){
        this.color = color;
    }
    public void setSize(String size){
        this.size = size;
    }
    public void setOpening(boolean opening){
        this.opening = opening;
    }

    //métodos
    public void open(){
        if (this.opening) {
            System.out.println("La caja ya está abierta.");
        } else {
            this.opening = true;
            System.out.println("La caja se ha abierto.");
            this.setOpening(true);
        }
    }

    public void close(){
        if (!this.opening) {
            System.out.println("La caja ya está cerrada.");
        } else {
            this.opening = false;
            System.out.println("La caja se ha cerrado.");
            this.setOpening(false);
        }

    }

    // Método toString
    @Override
    public String toString() {
        return "Box{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", opening=" + opening +
                '}';
    }
}