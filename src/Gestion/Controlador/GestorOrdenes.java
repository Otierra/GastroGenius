package Gestion.Controlador;

import Gestion.Modelo.ModeloOrden;
import Gestion.Modelo.ModeloPedido;
import java.util.List;

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
    public static ModeloOrden obtenerOrdenPorNumero(int numeroOrden) {
        for (ModeloOrden orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        return null; // Retornar null si no se encuentra ninguna orden con ese número
    }

     public static ModeloOrden obtenerOrdenPorIdMesaYIdOrden(int idMesa, int idOrden) {
        for (ModeloOrden orden : ordenes) {
            if (orden.getMesaId() == idMesa && orden.getNumeroOrden() == idOrden) {
                return orden;
            }
        }
        return null; // Si no se encuentra la orden
    }
    
    // Método para obtener el último idPlatillo de la lista de pedidos
    public static int obtenerUltimoIdPlatillo(List<ModeloPedido> pedidos) {
        if (pedidos.isEmpty()) {
            return 1;
        } else {
            int ultimoId = 1;
            for (ModeloPedido pedido : pedidos) {
                if (pedido.getIdPlatillo() > ultimoId) {
                    ultimoId = pedido.getIdPlatillo();
                }
            }
            return ultimoId + 1;
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