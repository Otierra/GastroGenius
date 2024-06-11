
package Gestion;


public class AgregarPedido extends javax.swing.JInternalFrame {

    
    public AgregarPedido() {
        initComponents();
        this.setSize(565,410);
        this.setTitle("Agregar Pedido");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_IDPedido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jbcProducto = new javax.swing.JComboBox<>();
        jsbCantidad = new javax.swing.JScrollBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_Alteraciones = new javax.swing.JTextArea();
        btn_eliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_eliminar1 = new javax.swing.JButton();
        btn_eliminar2 = new javax.swing.JButton();
        jbcProducto1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jbcProducto2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jsbCantidad1 = new javax.swing.JScrollBar();

        setBackground(new java.awt.Color(0, 102, 68));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AGREGAR PEDIDO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 170, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BEBIDAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MESA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 40, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        txt_IDPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_IDPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 170, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 740, 130));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alteraciones");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jbcProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jbcProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 170, -1));

        jsbCantidad.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        getContentPane().add(jsbCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 220, 20));

        jta_Alteraciones.setColumns(20);
        jta_Alteraciones.setRows(5);
        jScrollPane2.setViewportView(jta_Alteraciones);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 400, -1));

        btn_eliminar.setBackground(new java.awt.Color(0, 85, 5));
        btn_eliminar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btn_eliminar.setText("CANCELAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 150, -1));

        jButton3.setBackground(new java.awt.Color(0, 85, 5));
        jButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton3.setText("AGREGAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 150, -1));

        btn_eliminar1.setBackground(new java.awt.Color(0, 85, 5));
        btn_eliminar1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btn_eliminar1.setText("ELIMINAR");
        btn_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 150, -1));

        btn_eliminar2.setBackground(new java.awt.Color(0, 85, 5));
        btn_eliminar2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btn_eliminar2.setText("ALTERACIONES");
        btn_eliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 150, -1));

        jbcProducto1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jbcProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 170, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("COMIDA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jbcProducto2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jbcProducto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 170, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        jsbCantidad1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        getContentPane().add(jsbCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 220, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IDPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDPedidoActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminar1ActionPerformed

    private void btn_eliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_eliminar1;
    private javax.swing.JButton btn_eliminar2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jbcProducto;
    private javax.swing.JComboBox<String> jbcProducto1;
    private javax.swing.JComboBox<String> jbcProducto2;
    private javax.swing.JScrollBar jsbCantidad;
    private javax.swing.JScrollBar jsbCantidad1;
    private javax.swing.JTextArea jta_Alteraciones;
    private javax.swing.JTextField txt_IDPedido;
    // End of variables declaration//GEN-END:variables
}
