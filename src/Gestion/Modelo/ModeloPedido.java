package Gestion.Modelo;

public class ModeloPedido {
    private int idOrden;
    private int idPlatilloMenu;
    private String alteraciones; // Modificaciones o alteraciones al producto

    // Constructor
    public ModeloPedido(int idOrden, int idPlatilloMenu, String alteraciones) {
        this.idOrden = idOrden;
        this.idPlatilloMenu = idPlatilloMenu;
        this.alteraciones = alteraciones;
    }

    // Getters y setters
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdPlatilloMenu() {
        return idPlatilloMenu;
    }

    public void setIdPlatilloMenu(int idPlatilloMenu) {
        this.idPlatilloMenu = idPlatilloMenu;
    }

    public String getAlteraciones() {
        return alteraciones;
    }

    public void setAlteraciones(String alteraciones) {
        this.alteraciones = alteraciones;
    }

    // Método toString para representación textual del pedido
    @Override
    public String toString() {
        return "Pedido{" +
                "idOrden=" + idOrden +
                ", idPlatilloMenu=" + idPlatilloMenu +
                ", alteraciones='" + alteraciones + '\'' +
                '}';
    }
}
