package Gestion.Vista;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Mesa extends JPanel {
    private int x;
    private int y;
    private int diameter;
    private String numeroMesa;

    public Mesa(int x, int y, int diameter, String numeroMesa) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.numeroMesa = numeroMesa;

        setBounds(x, y, diameter, diameter);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Agregar tooltip con el número de la mesa
        setToolTipText("Mesa " + numeroMesa);
    }

    public int getDiameter() {
        return diameter;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }
}

