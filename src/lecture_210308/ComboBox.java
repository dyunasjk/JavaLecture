package lecture_210308;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.*;


public class ComboBox extends JFrame implements ActionListener {

    JLabel label;

    public ComboBox() {
        setTitle("콤보 박스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);

        String[] animals = {"dog", "lion", "tiger"};
        JComboBox animalList = new JComboBox(animals);
        animalList.setSelectedIndex(0);
        animalList.addActionListener(this);

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        changePicture(animals[animalList.getSelectedIndex()]);
        add(animalList, BorderLayout.PAGE_START);
        add(label, BorderLayout.PAGE_END);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String name = (String) cb.getSelectedItem();
        changePicture(name);
    }

    protected void changePicture(String name) {
        ImageIcon icon = new ImageIcon(name + ".gif");
        label.setIcon(icon);
        if (icon != null) {
            label.setText(null);
        } else {
            label.setText("not founded images");
        }
    }

    public static void main(String[] args) {
        ComboBox comboBox = new ComboBox();
    }
}
