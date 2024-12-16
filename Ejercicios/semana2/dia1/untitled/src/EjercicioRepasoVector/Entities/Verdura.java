package EjercicioRepasoVector.Entities;

public class Verdura {
    private Integer id;
    private String nombre;
    private String color;
    private Integer calorias;
    private Boolean debeCocinarse;

    //constructor 1
    public Verdura() {
    }

    //constructor 2
    public Verdura(Integer id, String color, String nombre, Integer calorias, Boolean debeCocinarse) {
        this.id = id;
        this.color = color;
        this.nombre = nombre;
        this.calorias = calorias;
        this.debeCocinarse = debeCocinarse;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getDebeCocinarse() {
        return debeCocinarse;
    }

    public void setDebeCocinarse(Boolean debeCocinarse) {
        this.debeCocinarse = debeCocinarse;
    }

    //toString
    public String toString() {
        return "Verdura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", calorias=" + calorias +
                ", debeCocinarse=" + debeCocinarse +
                '}';
    }
}
