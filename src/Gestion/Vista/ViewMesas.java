package Gestion.Vista;

    import Gestion.Controlador.ControladorOrdenes;
import Gestion.Controlador.ControladorPlatillos;
    import Gestion.Controlador.GestorMesas;
    import Gestion.Modelo.ModeloMesa;
import Gestion.Modelo.ModeloPedido;
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import javax.swing.border.LineBorder;
    import java.net.URL;

    public class ViewMesas extends javax.swing.JInternalFrame {

        private MesaPanel mesaPanel;
        private JLabel labelMesaSeleccionada;
        private JButton btnNuevaOrden;
        private JButton btnNuevoPedido;
        private JButton btnCuenta;
        private int idMesaSeleccionada = -1;
        private JDesktopPane jDesktopPane_opiciones;
        
        public void setJDesktopPane(JDesktopPane jDesktopPane_opiciones) {
            this.jDesktopPane_opiciones = jDesktopPane_opiciones;
        }
        
        public ViewMesas() {
        initComponents();
        setTitle("Mesas");

        mesaPanel = new MesaPanel(this); // Pasamos una referencia de ViewMesas a MesaPanel

        getContentPane().setLayout(new BorderLayout());

        // Agregar las 10 mesas distribuidas uniformemente en dos filas
        agregarMesasEnDosFilas();

        // Crear panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10)); // GridLayout para alinear los botones verticalmente con espaciado

        // Crear y configurar los botones
        btnNuevaOrden = createIconButton("Nueva Orden", "/Gestion/servicio-de-comida.png");
        btnNuevoPedido = createIconButton("Nuevo Pedido", "/Gestion/food-and-drink.png");
        btnCuenta = createIconButton("Cuenta", "/Gestion/recepcion.png");

        // Deshabilitar botones inicialmente
        btnNuevaOrden.setEnabled(false);
        btnNuevoPedido.setEnabled(false);
        btnCuenta.setEnabled(false);

        // Agregar los botones al panel
        panelBotones.add(btnNuevaOrden);
        panelBotones.add(btnNuevoPedido);
        panelBotones.add(btnCuenta);

        // Crear etiqueta para mostrar la mesa seleccionada
        labelMesaSeleccionada = new JLabel("Mesa seleccionada: ");
        getContentPane().add(labelMesaSeleccionada, BorderLayout.NORTH); // Añadir etiqueta arriba de los botones

        // Agregar el panel de botones y el panel de mesas al JInternalFrame
        getContentPane().add(panelBotones, BorderLayout.WEST); // Añadir panel de botones a la izquierda
        getContentPane().add(mesaPanel, BorderLayout.CENTER); // Añadir panel de mesas (círculos) al centro

        // Añadir ActionListener al botón de Nueva Orden
        btnNuevaOrden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idMesaSeleccionada != -1) {
                    ControladorOrdenes.asignarMesaAOrden(idMesaSeleccionada);
                    
                    int idOrdenTomandoOrden = ControladorOrdenes.obtenerIdOrdenEnTomandoOrden(idMesaSeleccionada);
                    if (idOrdenTomandoOrden != -1) {
                        // Actualizar estado de la mesa seleccionada
                        GestorMesas.actualizarEstadoMesa(idMesaSeleccionada, idOrdenTomandoOrden, false);

                        // Bloquear el botón "Agregar Orden" y desbloquear los otros dos botones
                        btnNuevaOrden.setEnabled(false);
                        btnNuevoPedido.setEnabled(true);
                        btnCuenta.setEnabled(true);

                        // Actualizar estado del botón u otras acciones necesarias después de asignar la orden
                    } else {
                        System.out.println("No hay ninguna orden en estado 'Tomando Orden'.");
                    }
                }
            }
        });
        
        btnNuevoPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idMesaSeleccionada != -1) {
                    int idOrdenTomandoOrden = ControladorOrdenes.obtenerIdOrdenEnTomandoOrden(idMesaSeleccionada);
                    // Crear una instancia de ViewPedido
                    ViewPedido viewPedido = new ViewPedido(idOrdenTomandoOrden, idMesaSeleccionada);

                    // Agregar ViewPedido al JDesktopPane
                    jDesktopPane_opiciones.add(viewPedido);
                    viewPedido.setVisible(true); // Hacer visible la ventana de pedido

                    // Centrar ViewPedido dentro de jDesktopPane_opiciones
                    Dimension desktopSize = jDesktopPane_opiciones.getSize();
                    Dimension internalFrameSize = viewPedido.getSize();
                    int x = (desktopSize.width - internalFrameSize.width) / 2;
                    int y = (desktopSize.height - internalFrameSize.height) / 2;
                    viewPedido.setLocation(x, y);

                    // Opcional: Puedes configurar más propiedades de ViewPedido aquí si es necesario
                } else {
                    System.out.println("Debe seleccionar una mesa antes de agregar un pedido.");
                }
            }
        });

        btnCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (idMesaSeleccionada != -1) {
                   double total = 0.0;
                   int ordenID = GestorMesas.obtenerOrdenPorMesa(idMesaSeleccionada);
                   java.util.List<ModeloPedido> lst = ControladorOrdenes.obtenerPedidosDeOrden(ordenID);
                   for (ModeloPedido pedido : lst) {
                       String platillo = pedido.getNombrePlatillo();
                       ControladorPlatillos viewController = new ControladorPlatillos();
                       
                       double precioPlatillo = viewController.obtenerPrecioPorNombre(platillo);
                       total += precioPlatillo;
                   }
                   
                   GestorMesas.liberarMesa(idMesaSeleccionada);
                   
                    String mensaje = String.format(
                        "Cuenta mandada e impresora.\nEl total de la mesa %d con orden %d es de un total %.2f",
                        idMesaSeleccionada, ordenID, total
                    );

                    // Mostrar el diálogo
                    JOptionPane.showMessageDialog(
                        null, 
                        mensaje, 
                        "Cuenta de la Mesa", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
               
                    btnNuevaOrden.setEnabled(true);
                    btnNuevoPedido.setEnabled(false);
                    btnCuenta.setEnabled(false);
               }
            }
        });
        
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

        public void actualizarLabel(String idMesa) {
            labelMesaSeleccionada.setText("Mesa seleccionada: " + idMesa);
            idMesaSeleccionada = Integer.parseInt(idMesa);
            verificarDisponibilidadMesa(idMesaSeleccionada);
        }

        private void verificarDisponibilidadMesa(int idMesa) {
            ModeloMesa[] mesas = GestorMesas.obtenerMesas();
            for (ModeloMesa mesa : mesas) {
                if (mesa.getIdMesa() == idMesa) {
                    if (mesa.isDisponible()) {
                        btnNuevaOrden.setEnabled(true);
                        btnNuevoPedido.setEnabled(false);
                        btnCuenta.setEnabled(false);
                    } else {
                        btnNuevaOrden.setEnabled(false);
                        btnNuevoPedido.setEnabled(true);
                        btnCuenta.setEnabled(true);
                    }
                    return;
                }
            }
            // Si no se encuentra la mesa, deshabilitar todos los botones
            btnNuevaOrden.setEnabled(false);
            btnNuevoPedido.setEnabled(false);
            btnCuenta.setEnabled(false);
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 500));

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
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}


