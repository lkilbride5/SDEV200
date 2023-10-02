package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleColorChange extends JFrame {
    private Color circleColor = Color.WHITE;

    public CircleColorChange() {
        setTitle("Circle Color Change");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int circleDiameter = Math.min(getWidth(), getHeight()) - 50;
                int x = (getWidth() - circleDiameter) / 2;
                int y = (getHeight() - circleDiameter) / 2;
                g.setColor(circleColor);
                g.fillOval(x, y, circleDiameter, circleDiameter);
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                circleColor = Color.BLACK;
                panel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                circleColor = Color.WHITE;
                panel.repaint();
            }
        });

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CircleColorChange example = new CircleColorChange();
            example.setVisible(true);
        });
    }
}
