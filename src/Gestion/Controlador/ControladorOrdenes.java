package Gestion.Controlador;

import Gestion.Modelo.ModeloOrden;
import Gestion.Modelo.ModeloPedido;
import java.util.ArrayList;
import java.util.List;

public class ControladorOrdenes {

    public static void asignarMesaAOrden(int idMesa) {
        ModeloOrden[] ordenes = GestorOrdenes.obtenerTodasLasOrdenes();
        for (ModeloOrden orden : ordenes) {
            if (orden.getMesaId() == -1) {
                orden.setMesaId(idMesa);
                orden.setEstado("Tomando Orden");
                break; // Terminamos el ciclo una vez encontramos y actualizamos la primera orden con idMesa == -1
            }
        }
    }
    
    public static int obtenerIdOrdenEnTomandoOrden(int idMesa) {
        ModeloOrden[] ordenes = GestorOrdenes.obtenerTodasLasOrdenes();
        for (ModeloOrden orden : ordenes) {
            if (orden.getEstado().equals("Tomando Orden") && orden.getMesaId() == idMesa) {
                return orden.getNumeroOrden();
            }
        }
        return -1; // Si no se encuentra ninguna orden en estado "Tomando Orden" para la mesa especificada
    }
    
    public static List<ModeloPedido> obtenerPedidosDeOrden(int numeroOrden) {
        ModeloOrden orden = GestorOrdenes.obtenerOrdenPorNumero(numeroOrden);
        if (orden != null) {
            return orden.getPedidos();
        } else {
            // Manejar el caso cuando no se encuentra la orden
            return new ArrayList<>(); // O podrías devolver null o lanzar una excepción según tu diseño
        }
    }
    
    public static List<ModeloPedido> agregarPedidoALista(List<ModeloPedido> listaPedidos, String nombrePlatillo, String alteraciones) {
        // Obtener el último ID de platillo en la lista actual
        int ultimoIdPlatillo = GestorOrdenes.obtenerUltimoIdPlatillo(listaPedidos);

        // Crear el nuevo modelo de pedido con los datos proporcionados
        ModeloPedido nuevoPedido = new ModeloPedido(ultimoIdPlatillo + 1, nombrePlatillo, alteraciones, false);

        // Agregar el nuevo pedido a la lista
        listaPedidos.add(nuevoPedido);

        System.out.println("Pedido agregado a la lista de pedidos.");

        // Retornar la lista actualizada
        return listaPedidos;
    }
    
    public static void actualizarPedidosEnOrden(int idMesa, int idOrden, List<ModeloPedido> listaPedidos) {
        ModeloOrden orden = GestorOrdenes.obtenerOrdenPorIdMesaYIdOrden(idMesa, idOrden);
        
        if (orden != null) {
            orden.setPedidos(listaPedidos); // Actualizar la lista de pedidos en la orden encontrada
            System.out.println("Lista de pedidos actualizada para la orden con idMesa " + idMesa + " e idOrden " + idOrden);
        } else {
            System.out.println("No se encontró la orden con idMesa " + idMesa + " e idOrden " + idOrden);
        }
    }
    
}
