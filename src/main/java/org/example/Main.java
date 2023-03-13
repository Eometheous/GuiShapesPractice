package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new ShapeFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class ShapeFrame extends JFrame {
        public static final int WIDTH = 400;
        public static final int HEIGHT = 400;

        public ShapeFrame() {
            setTitle("Shape Test");
            setSize(WIDTH, HEIGHT);

            DrawPanel panel = new DrawPanel();
            add(panel);
        }
    }
    static class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            double x = 100;
            double y = 100;
            double width = 200;
            double height = 200;

            Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
            g2.draw(rect);

            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrame(rect);

            g2.setPaint(Color.RED);
            g2.fill(ellipse);
            g2.draw(ellipse);

            g2.draw(new Line2D.Double(x, y, x + width, y + height));

            double centerX = rect.getCenterX();
            double centerY = rect.getCenterY();
            double radius = 150;

            Ellipse2D circle = new Ellipse2D.Double();
            circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
            g2.draw(circle);
        }
    }
}