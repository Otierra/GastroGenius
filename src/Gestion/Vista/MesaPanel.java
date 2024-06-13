package Gestion.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class MesaPanel extends JPanel {
    private List<Mesa> mesas;
    private ViewMesas viewMesas; // Referencia al ViewMesas para actualizar la etiqueta

    public MesaPanel(ViewMesas viewMesas) {
        this.mesas = new ArrayList<>();
        this.viewMesas = viewMesas;
        setLayout(null); // Usar un layout nulo para posicionar los componentes manualmente
    }

    public void agregarMesa(int x, int y, int diameter, String idMesa) {
        Mesa mesa = new Mesa(x, y, diameter, idMesa);
        this.mesas.add(mesa);
        repaint();

        // Posicionamos la mesa dentro del panel
        mesa.setBounds(x, y, diameter, diameter);

        // Agregar un listener para mostrar el ID de la mesa al hacer clic en el círculo de la mesa
        mesa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarIdMesaSeleccionada(idMesa);
            }
        });

        // Agregar la mesa al panel
        add(mesa);
    }

    private void mostrarIdMesaSeleccionada(String idMesa) {
        // Actualizar la etiqueta en ViewMesas con el ID de la mesa seleccionada
        viewMesas.actualizarLabel(idMesa);
    }
}
