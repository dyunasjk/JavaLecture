package lecture_210308;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class TextArea extends JFrame implements ActionListener {
    protected JTextField textField;
    protected JTextArea textArea;

    public TextArea() {
        setTitle("Text Area Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.addActionListener(this);

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        add(scrollPane, BorderLayout.CENTER); // 추가하여 스크롤 팬 생성
        add(textField, BorderLayout.NORTH);
        // add(textArea, BorderLayout.CENTER); 

        pack();
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        textArea.append(text + "\n");
        textField.selectAll();
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        new TextArea();
    }
}
