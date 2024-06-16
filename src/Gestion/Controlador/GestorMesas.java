package Gestion.Controlador;

import Gestion.Modelo.ModeloMesa;

public class GestorMesas {
    private static final int TAMANO_MAXIMO = 10;
    private static ModeloMesa[] mesas = new ModeloMesa[TAMANO_MAXIMO];

    static {
        // Inicializar el array de mesas con valores predeterminados
        for (int i = 0; i < TAMANO_MAXIMO; i++) {
            mesas[i] = new ModeloMesa(i + 1, -1, true); // idMesa: 1 a 10, idOrden: -1 (sin orden), disponible: true
        }
    }

    // Método para obtener el array de mesas
    public static ModeloMesa[] obtenerMesas() {
        return mesas;
    }

    // Método para actualizar el estado de una mesa
    public static void actualizarEstadoMesa(int idMesa, int idOrden, boolean disponible) {
        for (int i = 0; i < TAMANO_MAXIMO; i++) {
            if (mesas[i].getIdMesa() == idMesa) {
                mesas[i].setIdOrden(idOrden);
                mesas[i].setDisponible(disponible);
                return;
            }
        }
        System.out.println("Mesa con ID " + idMesa + " no encontrada.");
    }
    
    public static int obtenerOrdenPorMesa(int idMesa) {
        for (ModeloMesa mesa : mesas) {
            if (mesa.getIdMesa() == idMesa) {
                return mesa.getIdOrden();
            }
        }
        System.out.println("Mesa con ID " + idMesa + " no encontrada.");
        return -1; // Retorna -1 si no se encuentra la mesa
    }
}
