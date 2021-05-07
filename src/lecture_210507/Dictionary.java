package lecture_210507;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Dictionary extends JPanel implements ActionListener { // actionlistener  implements 해서 사용가능하게
    private JTextField inputField = new JTextField(30); // GUI 구성
    private JTextArea displayArea = new JTextArea(30,2);
    private JButton searchBtn = new JButton("search");
    private JButton addBtn1 = new JButton("edit");
    private JButton addBtn2 = new JButton("add");
    private JPanel searchAddPanel = new JPanel();
    private Map<String, String> dict1 = new HashMap<>();
    private Map<String, String> dict2 = new HashMap<>();


    public Dictionary() {
        // 레이아웃 설정을 해도 되고 안해도 됨
        // 플로우 레이아웃이기 때문에 입력순서대로 자동 배치
        searchAddPanel.add(inputField); // 또는 this
        searchAddPanel.add(searchBtn);
        searchBtn.addActionListener(this);
        searchAddPanel.add(addBtn2);
        addBtn2.addActionListener(this);
        searchAddPanel.setPreferredSize(new Dimension(600, 50));

        this.setLayout(new BorderLayout());
        this.add(searchAddPanel, BorderLayout.CENTER);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // 현재 해당 코드는 한영사전밖에 실행 불가
        // 영한 사전까지 구현해보자
        // 첫번째 단어가 영어 알파벳 범위인지 확인
        // 위의 
        String key = inputField.getText();
        System.out.println("["+key+"]");
        
        if(e.getSource() == searchBtn) {
            String value = dict1.get(key);
            if(value == null) {
                JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다", key, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == addBtn2) {
            String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영어 단어를 입력하세요"); // 중간에 취소를 하게 되면 nullpoint exception 발생
            if (value == null || value.trim().length() == 0) return;
                dict1.put(key, value);
                dict1.put(value, key);
                JOptionPane.showMessageDialog(this, "영어 단어가 추가되었습니다", "성공", JOptionPane.INFORMATION_MESSAGE);
        } inputField.requestFocus();
    /*    if(e.getSource() == searchBtn) {
            // 검색버튼이 클릭된 경우
            
            //    inputField에 입력된 단어를 추출
            //  dict 맵 객체에서 그 단어에 대응되는 영어단어를 찾아 디스플레이
            
            String key = inputField.getText();
            String value = dict1.get(key);
            if (key.trim().length() == 0 || value == null) {
                // displayArea.setText("");
                JOptionPane.showMessageDialog(this, "단어를 출력할 수 없습니다", "탐색 실패", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
            } inputField.requestFocus();
        } else if (e.getSource() == addBtn2) {
            // 추가 버튼이 클릭된 경우
            
            //    inputFiled에 압력된 단어를 추출하고
            //    그 단어에 대응되는 영어단어를 입력받은 다음
            //    dict 맵 책체에 <한글단어, 영어 단어>의 쌍을 추가
            
            String key = inputField.getText();
            String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영어 단어를 입력하세요");

            if (key.trim().length() > 0 && value.trim().length() > 0) {
                dict1.put(key, value);
                JOptionPane.showMessageDialog(this, "Success add the word", "Add Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } repaint();
    } */
    }


    public static void main(String[] args) {
        JPanel panel= new Dictionary();

        JFrame frame = new JFrame();
        frame.setTitle("My English wordbook");
        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
