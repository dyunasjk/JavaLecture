package lecture_210308;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// use array and add more word // use papago api
public class Translator extends JFrame implements ActionListener{
    private JButton convertBtn;
    private JButton cancelBtn;
    private JTextArea textIn;
    private JTextArea textOut;
    
    public Translator() {
        super("text Convert");

        textIn = new JTextArea(10, 14);
        textIn.setLineWrap(true);
        textOut = new JTextArea(10,14);
        textOut.setLineWrap(true);
        textOut.setEditable(false);

        JPanel textAreaPanel = new JPanel(new GridLayout(1,2,20,20));
        textAreaPanel.add(textIn);
        textAreaPanel.add(textOut);

        convertBtn = new JButton("Convert");
        convertBtn.addActionListener(this);
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.add(convertBtn);
        btnPanel.add(cancelBtn);

        JPanel mainPanel = new JPanel(new BorderLayout(10,10));
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        this.add(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertBtn) {
            textOut.setText("");
            String result = toEnglish(textIn.getText());
            textOut.append(result);

        }
        if (e.getSource() == cancelBtn) textOut.setText("");

    }

    private String toEnglish(String korean) {
        String result = korean;
        result = result.replace("텍스트", "text");
        result = result.replace("영어", "English");
        return result;
    }

    //add papago api

    public static void main(String[] args) {
        new Translator();
    }
}
