package Gestion.Vista;

import Gestion.Controlador.ControladorCocina;
import Gestion.Controlador.ControladorOrdenes;
import Gestion.Controlador.GestionCocina;
import Gestion.Modelo.ModeloCocina;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ViewTableCocina extends javax.swing.JInternalFrame {

    private int OrderID;
    private int PlatilloID;
    
    public ViewTableCocina() {
        initComponents();
        if(jRadioButtonCocinaComida.isSelected()){
            llenarTablaPedidosSinPreparar(true);
            llenarTablaPedidosEnPreparacion(true);
        }else{
            llenarTablaPedidosSinPreparar(false);
            llenarTablaPedidosEnPreparacion(false);
        }
        
        agregarListenersTablas();
        jButtonPedidoListo.setEnabled(false);
        jButtonPedidoPreparacion.setEnabled(false);
    }

    // Método para llenar la tabla de pedidos sin preparar
    private void llenarTablaPedidosSinPreparar(boolean tipo) {
        List<ModeloCocina> pedidosSinPreparar;
        
        if(tipo){
            pedidosSinPreparar = GestionCocina.getPedidosSinPrepararComida();
        }else{
            pedidosSinPreparar = GestionCocina.getPedidosSinPrepararBebida();
        }
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Orden ID");
        model.addColumn("Platillo ID");
        model.addColumn("Platillo");
        model.addColumn("Prioridad");
        model.addColumn("Comentarios");

        for (ModeloCocina pedido : pedidosSinPreparar) {
            model.addRow(new Object[]{
                pedido.getOrdenID(),
                pedido.getPlatilloID(),
                pedido.getPlatillo(),
                pedido.getPrioridad(),
                pedido.getComentarios()
            });
        }

        jTableSin.setModel(model);
    }

    // Método para llenar la tabla de pedidos en preparación
    private void llenarTablaPedidosEnPreparacion(boolean tipo) {
        
        List<ModeloCocina> pedidosEnPreparacion;
        
        if(tipo){
            pedidosEnPreparacion = GestionCocina.getPedidosEnPreparacionComida();
        }else{
            pedidosEnPreparacion = GestionCocina.getPedidosEnPreparacionBebida();
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Orden ID");
        model.addColumn("Platillo ID");
        model.addColumn("Platillo");
        model.addColumn("Prioridad");
        model.addColumn("Comentarios");

        for (ModeloCocina pedido : pedidosEnPreparacion) {
            model.addRow(new Object[]{
                pedido.getOrdenID(),
                pedido.getPlatilloID(),
                pedido.getPlatillo(),
                pedido.getPrioridad(),
                pedido.getComentarios()
            });
        }

        jTableTerminado.setModel(model);
    }
    
    private void agregarListenersTablas() {
        jTableSin.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && jTableSin.getSelectedRow() != -1) {
                    int selectedRow = jTableSin.getSelectedRow();
                    int ordenID = (int) jTableSin.getValueAt(selectedRow, 0);
                    OrderID = ordenID;
                    int platilloID = (int) jTableSin.getValueAt(selectedRow, 1);
                    jTextCocinaOrden.setText(String.valueOf(ordenID));
                    PlatilloID = platilloID;
                    jTextCocinaIDPedido.setText(String.valueOf(ordenID));
                    
                    String platillo = jTableSin.getValueAt(selectedRow, 2).toString();
                    jTextCocinaPlatillo.setText(platillo);  
                    
                    String comentarios = jTableSin.getValueAt(selectedRow, 4).toString();
                    jTextAreaNotas.setText(comentarios);  
                    
                    jButtonPedidoListo.setEnabled(true);
                    jButtonPedidoPreparacion.setEnabled(true);
                }
            }
        });

        jTableTerminado.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && jTableTerminado.getSelectedRow() != -1) {
                    int selectedRow = jTableTerminado.getSelectedRow();
                    int ordenID = (int) jTableTerminado.getValueAt(selectedRow, 0);
                    OrderID = ordenID;
                    jTextCocinaOrden.setText(String.valueOf(ordenID));
                    int platilloID = (int) jTableTerminado.getValueAt(selectedRow, 1);
                    PlatilloID = platilloID;
                    jTextCocinaIDPedido.setText(String.valueOf(ordenID));
                   
                    String platillo = jTableTerminado.getValueAt(selectedRow, 2).toString();
                    jTextCocinaPlatillo.setText(platillo);  
                    
                    String comentarios = jTableTerminado.getValueAt(selectedRow, 4).toString();
                    jTextAreaNotas.setText(comentarios); 
                    
                    jButtonPedidoListo.setEnabled(true);
                    jButtonPedidoPreparacion.setEnabled(true);
                }
            }
        });
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextCocinaOrden = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextCocinaIDPedido = new javax.swing.JTextField();
        jTextCocinaPlatillo = new javax.swing.JTextField();
        jButtonPedidoPreparacion = new javax.swing.JButton();
        jButtonPedidoListo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonCocinaComida = new javax.swing.JRadioButton();
        jRadioButtonCocinaBebida = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTerminado = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaNotas = new javax.swing.JTextArea();
        btnActualizarCocina = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTableSin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableSin);

        jLabel1.setText("Orden :");

        jLabel2.setText("Pedido :");

        jButtonPedidoPreparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/cocinar.png"))); // NOI18N
        jButtonPedidoPreparacion.setText("Preparando");
        jButtonPedidoPreparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedidoPreparacionActionPerformed(evt);
            }
        });

        jButtonPedidoListo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/camarero.png"))); // NOI18N
        jButtonPedidoListo.setText("Pedido Listo");
        jButtonPedidoListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPedidoListoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de Platillo :");

        buttonGroup1.add(jRadioButtonCocinaComida);
        jRadioButtonCocinaComida.setSelected(true);
        jRadioButtonCocinaComida.setText("¿Es comida?");
        jRadioButtonCocinaComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCocinaComidaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonCocinaBebida);
        jRadioButtonCocinaBebida.setText("¿Es bebida?");
        jRadioButtonCocinaBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCocinaBebidaActionPerformed(evt);
            }
        });

        jTableTerminado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableTerminado);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pedidos sin Preparar");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Pedidos en Preparación");

        jLabel6.setText("Notas del Pedido:");

        jTextAreaNotas.setColumns(20);
        jTextAreaNotas.setRows(5);
        jScrollPane3.setViewportView(jTextAreaNotas);

        btnActualizarCocina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/actualizar (2).png"))); // NOI18N
        btnActualizarCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCocinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPedidoPreparacion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPedidoListo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextCocinaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextCocinaIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnActualizarCocina)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextCocinaPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonCocinaComida))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonCocinaBebida)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCocinaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCocinaIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCocinaPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButtonCocinaComida)
                    .addComponent(jRadioButtonCocinaBebida))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarCocina)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPedidoListo)
                    .addComponent(jButtonPedidoPreparacion))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPedidoPreparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoPreparacionActionPerformed
        ControladorCocina.cambiarPedidoSinPreparar(OrderID,PlatilloID);
        
        if(jRadioButtonCocinaComida.isSelected()){
            llenarTablaPedidosSinPreparar(true);
            llenarTablaPedidosEnPreparacion(true);
        }else{
            llenarTablaPedidosSinPreparar(false);
            llenarTablaPedidosEnPreparacion(false);
        }
        
        ControladorOrdenes.buscarYModificarEstadoPedido(OrderID,PlatilloID,"Preparandose");
    }//GEN-LAST:event_jButtonPedidoPreparacionActionPerformed

    private void jButtonPedidoListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoListoActionPerformed
        
        if(!ControladorCocina.quedanPedidosSinPreparar(OrderID)){
            ControladorOrdenes.buscarYModificarEstadoPedido(OrderID,PlatilloID,"Listo");
        }
        
        ControladorCocina.eliminarPedido(OrderID,PlatilloID);
        
        if(jRadioButtonCocinaComida.isSelected()){
            llenarTablaPedidosSinPreparar(true);
            llenarTablaPedidosEnPreparacion(true);
        }else{
            llenarTablaPedidosSinPreparar(false);
            llenarTablaPedidosEnPreparacion(false);
        }
    }//GEN-LAST:event_jButtonPedidoListoActionPerformed

    private void jRadioButtonCocinaComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCocinaComidaActionPerformed
        if (jRadioButtonCocinaComida.isSelected()) {
            llenarTablaPedidosSinPreparar(true);
            llenarTablaPedidosEnPreparacion(true);
            jTextCocinaOrden.setText(String.valueOf(""));
            jTextCocinaIDPedido.setText(String.valueOf(""));         
            jTextCocinaPlatillo.setText("");      
            jTextAreaNotas.setText(""); 
        }
    }//GEN-LAST:event_jRadioButtonCocinaComidaActionPerformed

    private void jRadioButtonCocinaBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCocinaBebidaActionPerformed
        if (jRadioButtonCocinaBebida.isSelected()) {
            llenarTablaPedidosSinPreparar(false);
            llenarTablaPedidosEnPreparacion(false);
            jTextCocinaOrden.setText(String.valueOf(""));
            jTextCocinaIDPedido.setText(String.valueOf(""));         
            jTextCocinaPlatillo.setText("");      
            jTextAreaNotas.setText(""); 
        }
    }//GEN-LAST:event_jRadioButtonCocinaBebidaActionPerformed

    private void btnActualizarCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCocinaActionPerformed
        if(jRadioButtonCocinaComida.isSelected()){
            llenarTablaPedidosSinPreparar(true);
            llenarTablaPedidosEnPreparacion(true);
        }else{
            llenarTablaPedidosSinPreparar(false);
            llenarTablaPedidosEnPreparacion(false);
        }
    }//GEN-LAST:event_btnActualizarCocinaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCocina;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonPedidoListo;
    private javax.swing.JButton jButtonPedidoPreparacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButtonCocinaBebida;
    private javax.swing.JRadioButton jRadioButtonCocinaComida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableSin;
    private javax.swing.JTable jTableTerminado;
    private javax.swing.JTextArea jTextAreaNotas;
    private javax.swing.JTextField jTextCocinaIDPedido;
    private javax.swing.JTextField jTextCocinaOrden;
    private javax.swing.JTextField jTextCocinaPlatillo;
    // End of variables declaration//GEN-END:variables
}
