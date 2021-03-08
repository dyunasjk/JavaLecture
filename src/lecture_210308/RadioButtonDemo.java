package lecture_210308;

import javax.swing.JRadioButton;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {

    private JRadioButton small, medium, large;
    private JLabel text;
    private JPanel topPanel, sizePanel, resultPanel;
    
    public RadioButtonDemo() {
        setTitle("Radio Button Test");
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel = new JPanel();
        JLabel label = new JLabel("What's your order?");
        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);

        sizePanel = new JPanel();
        small = new JRadioButton("small size");
        medium = new JRadioButton("medium size");
        large = new JRadioButton("large size");

        ButtonGroup size = new ButtonGroup();
        size.add(small);
        size.add(medium);
        size.add(large);

        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);

        sizePanel.add(small);
        sizePanel.add(medium);
        sizePanel.add(large);

        add(sizePanel, BorderLayout.CENTER);

        resultPanel = new JPanel();
        text = new JLabel();
        text.setForeground(Color.red);
        resultPanel.add(text);
        add(resultPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == small) {
            text.setText("You choose small size");
        } else if (e.getSource() == medium) {
            text.setText("You choose medium size");
        } else if (e.getSource() == large) {
            text.setText("You choose large size");
        }
    }

    public static void main(String[] args) {
        new RadioButtonDemo();
    }
}
