package Gestion.Vista;

import Gestion.Controlador.ControladorPlatillos;
import Gestion.Controlador.GestorPlatillos;
import Gestion.Modelo.ModeloPlatilloMenu;
import Gestion.Modelo.PlatilloTableModel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Gestion.Vista.ViewMenu;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;


public class ViewTableMenu extends javax.swing.JInternalFrame {

    private int selectedPlatilloId = -1; 
    private JDesktopPane jDesktopPane_opiciones;
    
    public ViewTableMenu() {
        initComponents();
        initializeTable(); 
        btnAgregar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }
    
    public void setJDesktopPane(JDesktopPane jDesktopPane_opiciones) {
        this.jDesktopPane_opiciones = jDesktopPane_opiciones;
    }
    
    private void initializeTable() {
        GestorPlatillos controller = new GestorPlatillos();
        // Obtener los platillos del gestor  
        ModeloPlatilloMenu[] platillosArray = controller.obtenerPlatillos();

        // Crear el modelo de tabla con los platillos obtenidos
        PlatilloTableModel model = new PlatilloTableModel(platillosArray);
        jTableMenu.setModel(model);

        // Ocultar la columna de ID si no quieres mostrarla
        // jTableMenu.removeColumn(jTableMenu.getColumnModel().getColumn(0)); // Descomenta esta línea si deseas ocultar la columna de ID

        // Añadir un MouseListener para manejar los clics en la tabla
        jTableMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jTableMenu.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener el ID y el nombre del platillo de las columnas correspondientes
                    int idPlatillo = (int) jTableMenu.getValueAt(selectedRow, 0); // Ajusta el índice de columna según tu modelo
                    String nombrePlatillo = (String) jTableMenu.getValueAt(selectedRow, 1); // Ajusta el índice de columna según tu modelo
                    // Actualizar el texto del JLabel
                    jLabelPlatillo.setText("Platillo: " + nombrePlatillo);
                    // Guardar el ID del platillo en la variable
                    selectedPlatilloId = idPlatillo;
                    System.out.println(selectedPlatilloId);
                    btnEliminar.setEnabled(true);
                    btnModificar.setEnabled(true);
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMenu = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabelPlatillo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Menú");

        jTableMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableMenu);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/anadir-al-carrito (1).png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/eliminar-producto.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/venta-cruzada (1).png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabelPlatillo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlatillo.setText("PLATILLO:");
        jLabelPlatillo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(288, 288, 288))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabelPlatillo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ViewMenuCarta view = new ViewMenuCarta();
        jDesktopPane_opiciones.add(view);
        Dimension desktopSize = jDesktopPane_opiciones.getSize();
        Dimension internalFrameSize = view.getSize();
        int x = (desktopSize.width - internalFrameSize.width) / 2;
        int y = (desktopSize.height - internalFrameSize.height) / 2;
        view.setLocation(x, y);
        view.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ControladorPlatillos controller = new ControladorPlatillos();
  
        controller.modificarPlatillo(selectedPlatilloId, "", 0.0, "", true, 5);
          
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        ViewMenuCarta view = new ViewMenuCarta(selectedPlatilloId);
        jDesktopPane_opiciones.add(view);
        view.setSize(800, 500);
        Dimension desktopSize = jDesktopPane_opiciones.getSize();
        Dimension internalFrameSize = view.getSize();
        int x = (desktopSize.width - internalFrameSize.width) / 2;
        int y = (desktopSize.height - internalFrameSize.height) / 2;
        view.setLocation(x, y);
        view.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPlatillo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMenu;
    // End of variables declaration//GEN-END:variables
}
