package lecture_210308;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FileChooser extends JFrame implements ActionListener {
    JButton openButton, saveButton;
    JFileChooser fc;

    public FileChooser () {
        setTitle("file chooser test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        fc = new JFileChooser();

        JLabel label = new JLabel("It is file component test");
        openButton = new JButton("open file");
        openButton.addActionListener(this);
        saveButton = new JButton("save file");
        saveButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(saveButton);
        panel.add(openButton);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
            } else {

            }
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
            }
        }
    }

    public static void main(String[] args) {
        FileChooser frame = new FileChooser();
    }
}
