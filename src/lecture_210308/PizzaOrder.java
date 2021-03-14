package lecture_210308;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

class MyFrame extends JFrame implements ActionListener {
    private int sum, temp1, temp2, temp3;
    private JButton order_button, cancel_button;

    private JPanel down_panel;
    private JTextField text;

    WelcomePanel welcome_panel = new WelcomePanel();
    TypePanel TypePanel = new TypePanel();
    ToppingPanel ToppingPanel = new ToppingPanel();
    SizePanel SizePanel = new SizePanel();

    public MyFrame() {
        this.setSize(500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("order Pizza");

        this.order_button = new JButton("order");
        this.order_button.addActionListener(this);
        this.cancel_button = new JButton("cancel");
        this.cancel_button.addActionListener(this);

        this.text = new JTextField();
        text.setEditable(false);
        text.setColumns(6);

        down_panel = new JPanel();
        down_panel.add(this.order_button);
        down_panel.add(this.cancel_button);
        down_panel.add(this.text);
        this.setLayout(new BorderLayout());

        this.add(welcome_panel, BorderLayout.NORTH);
        this.add(down_panel, BorderLayout.SOUTH);
        this.add(SizePanel, BorderLayout.EAST);
        this.add(TypePanel, BorderLayout.WEST);
        this.add(ToppingPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.order_button) {
            this.text.setText(" " +20000);
        }
        if (e.getSource() == this.cancel_button) {
            temp1 = 0;
            temp2 = 0;
            temp3 = 0;
            sum = 0;
            this.text.setText(" " + sum);
        }
    }

    class WelcomePanel extends JPanel {
        private JLabel message;

        public WelcomePanel() {
            message = new JLabel("Welcome to JavaPizza");
            add(message);
        }
    }

    class TypePanel extends JPanel {
        private JRadioButton combo,potato,bulgogi;
        private ButtonGroup bg;

        public TypePanel() {
            setLayout(new GridLayout(3,1));
            combo = new JRadioButton("Combo", true);
            potato = new JRadioButton("potato");
            bulgogi = new JRadioButton("Bulgogi");

            bg = new ButtonGroup();
            bg.add(combo);
            bg.add(potato);
            bg.add(bulgogi);

            setBorder(BorderFactory.createTitledBorder("species"));

            add(combo);
            add(potato);
            add(bulgogi);
        }
    }

    class ToppingPanel extends JPanel {
        private JRadioButton pepper, cheese, peperoni, bacon;
        private ButtonGroup bg;

        public ToppingPanel() {
            setLayout(new GridLayout(4,1));
            
            pepper = new JRadioButton("pepper",true);
            cheese = new JRadioButton("cheese");
            peperoni = new JRadioButton("peperoni");
            bacon = new JRadioButton("bacon");

            bg = new ButtonGroup();
            bg.add(pepper);
            bg.add(cheese);
            bg.add(peperoni);
            bg.add(bacon);

            setBorder((BorderFactory.createTitledBorder("add Topping")));

            add(pepper);
            add(cheese);
            add(peperoni);
            add(bacon);

        }
    }

    class SizePanel extends JPanel {
        private JRadioButton small, medium, large;
        private ButtonGroup bg;

        public SizePanel() {
            setLayout(new GridLayout(3,1));

            small = new JRadioButton("small", true);
            medium = new JRadioButton("medium");
            large = new JRadioButton("large");

            bg = new ButtonGroup();
            bg.add(small);
            bg.add(medium);
            bg.add(large);

            setBorder(BorderFactory.createTitledBorder("size"));

            add(small);
            add(medium);
            add(large);
        }
    }
}
public class PizzaOrder {
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }
}

