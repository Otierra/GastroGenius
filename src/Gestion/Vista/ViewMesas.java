package Gestion.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.net.URL;

public class ViewMesas extends javax.swing.JInternalFrame {

    private MesaPanel mesaPanel;

   public ViewMesas() {
        initComponents();
        setTitle("Mesas");

        // Crear el panel de mesas (en este caso, círculos)
        mesaPanel = new MesaPanel();

        // Configurar el layout del JInternalFrame
        getContentPane().setLayout(new BorderLayout());

        // Agregar las 10 mesas distribuidas uniformemente en dos filas
        agregarMesasEnDosFilas();

        // Crear panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10)); // GridLayout para alinear los botones verticalmente con espaciado

        // Crear y configurar los botones
        JButton btnNuevaOrden = createIconButton("Nueva Orden", "/Gestion/servicio-de-comida.png");
        JButton btnNuevoPedido = createIconButton("Nuevo Pedido", "/Gestion/food-and-drink.png");
        JButton btnCuenta = createIconButton("Cuenta", "/Gestion/recepcion.png");

        // Agregar los botones al panel
        panelBotones.add(btnNuevaOrden);
        panelBotones.add(btnNuevoPedido);
        panelBotones.add(btnCuenta);

        // Agregar el panel de botones y el panel de mesas al JInternalFrame
        getContentPane().add(panelBotones, BorderLayout.WEST); // Añadir panel de botones a la izquierda
        getContentPane().add(mesaPanel, BorderLayout.CENTER); // Añadir panel de mesas (círculos) al centro

        // Ajustar tamaño y otros ajustes del JInternalFrame
        setResizable(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        pack(); // Ajusta automáticamente el tamaño del JInternalFrame según su contenido
    }

   private JButton createIconButton(String text, String iconPath) {
        JButton button = new JButton(text);

        // Cargar el icono desde el archivo usando getResource
        URL imageUrl = getClass().getResource(iconPath);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            button.setIcon(icon);
        } else {
            System.err.println("No se pudo encontrar la imagen en la ruta especificada: " + iconPath);
        }

        // Configuración adicional del botón
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);

        return button;
    }
   
    private void agregarMesasEnDosFilas() {
        // Asumiendo un tamaño fijo del panel
        int panelWidth = 600;
        int panelHeight = 400;

        // Calculando la posición y el tamaño de cada mesa
        int numMesasPorFila = 5;
        int diameter = 80;
        int padding = 20; // Espacio entre mesas y entre filas

        // Distribuir las mesas en dos filas
        int startX1 = (panelWidth - (numMesasPorFila * (diameter + padding))) / 2; // Iniciar desde el centro para la primera fila
        int startX2 = (panelWidth - (numMesasPorFila * (diameter + padding))) / 2; // Iniciar desde el centro para la segunda fila
        int y1 = (panelHeight - diameter - padding) / 4; // Posición Y para la primera fila
        int y2 = (panelHeight - diameter - padding) * 3 / 4; // Posición Y para la segunda fila

        for (int i = 0; i < 10; i++) {
            int x, y;
            if (i < 5) {
                x = startX1 + i * (diameter + padding);
                y = y1;
            } else {
                x = startX2 + (i - 5) * (diameter + padding);
                y = y2;
            }
            mesaPanel.agregarMesa(x, y, diameter, String.valueOf(i + 1));
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

