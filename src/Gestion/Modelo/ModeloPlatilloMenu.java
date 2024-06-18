
package Gestion.Modelo;

public class ModeloPlatilloMenu {
    private int id;
    private String descripcion;
    private double precio;
    private String categoria; // Categoría del platillo
    private boolean esComida; // Indica si es comida (true) o bebida (false)
    private int tiempoDePreparacion; // Tiempo de preparación en minutos

    // Constructor
    public ModeloPlatilloMenu(int id, String descripcion, double precio, String categoria, boolean esComida, int tiempoDePreparacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.esComida = esComida;
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public ModeloPlatilloMenu(String descripcion, double precio, String categoria, boolean esComida, int tiempoDePreparacion) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.esComida = esComida;
        this.tiempoDePreparacion = tiempoDePreparacion;
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

    public boolean isEsComida() {
        return esComida;
    }

    public void setEsComida(boolean esComida) {
        this.esComida = esComida;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

}
