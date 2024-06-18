
package Gestion.Controlador;

import Gestion.Modelo.ModeloPlatilloMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestorPlatillos {
    private static final int TAMANO_MAXIMO = 100; // Tamaño máximo del array
    private static ModeloPlatilloMenu[] platillos = new ModeloPlatilloMenu[TAMANO_MAXIMO];
    private int cantidad;

    public GestorPlatillos() {
      
    }   

    // Método para obtener el array de platillos no vacíos
    public ModeloPlatilloMenu[] obtenerPlatillos() {
        List<ModeloPlatilloMenu> platillosFiltrados = new ArrayList<>();
        for (ModeloPlatilloMenu platillo : platillos) {
            if (platillo != null) {
                platillosFiltrados.add(platillo);
            }
        }
        return platillosFiltrados.toArray(new ModeloPlatilloMenu[0]);
    }

    public static ModeloPlatilloMenu[] obtenerPlatillosComida() {
        List<ModeloPlatilloMenu> platillosComida = new ArrayList<>();
        for (ModeloPlatilloMenu platillo : platillos) {
            if (platillo != null && platillo.isEsComida()) {
                platillosComida.add(platillo);
            }
        }
        return platillosComida.toArray(new ModeloPlatilloMenu[0]);
    }

    public static ModeloPlatilloMenu[] obtenerPlatillosBebida() {
        List<ModeloPlatilloMenu> platillosBebida = new ArrayList<>();
        for (ModeloPlatilloMenu platillo : platillos) {
            if (platillo != null && !platillo.isEsComida()) {
                platillosBebida.add(platillo);
            }
        }
        return platillosBebida.toArray(new ModeloPlatilloMenu[0]);
    }
    
    
    // Método para agregar un platillo
    public void agregarPlatillo(ModeloPlatilloMenu platillo) {
        for (int i = 0; i < TAMANO_MAXIMO; i++) {
            if (platillos[i] == null || platillos[i].getDescripcion() == null || platillos[i].getDescripcion().isEmpty()) {
                platillo.setId(i);
                System.out.println(platillo);
                platillos[i] = platillo;
                cantidad++;
                return; // Salir del método una vez que se haya agregado el platillo
            }
        }
        System.out.println("El arreglo de platillos está lleno. No se puede agregar más platillos.");
    }

    // Método para buscar un platillo por su id
    public ModeloPlatilloMenu buscarPlatillo(int id) {
         for (ModeloPlatilloMenu platillo : platillos) {
            if (platillo.getId() == id) {
                return platillo;
            }
        }
        return null;
    }
    
    public ModeloPlatilloMenu buscarPlatilloPorNombre(String nombre) {
         for (ModeloPlatilloMenu platillo : platillos) {
            if (platillo.getDescripcion().equalsIgnoreCase(nombre)) {
                return platillo;
            }
        }
        return null;
    }
    
    public int buscarTiempoPorNombre(String nombre) {
        for (ModeloPlatilloMenu platillo : platillos) {
            if (platillo != null && nombre.equals(platillo.getDescripcion())) {
                return platillo.getTiempoDePreparacion();
            }
        }
        return 15; // Indicativo de que no se encontró el platillo
    }
}
