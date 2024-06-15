
package Gestion.Controlador;

import Gestion.Modelo.ModeloPlatilloMenu;
import java.util.Arrays;

public class GestorPlatillos {
    private static final int TAMANO_MAXIMO = 100; // Tamaño máximo del array
    private static ModeloPlatilloMenu[] platillos = new ModeloPlatilloMenu[TAMANO_MAXIMO];
    private int cantidad;

    public GestorPlatillos() {
      
    }   

    // Método para obtener el array de platillos no vacíos
    public ModeloPlatilloMenu[] obtenerPlatillos() {
        return platillos;
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

    // Método para eliminar un platillo por su id
    public void eliminarPlatillo(int id) {
        for (int i = 0; i < cantidad; i++) {
            if (platillos[i].getId() == id) {
                platillos[i] = platillos[--cantidad]; // Mover el último elemento al lugar del elemento a eliminar
                platillos[cantidad] = null; // Limpiar el último elemento
                return;
            }
        }
        System.out.println("Platillo con ID " + id + " no encontrado.");
    }

    // Método para listar todos los platillos
    public void listarPlatillos() {
        if (cantidad == 0) {
            System.out.println("No hay platillos en el arreglo.");
        } else {
            for (int i = 0; i < cantidad; i++) {
                System.out.println(platillos[i]);
            }
        }
    }

    // Método para buscar un platillo por su id
    public ModeloPlatilloMenu buscarPlatillo(int id) {
        for (int i = 0; i < cantidad; i++) {
            if (platillos[i].getId() == id) {
                return platillos[i];
            }
        }
        return null;
    }
}
