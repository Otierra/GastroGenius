
package Gestion.Controlador;

import Gestion.Modelo.ModeloCocina;
import java.util.ArrayList;
import java.util.List;

public class GestionCocina {

    // Listas estáticas
    private static List<ModeloCocina> pedidosSinPreparar = new ArrayList<>();
    private static List<ModeloCocina> pedidosEnPreparacion = new ArrayList<>();

    // Métodos para agregar a las listas
    public static void agregarPedidoSinPreparar(ModeloCocina pedido) {
        pedidosSinPreparar.add(pedido);
    }

    public static void agregarPedidoEnPreparacion(ModeloCocina pedido) {
        pedidosEnPreparacion.add(pedido);
    }

    // Métodos para eliminar de las listas
    public static void eliminarPedidoSinPreparar(int ordenID, int platilloID) {
        pedidosSinPreparar.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
    }

    public static void eliminarPedidoEnPreparacion(int ordenID, int platilloID) {
        pedidosEnPreparacion.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
    }

    // Métodos para obtener las listas
    public static List<ModeloCocina> getPedidosSinPreparar() {
        return pedidosSinPreparar;
    }

    public static List<ModeloCocina> getPedidosEnPreparacion() {
        return pedidosEnPreparacion;
    }

}
