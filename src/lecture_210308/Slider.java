package lecture_210308;

import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Slider extends JFrame implements ChangeListener {

    static final int INIT_VALUE = 15;
    private JButton buttonOK;
    private JSlider slider;
    private JButton button;

    public Slider() {
        JPanel panel;

        this.setTitle("Slider Test");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();
        JLabel label = new JLabel("move the slider", SwingConstants.CENTER);
        panel.add(label);

        slider = new JSlider(0,30,INIT_VALUE);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        panel.add(slider);

        button = new JButton(" ");
        ImageIcon icon = new ImageIcon("dog.gif");
        button.setIcon(icon);
        button.setSize(INIT_VALUE * 10, INIT_VALUE *10);
        panel.add(button);

        this.add(panel);
        this.setSize(300, 500);
        this.setVisible(true);

    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            int value = source.getValue();
            button.setSize(value *10, value * 10);

        }
    }

    public static void main(String[] args) {
        new Slider();
    }
}
