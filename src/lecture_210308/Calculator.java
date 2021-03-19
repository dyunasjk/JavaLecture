package lecture_210308;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField display;
    private JButton[] buttons;
    private String[] labels = {"Back Space", " ", " ", "CE", "C", "7", "8", "9", "/", "sqrt", "4", "5", "6", "x", "%", "1", "2", "3","-","1/x","0","-/+",".","+", "="};
    private double result = 0;
    private String operator = "=";
    private boolean startOfNumber = true;

    public Calculator() {
        display = new JTextField();
        panel = new JPanel();
        display.setText("0.0");
        //display.setEnabled(true);

        panel.setLayout(new GridLayout(0,5,3,3));
        buttons = new JButton[25];
        int index = 0;
        for (int rows = 0; rows < 5; rows++) {
            for (int cols = 0; cols < 5; cols++) {
                buttons[index] = new JButton(labels[index]);
                if (cols >= 3) buttons[index].setForeground(Color.red); //반복하면서 계산기의 버튼을 생성. 동일한 메소드로 이벤트 처리
                else buttons[index].setForeground(Color.blue);
                buttons[index].setForeground(Color.yellow);
                panel.add(buttons[index]);
                buttons[index].addActionListener(this);
                index++;
            }
        }
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
    }
}
