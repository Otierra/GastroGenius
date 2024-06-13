
package Gestion.Modelo;

public class ModeloPlatilloMenu {
    private int id;
    private String descripcion;
    private double precio;
    private String categoria; // Agregando una categoría para el platillo, opcional

    // Constructor
    public ModeloPlatilloMenu(int id, String descripcion, double precio, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método toString para representación textual del platillo
    @Override
    public String toString() {
        return "PlatilloMenu{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
