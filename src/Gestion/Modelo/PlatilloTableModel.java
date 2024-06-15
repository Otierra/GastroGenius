
package Gestion.Modelo;

import javax.swing.table.AbstractTableModel;

public class PlatilloTableModel extends AbstractTableModel {
    private ModeloPlatilloMenu[] platillos;
    private String[] columnNames = {"ID", "Descripción", "Precio", "Categoría", "Es Comida", "Tiempo Preparación"};

    public PlatilloTableModel(ModeloPlatilloMenu[] platillos) {
        this.platillos = platillos;
    }

    @Override
    public int getRowCount() {
        return platillos.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (platillos[rowIndex] != null) {
            switch (columnIndex) {
                case 0: return platillos[rowIndex].getId();             // ID
                case 1: return platillos[rowIndex].getDescripcion();    // Descripción
                case 2: return platillos[rowIndex].getPrecio();         // Precio
                case 3: return platillos[rowIndex].getCategoria();      // Categoría
                case 4: return platillos[rowIndex].isEsComida();        // Es Comida
                case 5: return platillos[rowIndex].getTiempoDePreparacion(); // Tiempo de Preparación
                default: return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}