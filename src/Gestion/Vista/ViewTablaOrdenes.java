package Gestion.Vista;

import Gestion.Controlador.ControladorOrdenes;
import Gestion.Controlador.ControladorPlatillos;
import Gestion.Controlador.GestorMesas;
import Gestion.Controlador.GestorOrdenes;
import Gestion.Modelo.ModeloOrden;
import Gestion.Modelo.ModeloPedido;
import Gestion.Modelo.OrdenTableModel;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewTablaOrdenes extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane_opiciones;
    private OrdenTableModel ordenTableModel;
    private int OrderId;
    private int MesaID = -1;
    
    public ViewTablaOrdenes() {
        initComponents();
        inicializarTabla();
        btnCuentaTable.setEnabled(false);
        btnVerPedidos.setEnabled(false);
    }

    public void setJDesktopPane(JDesktopPane jDesktopPane_opiciones) {
        this.jDesktopPane_opiciones = jDesktopPane_opiciones;
    }
    
    private void inicializarTabla() {
    ModeloOrden[] ordenes = GestorOrdenes.obtenerTodasLasOrdenesActuales();
    ordenTableModel = new OrdenTableModel(ordenes);
    jTable1.setModel(ordenTableModel);

    // Agregar listener de selección de fila a la tabla
    jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Para evitar eventos duplicados
                    int filaSeleccionada = jTable1.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        int idOrden = (int) jTable1.getValueAt(filaSeleccionada, 0); // Suponiendo que la columna 0 contiene el número de orden
                        jLabelOrden.setText("Orden: " + idOrden);
                        OrderId = idOrden;
                        int idMesa = (int) jTable1.getValueAt(filaSeleccionada, 1);
                        MesaID = idMesa;
                        btnCuentaTable.setEnabled(true);
                        btnVerPedidos.setEnabled(true);
                    }
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCuentaTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnVerPedidos = new javax.swing.JButton();
        jLabelOrden = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 480));

        btnCuentaTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/eliminar-producto.png"))); // NOI18N
        btnCuentaTable.setText("CUENTA");
        btnCuentaTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaTableActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Ordenes");

        btnVerPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/ver.png"))); // NOI18N
        btnVerPedidos.setText("VER PEDIDOS");
        btnVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosActionPerformed(evt);
            }
        });

        jLabelOrden.setText("Seleccione una Orden");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCuentaTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelOrden))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(259, 259, 259))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabelOrden)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerPedidos)
                        .addGap(18, 18, 18)
                        .addComponent(btnCuentaTable)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCuentaTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaTableActionPerformed
        if (MesaID != -1) {
            double total = 0.0;
            int ordenID = GestorMesas.obtenerOrdenPorMesa(MesaID);
            java.util.List<ModeloPedido> lst = ControladorOrdenes.obtenerPedidosDeOrden(ordenID);
            for (ModeloPedido pedido : lst) {
                String platillo = pedido.getNombrePlatillo();
                ControladorPlatillos viewController = new ControladorPlatillos();
                
                double precioPlatillo = viewController.obtenerPrecioPorNombre(platillo);
                total += precioPlatillo;
            }
            
            GestorMesas.liberarMesa(MesaID);
            
            String mensaje = String.format(
                "Cuenta mandada e impresora.\nEl total de la mesa %d con orden %d es de un total %.2f",
                MesaID, ordenID, total
            );

            // Mostrar el diálogo
            JOptionPane.showMessageDialog(
                null, 
                mensaje, 
                "Cuenta de la Mesa", 
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_btnCuentaTableActionPerformed

    private void btnVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosActionPerformed
        ViewTablePedidos viewTablePedidos = new ViewTablePedidos(OrderId);
        jDesktopPane_opiciones.add(viewTablePedidos);
        viewTablePedidos.setSize(800, 500); 
        Dimension desktopSize = jDesktopPane_opiciones.getSize();
        Dimension internalFrameSize = viewTablePedidos.getSize();
        int x = (desktopSize.width - internalFrameSize.width) / 2;
        int y = (desktopSize.height - internalFrameSize.height) / 2;
        viewTablePedidos.setLocation(x, y); 
        viewTablePedidos.setVisible(true);
        
        viewTablePedidos.setJDesktopPane(jDesktopPane_opiciones);
    }//GEN-LAST:event_btnVerPedidosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuentaTable;
    private javax.swing.JButton btnVerPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelOrden;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
