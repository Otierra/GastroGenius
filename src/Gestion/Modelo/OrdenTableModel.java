package Gestion.Modelo;

import Gestion.Modelo.ModeloOrden;
import javax.swing.table.AbstractTableModel;

public class OrdenTableModel extends AbstractTableModel {
    private ModeloOrden[] ordenes;
    private final String[] columnNames = {"Número de Orden", "Mesa ID", "Estado"};

    public OrdenTableModel(ModeloOrden[] ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public int getRowCount() {
        return ordenes.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ordenes[rowIndex].getNumeroOrden();
            case 1:
                return ordenes[rowIndex].getMesaId();
            case 2:
                return ordenes[rowIndex].getEstado();
            default:
                return null;
        }
    }
}
