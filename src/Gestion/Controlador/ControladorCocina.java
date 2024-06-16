package Gestion.Controlador;

import Gestion.Modelo.ModeloCocina;
import java.util.ArrayList;
import java.util.List;

public class ControladorCocina {

    public static void agregarPedidoSinPrepararComida(int ordenID, int platilloID, String platillo, int tiempo, String comentario) {
        List<ModeloCocina> pedidosSinPrepararComida = GestionCocina.getPedidosSinPrepararComida();
        
        String status = "Sin preparar";
        boolean inicioPreparacion = false;

        String prioridad;
        if (tiempo <= 15) {
            prioridad = "Baja";
        } else if (tiempo <= 30) {
            prioridad = "Media";
        } else {
            prioridad = "Alta";
        }

        ModeloCocina nuevoPedido = new ModeloCocina(ordenID, platilloID, platillo, prioridad, status, inicioPreparacion,comentario);
        pedidosSinPrepararComida.add(nuevoPedido);
    }
    
    public static void agregarPedidoSinPrepararBebida(int ordenID, int platilloID, String platillo, int tiempo, String comentario) {
        List<ModeloCocina> pedidosSinPrepararBebida = GestionCocina.getPedidosSinPrepararBebida();
        
        String status = "Sin preparar";
        boolean inicioPreparacion = false;

        String prioridad;
        if (tiempo <= 15) {
            prioridad = "Baja";
        } else if (tiempo <= 30) {
            prioridad = "Media";
        } else {
            prioridad = "Alta";
        }

        ModeloCocina nuevoPedido = new ModeloCocina(ordenID, platilloID, platillo, prioridad, status, inicioPreparacion,comentario);
        pedidosSinPrepararBebida.add(nuevoPedido);
    }
    
     public static void cambiarPedidoSinPreparar(int ordenID, int platilloID) {
        List<ModeloCocina> pedidosSinPrepararComida = GestionCocina.getPedidosSinPrepararComida();
        List<ModeloCocina> pedidosSinPrepararBebida = GestionCocina.getPedidosSinPrepararBebida();

        List<ModeloCocina> pedidosEnPreparacionComida = GestionCocina.getPedidosEnPreparacionComida();
        List<ModeloCocina> pedidosEnPreparacionBebida = GestionCocina.getPedidosEnPreparacionBebida();

        // Mover de SinPrepararComida a EnPreparacionComida
        for (ModeloCocina pedido : new ArrayList<>(pedidosSinPrepararComida)) {
            if (pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID) {
                pedidosEnPreparacionComida.add(pedido);
                pedidosSinPrepararComida.remove(pedido);
                return;
            }
        }

        // Mover de SinPrepararBebida a EnPreparacionBebida
        for (ModeloCocina pedido : new ArrayList<>(pedidosSinPrepararBebida)) {
            if (pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID) {
                pedidosEnPreparacionBebida.add(pedido);
                pedidosSinPrepararBebida.remove(pedido);
                return;
            }
        }
        
        eliminarPedido(ordenID,platilloID);
    }

    public static void eliminarPedido(int ordenID, int platilloID) {
        List<ModeloCocina> pedidosSinPrepararComida = GestionCocina.getPedidosSinPrepararComida();
        List<ModeloCocina> pedidosSinPrepararBebida = GestionCocina.getPedidosSinPrepararBebida();

        List<ModeloCocina> pedidosEnPreparacionComida = GestionCocina.getPedidosEnPreparacionComida();
        List<ModeloCocina> pedidosEnPreparacionBebida = GestionCocina.getPedidosEnPreparacionBebida();
        
        pedidosSinPrepararComida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
        pedidosSinPrepararBebida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
        pedidosEnPreparacionComida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
        pedidosEnPreparacionBebida.removeIf(pedido -> pedido.getOrdenID() == ordenID && pedido.getPlatilloID() == platilloID);
    }
    
    public static boolean quedanPedidosSinPreparar(int ordenID) {
        List<ModeloCocina> pedidosSinPrepararComida = GestionCocina.getPedidosSinPrepararComida();
        List<ModeloCocina> pedidosSinPrepararBebida = GestionCocina.getPedidosSinPrepararBebida();

        for (ModeloCocina pedido : pedidosSinPrepararComida) {
            if (pedido.getOrdenID() == ordenID) {
                return true;
            }
        }

        for (ModeloCocina pedido : pedidosSinPrepararBebida) {
            if (pedido.getOrdenID() == ordenID) {
                return true;
            }
        }

        return false;
    }
}
