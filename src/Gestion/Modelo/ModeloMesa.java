package Gestion.Modelo;

public class ModeloMesa {
    private int idMesa;
    private int idOrden;
    private boolean disponible; // Indica si la mesa está disponible

    // Constructor
    public ModeloMesa(int idMesa, int idOrden, boolean disponible) {
        this.idMesa = idMesa;
        this.idOrden = idOrden;
        this.disponible = disponible;
    }

    // Getters y Setters
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ModeloMesa{" +
                "idMesa=" + idMesa +
                ", idOrden=" + idOrden +
                ", disponible=" + disponible +
                '}';
    }
}

