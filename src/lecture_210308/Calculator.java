package lecture_210308;

import java.awt.*;
import java.awt.Dimension.*;
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
        panel.setBackground(Color.gray);
  
        display.setBackground(Color.BLACK);
        display.setForeground(Color.white);
        display.setHorizontalAlignment(JTextField.RIGHT);
        Font font = new Font("serif", Font.BOLD, 30);
        display.setFont(font);
  
        buttons = new JButton[25];
        int index = 0;
        for (int rows = 0; rows < 5; rows++) { 
            for (int cols = 0; cols < 5; cols++) {
                buttons[index] = new JButton(labels[index]);
                buttons[index].setPreferredSize(new Dimension(60, 50));
                buttons[index].setBackground(Color.WHITE);
                if (cols >= 3) buttons[index].setForeground(Color.red); //반복하면서 계산기의 버튼을 생성. 동일한 메소드로 이벤트 처리
                else buttons[index].setForeground(Color.blue);
                panel.add(buttons[index]);
                buttons[index].addActionListener(this);
                index++;
            }
        }
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) == 'C') { //클리어 버튼 처리
            startOfNumber = true;
            result = 0;
            operator = "=";
            display.setText("0.0");
        } else if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            if (startOfNumber == true) display.setText(command);
            else display.setText(display.getText() + command);
            startOfNumber = false;
        } else {
            if (startOfNumber) {
                if (command.equals("-")) {
                    display.setText(command);
                    startOfNumber = false;
                } else operator = command; // 숫자입력이 시작되는 경우를 처리
            } else {
                double x = Double.parseDouble((display.getText()));
                calculate(x);
                operator = command;
                startOfNumber = true; // 연산자 기호 입력시 연산 실시
            }
        }
    }

    private void calculate(double n) {
        if (operator.equals("+")) result += n ;
        else if (operator.equals("-")) result -= n;
        else if (operator.equals("*")) result *= n;
        else if (operator.equals("/")) result /= n;
        else if (operator.equals("=")) result = n;
        else if (operator.equals("sqrt")) result = n;
        display.setText(" " + result);
    }

    public static void main(String[] args) {
        Calculator s = new Calculator();
    }
}
