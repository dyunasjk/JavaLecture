package lecture_210507;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class SimpleDictionaryDB extends JPanel implements ActionListener{
    private JTextField inputField = new JTextField(30);
    private JButton searchBtn = new JButton("검색");
    private JButton addBtn = new JButton("추가");
    private JPanel searchAddPanel = new JPanel();
    private Map<String, String> dict = new HashMap<>();

    private String diverClassName;
    private String dbURL;
    private String userName, userPassword;

    public SimpleDictionaryDB() {
        this.add(inputField);
        this.add(searchBtn);
        searchBtn.addActionListener(this);
    }
}
