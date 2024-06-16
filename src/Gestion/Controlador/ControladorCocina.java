package Gestion.Controlador;

import Gestion.Modelo.ModeloCocina;
import java.util.ArrayList;
import java.util.List;

public class ControladorCocina {
    private static List<ModeloCocina> pedidosEnPreparacion = GestionCocina.getPedidosEnPreparacion();
    
    public static void agregarPedidoSinPreparar(int ordenID, int platilloID, String platillo, int tiempo) {
        List<ModeloCocina> pedidosSinPreparar = GestionCocina.getPedidosSinPreparar();
        
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

        ModeloCocina nuevoPedido = new ModeloCocina(ordenID, platilloID, platillo, prioridad, status, inicioPreparacion);
        pedidosSinPreparar.add(nuevoPedido);
    }
    
}
