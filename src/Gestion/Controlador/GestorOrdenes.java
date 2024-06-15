package Gestion.Controlador;

import Gestion.Modelo.ModeloOrden;

public class GestorOrdenes {
    private static final int TAMANO_MAXIMO = 1000;
    private static ModeloOrden[] ordenes = new ModeloOrden[TAMANO_MAXIMO];
    private static int cantidad = 0;

    static {
        // Inicializar el array de mesas con valores predeterminados
        for (int i = 0; i < TAMANO_MAXIMO; i++) {
            ordenes[i] = new ModeloOrden(i + 1, "Sin Orden"); 
        }
    }
    
    
    // Método para agregar una orden
    public static void agregarOrden(ModeloOrden orden) {
        if (cantidad < TAMANO_MAXIMO) {
            ordenes[cantidad] = orden;
            cantidad++;
        } else {
            System.out.println("El arreglo de órdenes está lleno. No se puede agregar más órdenes.");
        }
    }

    public static ModeloOrden[] obtenerTodasLasOrdenes() {
        return ordenes;
    }
    
    // Método para obtener una orden por su índice
    public static ModeloOrden obtenerOrden(int index) {
        if (index >= 0 && index < cantidad) {
            return ordenes[index];
        } else {
            return null;
        }
    }

    // Método para buscar una orden por su número de orden
    public static ModeloOrden buscarOrdenPorNumero(int numeroOrden) {
        for (int i = 0; i < cantidad; i++) {
            if (ordenes[i].getNumeroOrden() == numeroOrden) {
                return ordenes[i];
            }
        }
        return null;
    }

    // Método para cancelar una orden por su número de orden
    public static boolean cancelarOrden(int numeroOrden) {
        ModeloOrden orden = buscarOrdenPorNumero(numeroOrden);
        if (orden != null) {
            orden.setCancelado(true);
            return true;
        }
        return false;
    }

    // Método para marcar una orden como terminada por su número de orden
    public static boolean terminarOrden(int numeroOrden) {
        ModeloOrden orden = buscarOrdenPorNumero(numeroOrden);
        if (orden != null) {
            orden.setTerminado(true);
            return true;
        }
        return false;
    }
}