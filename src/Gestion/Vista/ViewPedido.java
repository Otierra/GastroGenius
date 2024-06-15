
package Gestion.Vista;

import Gestion.Controlador.ControladorOrdenes;
import Gestion.Controlador.GestorOrdenes;
import Gestion.Controlador.GestorPlatillos;
import Gestion.Modelo.ModeloPedido;
import Gestion.Modelo.ModeloPlatilloMenu;
import java.util.List;

public class ViewPedido extends javax.swing.JInternalFrame {

    private int OrderID;
    private int MesaID;
    private int PedidoID;
    private List<ModeloPedido> pedidos;
    private String platillo;
    private boolean cancelado;
    private boolean isAgregar;
    private String cambios;
    
    public ViewPedido(int OrderID, int MesaId) {
        this.OrderID = OrderID;
        this.MesaID = MesaId;
        isAgregar = true;
        initComponents();
        jTextOrden.setText(String.valueOf(OrderID));
        jTextOrden.setEditable(false);
        
        pedidos = ControladorOrdenes.obtenerPedidosDeOrden(OrderID);
        
        ModeloPlatilloMenu[] platillosComida = GestorPlatillos.obtenerPlatillosComida();
        llenarComboBox(platillosComida);
        
    }
    
    public ViewPedido(int OrderID, int MesaId, int PedidoID) {
        this.OrderID = OrderID;
        this.MesaID = MesaId;
        this.PedidoID = PedidoID;
        isAgregar = false;
        initComponents();
        jTextOrden.setText(String.valueOf(OrderID));
        jTextOrden.setEditable(false);

        pedidos = ControladorOrdenes.obtenerPedidosDeOrden(OrderID);
        ModeloPedido pedido = ControladorOrdenes.obtenerPedidoPorIdPlatillo(pedidos, PedidoID);
        if (pedido != null) {
            jTextAreaCambios.setText(pedido.getAlteraciones());
            ModeloPlatilloMenu[] platillosComida = GestorPlatillos.obtenerPlatillosComida();
            ModeloPlatilloMenu[] platillosBebida = GestorPlatillos.obtenerPlatillosBebida();
            if (esComida(pedido.getNombrePlatillo(), platillosComida)) {
                jRadioComida.setSelected(true);
                llenarComboBoxComida();
            } else if (esBebida(pedido.getNombrePlatillo(), platillosBebida)) {
                jRadioBebida.setSelected(true);
                llenarComboBoxBebida();
            }
            jComboBoxPlatillo.setSelectedItem(pedido.getNombrePlatillo());
        }
    }

    private void llenarComboBoxComida() {
        ModeloPlatilloMenu[] platillosComida = GestorPlatillos.obtenerPlatillosComida();
        llenarComboBox(platillosComida);
    }

    private void llenarComboBoxBebida() {
        ModeloPlatilloMenu[] platillosBebida = GestorPlatillos.obtenerPlatillosBebida();
        llenarComboBox(platillosBebida);
    }

    private void llenarComboBox(ModeloPlatilloMenu[] platillos) {
        jComboBoxPlatillo.removeAllItems(); // Limpiar el JComboBox
        for (ModeloPlatilloMenu platillo : platillos) {
            jComboBoxPlatillo.addItem(platillo.getDescripcion());
        }
    }
    
    private boolean esComida(String nombrePlatillo, ModeloPlatilloMenu[] platillosComida) {
        for (ModeloPlatilloMenu platillo : platillosComida) {
            if (platillo.getDescripcion().equals(nombrePlatillo)) {
                return true;
            }
        }
        return false;
    }

    private boolean esBebida(String nombrePlatillo, ModeloPlatilloMenu[] platillosBebida) {
        for (ModeloPlatilloMenu platillo : platillosBebida) {
            if (platillo.getDescripcion().equals(nombrePlatillo)) {
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextOrden = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioComida = new javax.swing.JRadioButton();
        jRadioBebida = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxPlatillo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCambios = new javax.swing.JTextArea();
        jButtonGuardar1 = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Pedido a Orden");

        jLabel2.setText("Número de Orden :");

        jLabel3.setText("Tipo de Platillo :");

        buttonGroup1.add(jRadioComida);
        jRadioComida.setSelected(true);
        jRadioComida.setText("¿Es Comida?");
        jRadioComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioComidaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioBebida);
        jRadioBebida.setText("¿Es Bebida?");
        jRadioBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBebidaActionPerformed(evt);
            }
        });

        jLabel4.setText("Platillo :");

        jLabel5.setText("Alteraciones / Comentarios :");

        jTextAreaCambios.setColumns(20);
        jTextAreaCambios.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCambios);

        jButtonGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/cheque.png"))); // NOI18N
        jButtonGuardar1.setText("GUARDAR");
        jButtonGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardar1ActionPerformed(evt);
            }
        });

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/cerrar-sesion.png"))); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxPlatillo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextOrden, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioComida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jRadioBebida)))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonGuardar1)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioComida)
                    .addComponent(jRadioBebida))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar1)
                    .addComponent(jButtonSalir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardar1ActionPerformed
        cambios = jTextAreaCambios.getText();
        platillo = (String) jComboBoxPlatillo.getSelectedItem();
        
        if(isAgregar){
            pedidos = ControladorOrdenes.agregarPedidoALista(pedidos, platillo, cambios);
            ControladorOrdenes.actualizarPedidosEnOrden(MesaID, OrderID, pedidos);
        }
        else{
            ControladorOrdenes.modificarPedidoEnOrden(OrderID, PedidoID, platillo, cambios);
        }
    }//GEN-LAST:event_jButtonGuardar1ActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jRadioComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioComidaActionPerformed
        if (jRadioComida.isSelected()) {
            GestorPlatillos view = new GestorPlatillos();
            llenarComboBoxComida();
        }
    }//GEN-LAST:event_jRadioComidaActionPerformed

    private void jRadioBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBebidaActionPerformed
        if (jRadioBebida.isSelected()) {
            llenarComboBoxBebida();
        }
    }//GEN-LAST:event_jRadioBebidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonGuardar1;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxPlatillo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioBebida;
    private javax.swing.JRadioButton jRadioComida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCambios;
    private javax.swing.JTextField jTextOrden;
    // End of variables declaration//GEN-END:variables
}
