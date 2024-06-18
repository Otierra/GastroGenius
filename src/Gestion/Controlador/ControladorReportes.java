package Gestion.Controlador;

import Gestion.Modelo.ModeloOrden;
import Gestion.Modelo.ModeloPedido;
import Gestion.Modelo.ModeloReporte;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class ControladorReportes {
     
    // Método para crear la lista de reportes
    public static void crearListaReportes() {
        ModeloOrden[] ordenes = GestorOrdenes.obtenerTodasLasOrdenes();

        for (ModeloOrden orden : ordenes) {
            if (orden != null && orden.getMesaId() != -1) {
                
                List<ModeloPedido> pedidos = orden.getPedidos();
                int ordenID = orden.getNumeroOrden();
                
                double total = 0.0;
                java.util.List<ModeloPedido> lst = ControladorOrdenes.obtenerPedidosDeOrden(ordenID);
                for (ModeloPedido pedido : lst) {
                    String platillo = pedido.getNombrePlatillo();
                    ControladorPlatillos viewController = new ControladorPlatillos();
                     
                    double precioPlatillo = viewController.obtenerPrecioPorNombre(platillo);
                    total += precioPlatillo;
                }
               
                String fecha = generarFechaAleatoria();

                // Crear un objeto ModeloReporte
                ModeloReporte reporte = new ModeloReporte(fecha, ordenID, pedidos, total);

                // Agregar el reporte a la lista en GestionReporte
                GestionReporte.agregarReporte(reporte);
            }
        }
    }
    
    // Método para generar una fecha aleatoria entre el 01/mayo/2024 y 30/junio/2024
    public static String generarFechaAleatoria() {
        // Definir las fechas límite
        Calendar inicio = new GregorianCalendar(2024, Calendar.MAY, 1);
        Calendar fin = new GregorianCalendar(2024, Calendar.JUNE, 30);

        // Obtener el rango de tiempo en milisegundos
        long inicioMillis = inicio.getTimeInMillis();
        long finMillis = fin.getTimeInMillis();
        long rango = finMillis - inicioMillis;

        // Crear una instancia de Random para generar la fecha aleatoria
        Random random = new Random();
        long tiempoAleatorio = inicioMillis + (long) (random.nextDouble() * rango);

        // Crear un objeto Date con la fecha aleatoria
        Date fechaAleatoria = new Date(tiempoAleatorio);

        // Formatear la fecha como string en el formato deseado (dd/MMM/yyyy)
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMM/yyyy");
        return formatoFecha.format(fechaAleatoria);
    }
    
}
