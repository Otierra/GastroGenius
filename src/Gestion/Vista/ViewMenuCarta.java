package Gestion.Vista;

import Gestion.Controlador.ControladorPlatillos;
import Gestion.Modelo.ModeloPlatilloMenu;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewMenuCarta extends javax.swing.JInternalFrame {

    private int selectedPlatilloId = -1;
    private String descripcion;
    private double precio;
    private String categoria;
    private boolean esComida;
    private int tiempoDePreparacion;
    private boolean esNew;

    public ViewMenuCarta() {
        this.esNew = true;
        initComponents(); // Inicializar componentes visuales
        initializeSliders(); // Método para inicializar sliders u otros componentes
    }
    
    public ViewMenuCarta(int platilloID) {
        this.selectedPlatilloId = platilloID;
        this.esNew = false;
        initComponents(); // Inicializar componentes visuales
        initializeSliders(); // Método para inicializar sliders u otros componentes
        ControladorPlatillos controller = new ControladorPlatillos();
        ModeloPlatilloMenu platillo = controller.obtenerPlatilloPorId(platilloID);

        if (platillo != null) {
            jSliderPrecio.setValue((int) platillo.getPrecio());
            jSliderPreparacion.setValue(platillo.getTiempoDePreparacion()); // Establecer el valor del JSlider para la preparación
            jTextPlatillo.setText(platillo.getDescripcion()); // Establecer el texto del platillo
            String categoria = platillo.getCategoria();
            for (int i = 0; i < jComboBoxCategoria.getItemCount(); i++) {
                if (jComboBoxCategoria.getItemAt(i).equals(categoria)) {
                    jComboBoxCategoria.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            // Manejar el caso donde el platillo no se encuentra
            JOptionPane.showMessageDialog(
                this,
                "Platillo con ID " + platilloID + " no encontrado.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void initializeSliders() {
        jSliderPrecio.addChangeListener(new ChangeListener() {
             public void stateChanged(ChangeEvent e) {
                 jTextPrecio.setText(String.valueOf(jSliderPrecio.getValue()));
             }
         });

         jSliderPreparacion.addChangeListener(new ChangeListener() {
             public void stateChanged(ChangeEvent e) {
                 jTextTiempo.setText(String.valueOf(jSliderPreparacion.getValue()));
             }
         });

         jTextPrecio.setEditable(false);
         jTextTiempo.setEditable(false);
     }

    private void resetForm() {
        jSliderPrecio.setValue(25); // Establecer el valor del JSlider para el precio en 25
        jSliderPreparacion.setValue(5); // Establecer el valor del JSlider para la preparación en 5
        jTextPlatillo.setText(""); // Limpiar el campo de texto del platillo
        jComboBoxCategoria.setSelectedIndex(-1); // Desseleccionar cualquier elemento en el JComboBox
    }
    
    
    private void obtenerValoresComponentes() {
        // Obtener nombre del platillo
        descripcion = jTextPlatillo.getText().trim();
        // Obtener precio del platillo
        precio = Double.parseDouble(jTextPrecio.getText());
        // Obtener categoría del platillo
        categoria = jComboBoxCategoria.getSelectedItem().toString();
        // Obtener tipo de platillo (comida o bebida)
        if (jRadioButtonComida.isSelected() == true){
            esComida = true;
        }else if (jRadioButtonBebida.isSelected() == true){
            esComida = false;
        }
        // Obtener tiempo de preparación
        tiempoDePreparacion = jSliderPreparacion.getValue();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextPlatillo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSliderPrecio = new javax.swing.JSlider();
        jTextPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonComida = new javax.swing.JRadioButton();
        jRadioButtonBebida = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextTiempo = new javax.swing.JTextField();
        jSliderPreparacion = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/cheque.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gestion/Vista/cancelar.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del platillo :");

        jLabel2.setText("Precio del platillo :");

        jSliderPrecio.setMaximum(500);
        jSliderPrecio.setMinimum(25);

        jTextPrecio.setText("25");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("$");

        jLabel4.setText("Categoria :");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carne", "Pescado", "Vegeteriano", "Picante", "Especial por Temporada", "Sin Alcohol", "Con Alcohol", " " }));

        jLabel5.setText("Tipo de platillo :");

        buttonGroup1.add(jRadioButtonComida);
        jRadioButtonComida.setSelected(true);
        jRadioButtonComida.setText("¿ Es comida?");

        buttonGroup1.add(jRadioButtonBebida);
        jRadioButtonBebida.setText("¿ Es bebida?");

        jLabel6.setText("Tiempo de preparación :");

        jTextTiempo.setText("5");

        jSliderPreparacion.setMaximum(50);
        jSliderPreparacion.setMinimum(5);
        jSliderPreparacion.setToolTipText("");
        jSliderPreparacion.setValue(5);

        jLabel7.setText("min.");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Platillo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextPlatillo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSliderPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonComida)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonBebida))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSliderPreparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(309, 309, 309))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSliderPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButtonComida)
                    .addComponent(jRadioButtonBebida))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSliderPreparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        obtenerValoresComponentes();
        ControladorPlatillos controller = new ControladorPlatillos();
        
        if (esNew){
            controller.agregarPlatillo(descripcion, precio, categoria, esComida, tiempoDePreparacion);
        }else{
            controller.modificarPlatillo(selectedPlatilloId, descripcion, precio, categoria, esComida, tiempoDePreparacion);
            this.dispose();
        }
        
        resetForm();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButtonBebida;
    private javax.swing.JRadioButton jRadioButtonComida;
    private javax.swing.JSlider jSliderPrecio;
    private javax.swing.JSlider jSliderPreparacion;
    private javax.swing.JTextField jTextPlatillo;
    private javax.swing.JTextField jTextPrecio;
    private javax.swing.JTextField jTextTiempo;
    // End of variables declaration//GEN-END:variables
}
