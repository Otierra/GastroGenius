package Gestion.Modelo;

public class ModeloPedido {
    private int idPlatillo; 
    private String nombrePlatillo; // Nombre del platillo
    private String alteraciones; // Modificaciones o alteraciones al producto
    private boolean cancelado; // Indica si el pedido ha sido cancelado

    // Constructor
    public ModeloPedido(int idPlatillo, String nombrePlatillo, String alteraciones, boolean cancelado) {
        this.idPlatillo = idPlatillo;
        this.nombrePlatillo = nombrePlatillo;
        this.alteraciones = alteraciones;
        this.cancelado = cancelado;
    }

    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
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
                ", nombrePlatillo='" + nombrePlatillo + '\'' +
                ", alteraciones='" + alteraciones + '\'' +
                ", cancelado=" + cancelado +
                '}';
    }
}