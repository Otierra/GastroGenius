package Gestion.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MesaPanel extends JPanel {
    private List<Mesa> mesas;

    public MesaPanel() {
        this.mesas = new ArrayList<>();
        setLayout(null); // Usar un layout nulo para posicionar los componentes manualmente
    }

    void agregarMesa(int x, int y, int diameter, String numeroMesa) {
        Mesa mesa = new Mesa(x, y, diameter, numeroMesa);
        this.mesas.add(mesa);
        repaint();

        // Crear un JLabel para mostrar el número de mesa
        JLabel label = new JLabel(numeroMesa);
        label.setBounds(x + diameter / 4, y + diameter / 4, diameter / 2, diameter / 2);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        // Agregar un listener para mostrar el diálogo al hacer clic en el círculo
        mesa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarDialogoCapacidad(mesa.getNumeroMesa());
            }
        });
        add(mesa);
    }

    private void mostrarDialogoCapacidad(String numeroMesa) {
        // Aquí puedes implementar la lógica para obtener la capacidad real de la mesa
        int capacidadActual = obtenerCapacidad(numeroMesa);

        // Construir el mensaje del diálogo
        String mensaje = "Mesa " + numeroMesa + "\n";
        mensaje += "Capacidad actual: " + capacidadActual + " sillas\n";

        // Mostrar el cuadro de diálogo
        JOptionPane.showMessageDialog(this, mensaje, "Capacidad de la Mesa", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método simulado para obtener la capacidad actual de la mesa (para demostración)
    private int obtenerCapacidad(String numeroMesa) {
        // Implementación simulada para obtener la capacidad actual
        // Devuelve un número aleatorio entre 1 y 10 (aquí podrías integrar tu lógica real)
        return (int) (Math.random() * 10) + 1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN); // Color de las mesas
        for (Mesa mesa : mesas) {
            g.fillOval(mesa.getX(), mesa.getY(), mesa.getDiameter(), mesa.getDiameter());
        }
    }
}
