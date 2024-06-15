package Gestion.Vista;

import Gestion.Controlador.ControladorOrdenes;
import Gestion.Modelo.ModeloPedido;
import Gestion.Modelo.PedidoTableModel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class ViewTablePedidos extends javax.swing.JInternalFrame {

    private int OrderId;
    private int PedidoId;
    private int MesaId;
    private List<ModeloPedido> pedidos;
    private JDesktopPane jDesktopPane_opiciones;
     
    public ViewTablePedidos(int OrderId) {
        this.OrderId = OrderId;
        initComponents();
        pedidos = ControladorOrdenes.obtenerPedidosDeOrden(OrderId);
        inicializarTabla();
        agregarEventoTabla();
    }
    
    public void setJDesktopPane(JDesktopPane jDesktopPane_opiciones) {
        this.jDesktopPane_opiciones = jDesktopPane_opiciones;
    }
    
    private void inicializarTabla() {
        PedidoTableModel pedidoTableModel = new PedidoTableModel(pedidos);
        jTablePedido.setModel(pedidoTableModel);
    }
   
    private void agregarEventoTabla() {
        jTablePedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTablePedido.getSelectedRow();
                if (selectedRow != -1) {
                    int idPlatillo = (int) jTablePedido.getValueAt(selectedRow, 0);  
                    jLabelPedido.setText("Platillo: " + idPlatillo);
                    PedidoId = idPlatillo;
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonPedidoAgregar = new javax.swing.JButton();
        jLabelPedido = new javax.swing.JLabel();
        jButtonPedidoCancelar = new javax.swing.JButton();
        jButtonPedidoSalir = new javax.swing.JButton();
        jButtonPedidoModificar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTablePedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablePedido);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Pedidos de Orden");

        jButtonPedidoAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/anadir-al-carrito (1).png"))); // NOI18N
        jButtonPedidoAgregar.setText("AGREGAR");
        jButtonPedidoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedidoAgregarActionPerformed(evt);
            }
        });

        jLabelPedido.setText("Seleccione un Pedido");

        jButtonPedidoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/eliminar-producto.png"))); // NOI18N
        jButtonPedidoCancelar.setText("CANCELAR");
        jButtonPedidoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedidoCancelarActionPerformed(evt);
            }
        });

        jButtonPedidoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/cerrar-sesion.png"))); // NOI18N
        jButtonPedidoSalir.setText("SALIR");
        jButtonPedidoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedidoSalirActionPerformed(evt);
            }
        });

        jButtonPedidoModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/venta-cruzada (1).png"))); // NOI18N
        jButtonPedidoModificar.setText("MODIFICAR");
        jButtonPedidoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedidoModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(199, 199, 199))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPedidoModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPedidoAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPedido)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonPedidoSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPedidoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabelPedido)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPedidoAgregar)
                        .addGap(23, 23, 23)
                        .addComponent(jButtonPedidoModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPedidoCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPedidoSalir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPedidoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoAgregarActionPerformed
        if (MesaId != -1) {
            // Crear una instancia de ViewPedido
            ViewPedido viewPedido = new ViewPedido(OrderId, MesaId);

            // Agregar ViewPedido al JDesktopPane
            jDesktopPane_opiciones.add(viewPedido);
            viewPedido.setVisible(true); // Hacer visible la ventana de pedido

             // Centrar ViewPedido dentro de jDesktopPane_opiciones
            Dimension desktopSize = jDesktopPane_opiciones.getSize();
            Dimension internalFrameSize = viewPedido.getSize();
            int x = (desktopSize.width - internalFrameSize.width) / 2;
            int y = (desktopSize.height - internalFrameSize.height) / 2;
            viewPedido.setLocation(x, y);
        } else {
            System.out.println("Debe seleccionar una mesa antes de agregar un pedido.");
        }
    }//GEN-LAST:event_jButtonPedidoAgregarActionPerformed

    private void jButtonPedidoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoModificarActionPerformed
        if (MesaId != -1) {
            // Crear una instancia de ViewPedido
            ViewPedido viewPedido = new ViewPedido(OrderId, MesaId,PedidoId);

            // Agregar ViewPedido al JDesktopPane
            jDesktopPane_opiciones.add(viewPedido);
            viewPedido.setVisible(true); // Hacer visible la ventana de pedido

             // Centrar ViewPedido dentro de jDesktopPane_opiciones
            Dimension desktopSize = jDesktopPane_opiciones.getSize();
            Dimension internalFrameSize = viewPedido.getSize();
            int x = (desktopSize.width - internalFrameSize.width) / 2;
            int y = (desktopSize.height - internalFrameSize.height) / 2;
            viewPedido.setLocation(x, y);
        } else {
            System.out.println("Debe seleccionar una mesa antes de agregar un pedido.");
        }
    }//GEN-LAST:event_jButtonPedidoModificarActionPerformed

    private void jButtonPedidoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoCancelarActionPerformed
         int response = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar el pedido?", "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);
    
        if (response == JOptionPane.YES_OPTION) {
            ControladorOrdenes.cancelarPedidoEnOrden(OrderId, PedidoId);
        } else {
            JOptionPane.showMessageDialog(null, "El pedido no ha sido cancelado.");
        }
    }//GEN-LAST:event_jButtonPedidoCancelarActionPerformed

    private void jButtonPedidoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonPedidoSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPedidoAgregar;
    private javax.swing.JButton jButtonPedidoCancelar;
    private javax.swing.JButton jButtonPedidoModificar;
    private javax.swing.JButton jButtonPedidoSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePedido;
    // End of variables declaration//GEN-END:variables
}
