package lecture_210308;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class DisplayCapture {
    public static void main(String[] args) {
        JFrame capture = new JFrame();
        capture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension d;
        Rectangle rect = new Rectangle(500,500);
        capture.setSize(d= new Dimension(500,500));

        try {
            Robot robot = new Robot();
            final BufferedImage image = robot.createScreenCapture(rect);
            image.flush();
            JPanel panel = new JPanel() {
                public void paintComponent(Graphics g) {
                    g.drawImage(image, 0, 0, d.width, d.height, this);
                }
            };
            panel.setOpaque(false);
            panel.prepareImage(image, panel);
            panel.repaint();
            capture.getContentPane().add(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        capture.setVisible(true);
    }
    
}
