package Gestion.Vista;
 
import javax.swing.*;
import java.awt.*;

public class Mesa extends JPanel {
    private int x, y, diameter;
    private String idMesa;

    public Mesa(int x, int y, int diameter, String idMesa) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.idMesa = idMesa;

        setPreferredSize(new Dimension(diameter, diameter));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel label = new JLabel(idMesa, JLabel.CENTER);
        add(label);
    }

    public String getIdMesa() {
        return idMesa;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, diameter, diameter);
    }
}

