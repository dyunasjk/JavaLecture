package lecture_210308;

import javax.swing.*;
import java.util.*;
import java.lang.Math;
import java.math.*;
import java.awt.*;
import java.awt.event.*;

public class TextField extends JFrame{
    private JButton button;
    private JTextField text, result;

    public TextField() {
        setSize(300, 130);
        setTitle("calculate Squared");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonListener listener = new ButtonListener();

        JPanel panel = new JPanel();
        panel.add(new JLabel("insert num"));
        text = new JTextField(15);
        text.addActionListener(listener);
        panel.add(text);

        panel.add(new JLabel("Squared value"));
        result = new JTextField(15);
        result.setEditable(false);
        panel.add(result);

        button = new JButton("OK");
        button.addActionListener(listener);
        panel.add(button);
        add(panel);
        this.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button || e.getSource() == text) {
                String name = text.getText();
                int value = Integer.parseInt(name);
                result.setText(" " + value * value );
                text.requestFocus();
            }
        }
    }

    public static void main(String[] args) {
        new TextField();
    }
}
