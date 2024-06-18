
package Gestion.Vista;

import Gestion.ImagenFondo;
import Gestion.Modelo.ModeloPlatilloMenu;
import javax.swing.*;
import java.awt.*;


public class ViewMenu extends javax.swing.JFrame {

    private ImagenFondo fondo;

    public ViewMenu() {
        fondo = new ImagenFondo("src/ceti.png");
        this.setContentPane(fondo);

        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu");
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane_opiciones = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMesa = new javax.swing.JMenu();
        jMenuOrden = new javax.swing.JMenu();
        jMenuCocina = new javax.swing.JMenu();
        jMenuCarta = new javax.swing.JMenu();
        jMenuReporte = new javax.swing.JMenu();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 17, 56));
        jPanel2.setPreferredSize(new java.awt.Dimension(820, 560));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane_opiciones.setBackground(new java.awt.Color(0, 102, 102));
        jDesktopPane_opiciones.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jDesktopPane_opiciones.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel2.add(jDesktopPane_opiciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 540));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 560));

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuMesa.setText("Mesa");
        jMenuMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuMesaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuMesa);

        jMenuOrden.setText("Ordenes");
        jMenuOrden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuOrdenMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuOrden);

        jMenuCocina.setText("Cocina");
        jMenuCocina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuCocinaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuCocina);

        jMenuCarta.setText("Menu");
        jMenuCarta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuCartaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuCarta);

        jMenuReporte.setText("Reporte");
        jMenuBar1.add(jMenuReporte);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuMesaMouseClicked
        ViewMesas viewMesas = new ViewMesas();
        jDesktopPane_opiciones.add(viewMesas);
        viewMesas.setSize(800, 500); // Establecer el tamaño de ViewMesas
        Dimension desktopSize = jDesktopPane_opiciones.getSize();
        Dimension internalFrameSize = viewMesas.getSize();
        int x = (desktopSize.width - internalFrameSize.width) / 2;
        int y = (desktopSize.height - internalFrameSize.height) / 2;
        viewMesas.setLocation(x, y); // Centrar ViewMesas en el desktopPane
        viewMesas.setVisible(true);
        
        viewMesas.setJDesktopPane(jDesktopPane_opiciones);
    }//GEN-LAST:event_jMenuMesaMouseClicked

    private void jMenuCartaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCartaMouseClicked
        ViewTableMenu viewCarta = new ViewTableMenu();
        jDesktopPane_opiciones.add(viewCarta);
        viewCarta.setSize(800, 500); 
        Dimension desktopSize = jDesktopPane_opiciones.getSize();
        Dimension internalFrameSize = viewCarta.getSize();
        int x = (desktopSize.width - internalFrameSize.width) / 2;
        int y = (desktopSize.height - internalFrameSize.height) / 2;
        viewCarta.setLocation(x, y); 
        viewCarta.setVisible(true);
        
       viewCarta.setJDesktopPane(jDesktopPane_opiciones);
    }//GEN-LAST:event_jMenuCartaMouseClicked

    private void jMenuCocinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCocinaMouseClicked
        ViewTableCocina viewTableCocina = new ViewTableCocina();
        jDesktopPane_opiciones.add(viewTableCocina);
        viewTableCocina.setSize(800, 500); 
        Dimension desktopSize = jDesktopPane_opiciones.getSize();
        Dimension internalFrameSize = viewTableCocina.getSize();
        int x = (desktopSize.width - internalFrameSize.width) / 2;
        int y = (desktopSize.height - internalFrameSize.height) / 2;
        viewTableCocina.setLocation(x, y); 
        viewTableCocina.setVisible(true);
    }//GEN-LAST:event_jMenuCocinaMouseClicked

    private void jMenuOrdenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuOrdenMouseClicked
        ViewTablaOrdenes viewOrdenesTable = new ViewTablaOrdenes();
        jDesktopPane_opiciones.add(viewOrdenesTable);
        viewOrdenesTable.setSize(800, 500); 
        Dimension desktopSize = jDesktopPane_opiciones.getSize();
        Dimension internalFrameSize = viewOrdenesTable.getSize();
        int x = (desktopSize.width - internalFrameSize.width) / 2;
        int y = (desktopSize.height - internalFrameSize.height) / 2;
        viewOrdenesTable.setLocation(x, y); 
        viewOrdenesTable.setVisible(true);
        
        viewOrdenesTable.setJDesktopPane(jDesktopPane_opiciones);
    }//GEN-LAST:event_jMenuOrdenMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new ViewMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JDesktopPane jDesktopPane_opiciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCarta;
    private javax.swing.JMenu jMenuCocina;
    private javax.swing.JMenu jMenuMesa;
    private javax.swing.JMenu jMenuOrden;
    private javax.swing.JMenu jMenuReporte;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
