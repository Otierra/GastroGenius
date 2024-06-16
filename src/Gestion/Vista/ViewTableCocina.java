package Gestion.Vista;

import Gestion.Controlador.GestionCocina;
import Gestion.Modelo.ModeloCocina;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ViewTableCocina extends javax.swing.JInternalFrame {

   
    public ViewTableCocina() {
        initComponents();
        llenarTablaPedidosSinPreparar();
        llenarTablaPedidosEnPreparacion();
    }

    // Método para llenar la tabla de pedidos sin preparar
    private void llenarTablaPedidosSinPreparar() {
        List<ModeloCocina> pedidosSinPreparar = GestionCocina.getPedidosSinPreparar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Orden ID");
        model.addColumn("Platillo ID");
        model.addColumn("Platillo");
        model.addColumn("Prioridad");

        for (ModeloCocina pedido : pedidosSinPreparar) {
            model.addRow(new Object[]{
                pedido.getOrdenID(),
                pedido.getPlatilloID(),
                pedido.getPlatillo(),
                pedido.getPrioridad(),
            });
        }

        jTableSin.setModel(model);
    }

    // Método para llenar la tabla de pedidos en preparación
    private void llenarTablaPedidosEnPreparacion() {
        List<ModeloCocina> pedidosEnPreparacion = GestionCocina.getPedidosEnPreparacion();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Orden ID");
        model.addColumn("Platillo ID");
        model.addColumn("Platillo");
        model.addColumn("Prioridad");

        for (ModeloCocina pedido : pedidosEnPreparacion) {
            model.addRow(new Object[]{
                pedido.getOrdenID(),
                pedido.getPlatilloID(),
                pedido.getPlatillo(),
                pedido.getPrioridad(),
            });
        }

        jTableTerminado.setModel(model);
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
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTerminado = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaNotas = new javax.swing.JTextArea();

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

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("¿Es comida?");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("¿Es bebida?");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPedidoPreparacion, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonPedidoListo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextCocinaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextCocinaIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextCocinaPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3)))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextCocinaOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCocinaIDPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCocinaPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPedidoPreparacion)
                    .addComponent(jButtonPedidoListo))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPedidoPreparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoPreparacionActionPerformed
        
    }//GEN-LAST:event_jButtonPedidoPreparacionActionPerformed

    private void jButtonPedidoListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPedidoListoActionPerformed
        
    }//GEN-LAST:event_jButtonPedidoListoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonPedidoListo;
    private javax.swing.JButton jButtonPedidoPreparacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
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
