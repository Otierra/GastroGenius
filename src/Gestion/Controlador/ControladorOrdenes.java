package Gestion.Controlador;

import Gestion.Modelo.ModeloOrden;
import Gestion.Modelo.ModeloPedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorOrdenes {

    public static void asignarMesaAOrden(int idMesa) {
        ModeloOrden[] ordenes = GestorOrdenes.obtenerTodasLasOrdenes();
        for (ModeloOrden orden : ordenes) {
            if (orden.getMesaId() == -1) {
                orden.setMesaId(idMesa);
                orden.setEstado("Sin Preparar");
                break; // Terminamos el ciclo una vez encontramos y actualizamos la primera orden con idMesa == -1
            }
        }
    }
    
    public static void cambiarEstadoMesa(int idMesa) {
        ModeloOrden[] ordenes = GestorOrdenes.obtenerTodasLasOrdenes();
        for (ModeloOrden orden : ordenes) {
            if (orden.getMesaId() == -1) {
                orden.setEstado("Sin Preparar");
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
    
    public static int obtenerUltimoIDPedidoDeOrden(int numeroOrden) {
        ModeloOrden orden = GestorOrdenes.obtenerOrdenPorNumero(numeroOrden);
        if (orden != null) {
            List<ModeloPedido> pedidos = orden.getPedidos();
            int ultimoIDPedido = -1;
            for (ModeloPedido pedido : pedidos) {
                if (pedido.getIdPlatillo() > ultimoIDPedido) {
                    ultimoIDPedido = pedido.getIdPlatillo();
                }
            }
            return ultimoIDPedido;
        } else {
            // Manejar el caso cuando no se encuentra la orden
            return -1; // O podrías devolver algún valor que indique error o lanzar una excepción según tu diseño
        }
    }
    
    public static ModeloPedido obtenerPedidoPorIdPlatillo(List<ModeloPedido> listaPedidos, int idPlatillo) {
        for (ModeloPedido pedido : listaPedidos) {
            if (pedido.getIdPlatillo() == idPlatillo) {
                return pedido;
            }
        }
        return null; // Si no se encuentra el pedido con el idPlatillo especificado
    }
    
    public static List<ModeloPedido> agregarPedidoALista(List<ModeloPedido> listaPedidos, String nombrePlatillo, String alteraciones) {
        // Obtener el último ID de platillo en la lista actual
        int ultimoIdPlatillo = GestorOrdenes.obtenerUltimoIdPlatillo(listaPedidos);

        // Crear el nuevo modelo de pedido con los datos proporcionados
        ModeloPedido nuevoPedido = new ModeloPedido(ultimoIdPlatillo, nombrePlatillo, alteraciones, false);

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
    
    public static void modificarPedidoEnOrden(int orderID, int pedidoID, String nombrePlatillo, String alteraciones) {
    // Obtener la orden por su número de orden
    ModeloOrden orden = GestorOrdenes.obtenerOrdenPorNumero(orderID);
    
    if (orden != null) {
        // Obtener la lista de pedidos de la orden
        List<ModeloPedido> pedidos = orden.getPedidos();
        
        // Buscar y modificar el pedido que concuerde con el pedidoID
        for (int i = 0; i < pedidos.size(); i++) {
            ModeloPedido pedido = pedidos.get(i);
            if (pedido.getIdPlatillo() == pedidoID) {
                // Crear un nuevo pedido con los datos actualizados
                ModeloPedido pedidoModificado = new ModeloPedido(pedidoID, nombrePlatillo, alteraciones, pedido.isCancelado());
                
                // Sustituir el pedido en la lista
                pedidos.set(i, pedidoModificado);
                System.out.println("Pedido actualizado en la lista de pedidos.");
                
                // Actualizar la lista de pedidos en la orden
                orden.setPedidos(pedidos);
                
                // Confirmar que la orden ha sido actualizada
                System.out.println("Lista de pedidos actualizada para la orden con idOrden " + orderID);
                return;
            }
        }
        System.out.println("No se encontró el pedido con idPlatillo " + pedidoID + " en la orden con idOrden " + orderID);
    } else {
        System.out.println("No se encontró la orden con número " + orderID);
    }
}
    
    public static void cancelarPedidoEnOrden(int idOrden, int idPlatillo) {
        ModeloOrden orden = GestorOrdenes.obtenerOrdenPorNumero(idOrden);
        
        if (orden != null) {
            List<ModeloPedido> pedidos = orden.getPedidos();
            for (ModeloPedido pedido : pedidos) {
                if (pedido.getIdPlatillo() == idPlatillo) {
                    pedido.setCancelado(true);
                    JOptionPane.showMessageDialog(null, "Pedido cancelado.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la orden con número " + idOrden);
        }
    }
    
    public static void buscarYModificarEstadoPedido(int ordenID, int pedidoID, String nuevoEstado) {
        // Obtener la orden por su número de orden
        ModeloOrden orden = GestorOrdenes.obtenerOrdenPorNumero(ordenID);

        if (orden != null) {
            // Obtener la lista de pedidos de la orden
            List<ModeloPedido> pedidos = orden.getPedidos();

            // Buscar el pedido que concuerde con el pedidoID
            for (ModeloPedido pedido : pedidos) {
                if (pedido.getIdPlatillo() == pedidoID) {
                    // Modificar el estado de la orden
                    orden.setEstado(nuevoEstado);
                    System.out.println("Estado de la orden actualizado a " + nuevoEstado);
                    return;
                }
            }
            System.out.println("No se encontró el pedido con idPlatillo " + pedidoID + " en la orden con idOrden " + ordenID);
        } else {
            System.out.println("No se encontró la orden con número " + ordenID);
        }
    }
    
}
