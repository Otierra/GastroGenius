
package Gestion.Modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloOrden {
    private int numeroOrden;
    private int mesaId;
    private List<ModeloPlatilloMenu> platillos;

    // Constructor
    public ModeloOrden(int numeroOrden, int mesaId) {
        this.numeroOrden = numeroOrden;
        this.mesaId = mesaId;
        this.platillos = new ArrayList<>();
    }

    // Getters y setters
    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }

    public List<ModeloPlatilloMenu> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<ModeloPlatilloMenu> platillos) {
        this.platillos = platillos;
    }

    // Método para agregar un platillo a la orden
    public void agregarPlatillo(ModeloPlatilloMenu platillo) {
        platillos.add(platillo);
    }

    // Método toString para representación textual de la orden
    @Override
    public String toString() {
        return "Orden{" +
                "numeroOrden=" + numeroOrden +
                ", mesaId=" + mesaId +
                ", platillos=" + platillos +
                '}';
    }
}

