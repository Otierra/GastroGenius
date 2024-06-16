package Gestion.Controlador;

import Gestion.Modelo.ModeloPlatilloMenu;
import Gestion.Vista.ViewMenuCarta;
import java.util.Arrays;

public class ControladorPlatillos {
    private GestorPlatillos gestorPlatillos;
    private int siguienteId;

    public ControladorPlatillos() {
        this.gestorPlatillos = new GestorPlatillos();
        this.siguienteId = 1; // Inicializar el ID desde 1, ajustar según sea necesario
    }

    public double obtenerPrecioPorNombre(String nombrePlatillo) {
        ModeloPlatilloMenu platillo = gestorPlatillos.buscarPlatilloPorNombre(nombrePlatillo);
        if (platillo != null) {
            return platillo.getPrecio();
        } else {
            System.out.println("Platillo con nombre " + nombrePlatillo + " no encontrado.");
            return -1; // O puedes lanzar una excepción según tu diseño
        }
    }
    
    public void agregarPlatillo(String nombre, double precio, String categoria, boolean esComida, int tiempoPreparacion) {
        ModeloPlatilloMenu platillo = new ModeloPlatilloMenu(nombre, precio, categoria, esComida, tiempoPreparacion);
        platillo.setId(siguienteId);
        gestorPlatillos.agregarPlatillo(platillo);
        siguienteId++; // Incrementar el ID para el siguiente platillo
    }

    // Método para modificar un platillo
    public void modificarPlatillo(int id, String nombre, double precio, String categoria, boolean esComida, int tiempoPreparacion) {
        ModeloPlatilloMenu platillo = gestorPlatillos.buscarPlatillo(id);
        if (platillo != null) {
            platillo.setDescripcion(nombre);
            platillo.setPrecio(precio);
            platillo.setCategoria(categoria);
            platillo.setEsComida(esComida);
            platillo.setTiempoDePreparacion(tiempoPreparacion);
        } else {
            System.out.println("Platillo con ID " + id + " no encontrado.");
        }
    }

    // Método para obtener el siguiente ID disponible
    public int obtenerSiguienteId() {
        return siguienteId;
    }
    
    
    
    
}
