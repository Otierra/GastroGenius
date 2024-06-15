package Gestion.Modelo;

public class ModeloPedido {
    private int idOrden;
    private String nombrePlatillo; // Nombre del platillo
    private String alteraciones; // Modificaciones o alteraciones al producto
    private boolean cancelado; // Indica si el pedido ha sido cancelado

    // Constructor
    public ModeloPedido(int idOrden, String nombrePlatillo, String alteraciones, boolean cancelado) {
        this.idOrden = idOrden;
        this.nombrePlatillo = nombrePlatillo;
        this.alteraciones = alteraciones;
        this.cancelado = cancelado;
    }

    // Getters y setters
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public String getAlteraciones() {
        return alteraciones;
    }

    public void setAlteraciones(String alteraciones) {
        this.alteraciones = alteraciones;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    // Método toString para representación textual del pedido
    @Override
    public String toString() {
        return "Pedido{" +
                "idOrden=" + idOrden +
                ", nombrePlatillo='" + nombrePlatillo + '\'' +
                ", alteraciones='" + alteraciones + '\'' +
                ", cancelado=" + cancelado +
                '}';
    }
}