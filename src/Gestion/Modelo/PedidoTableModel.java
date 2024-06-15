package Gestion.Modelo;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PedidoTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID Platillo", "Nombre Platillo", "Alteraciones", "Cancelado"};
    private List<ModeloPedido> pedidos;

    public PedidoTableModel(List<ModeloPedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModeloPedido pedido = pedidos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pedido.getIdPlatillo();
            case 1:
                return pedido.getNombrePlatillo();
            case 2:
                return pedido.getAlteraciones();
            case 3:
                return pedido.isCancelado();
            default:
                return null;
        }
    }
}

