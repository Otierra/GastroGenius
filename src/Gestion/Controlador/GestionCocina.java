
package Gestion.Controlador;

import Gestion.Modelo.ModeloCocina;
import java.util.ArrayList;
import java.util.List;

public class GestionCocina {

    // Listas estáticas
    private static List<ModeloCocina> pedidosSinPrepararComida = new ArrayList<>();
    private static List<ModeloCocina> pedidosSinPrepararBebida = new ArrayList<>();
    private static List<ModeloCocina> pedidosEnPreparacionComida = new ArrayList<>();
    private static List<ModeloCocina> pedidosEnPreparacionBebida = new ArrayList<>();

    // Métodos para agregar a las listas
    public static void agregarPedidoComidaSinPreparar(ModeloCocina pedido) {
        pedidosSinPrepararComida.add(pedido);
    }

    public static void agregarPedidoComidaEnPreparacion(ModeloCocina pedido) {
        pedidosEnPreparacionComida.add(pedido);
    }

    // Métodos para agregar a las listas
    public static void agregarPedidoBebidaSinPreparar(ModeloCocina pedido) {
        pedidosSinPrepararBebida.add(pedido);
    }

    public static void agregarPedidoBebidaEnPreparacion(ModeloCocina pedido) {
        pedidosEnPreparacionBebida.add(pedido);
    }
    
    // Métodos para eliminar de las listas
    public static void eliminarPedidoSinPrepararComida(int ordenID, int platilloID) {
        pedidosSinPrepararComida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
    }

    public static void eliminarPedidoEnPreparacionComida(int ordenID, int platilloID) {
        pedidosEnPreparacionComida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
    }
    
    public static void eliminarPedidoSinPrepararBebida(int ordenID, int platilloID) {
        pedidosSinPrepararBebida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
    }

    public static void eliminarPedidoEnPreparacionBebida(int ordenID, int platilloID) {
        pedidosEnPreparacionBebida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
    }

    // Métodos para obtener las listas
    public static List<ModeloCocina> getPedidosSinPrepararComida() {
        return pedidosSinPrepararComida;
    }

    public static List<ModeloCocina> getPedidosEnPreparacionComida() {
        return pedidosEnPreparacionComida;
    }

    // Métodos para obtener las listas
    public static List<ModeloCocina> getPedidosSinPrepararBebida() {
        return pedidosSinPrepararBebida;
    }

    public static List<ModeloCocina> getPedidosEnPreparacionBebida() {
        return pedidosEnPreparacionBebida;
    }
    
}
