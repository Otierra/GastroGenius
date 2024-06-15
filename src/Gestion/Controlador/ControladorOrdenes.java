package Gestion.Controlador;

import Gestion.Modelo.ModeloOrden;

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
}
