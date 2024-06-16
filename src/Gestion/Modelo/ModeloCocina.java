
package Gestion.Modelo;

public class ModeloCocina {
    
    private int ordenID;
    private int platilloID;
    private String platillo;
    private String prioridad;
    private String status; 
    private boolean inicioPreparacion;
    
    // Constructor
    public ModeloCocina(int ordenID, int platilloID, String platillo, String prioridad, String status, boolean inicioPreparacion) {
        this.ordenID = ordenID;
        this.platilloID = platilloID;
        this.platillo = platillo;
        this.prioridad = prioridad;
        this.status = status;
        this.inicioPreparacion = inicioPreparacion;
    }

    // Getters
    public int getOrdenID() {
        return ordenID;
    }

    public int getPlatilloID() {
        return platilloID;
    }

    public String getPlatillo() {
        return platillo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getStatus() {
        return status;
    }

    public boolean isInicioPreparacion() {
        return inicioPreparacion;
    }

    // Setters
    public void setOrdenID(int ordenID) {
        this.ordenID = ordenID;
    }

    public void setPlatilloID(int platilloID) {
        this.platilloID = platilloID;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInicioPreparacion(boolean inicioPreparacion) {
        this.inicioPreparacion = inicioPreparacion;
    }
}
