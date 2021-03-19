package lecture_210308;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
            sum += 10000 + temp1 * 2000;
            sum += temp2 * 2000;
            sum += temp3 * 2000;
            text.setText(String.valueOf(sum) + "원");
            sum = 0;
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

    class TypePanel extends JPanel implements ChangeListener{
        private JRadioButton combo,potato,bulgogi;
        private ButtonGroup bg;

        public TypePanel() {
            setLayout(new GridLayout(3,1));
            combo = new JRadioButton("Combo", true);
            combo.addChangeListener(this);

            potato = new JRadioButton("potato");
            potato.addChangeListener(this);

            bulgogi = new JRadioButton("Bulgogi");
            bulgogi.addChangeListener(this);

            bg = new ButtonGroup();
            bg.add(combo);
            bg.add(potato);
            bg.add(bulgogi);

            setBorder(BorderFactory.createTitledBorder("species"));

            add(combo);
            add(potato);
            add(bulgogi);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() ==combo && combo.isSelected()) temp1 =0;
            else if(e.getSource() == potato && potato.isSelected()) temp1 =1;
            else if(e.getSource() == bulgogi && bulgogi.isSelected()) temp1 =2;

        }
    }

    class ToppingPanel extends JPanel implements ChangeListener{
        private JRadioButton pepper, cheese, peperoni, bacon;
        private ButtonGroup bg;

        public ToppingPanel() {
            setLayout(new GridLayout(4,1));
            
            pepper = new JRadioButton("pepper",true);
            pepper.addChangeListener(this);

            cheese = new JRadioButton("cheese");
            cheese.addChangeListener(this);

            peperoni = new JRadioButton("peperoni");
            peperoni.addChangeListener(this);

            bacon = new JRadioButton("bacon");
            bacon.addChangeListener(this);
            
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

        @Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource() == pepper && pepper.isSelected()) temp2 = 0; 		
			else if (e.getSource() == cheese && cheese.isSelected()) temp2 = 1;   	
			else if (e.getSource() == peperoni && peperoni.isSelected()) temp2 = 2;			
			else if(e.getSource()==bacon && bacon.isSelected()) temp2 = 3;		
		}
    }

    class SizePanel extends JPanel implements ChangeListener{
        private JRadioButton small, medium, large;
        private ButtonGroup bg;

        public SizePanel() {
            setLayout(new GridLayout(3,1));

            small = new JRadioButton("small", true);
            small.addChangeListener(this);

            medium = new JRadioButton("medium");
            medium.addChangeListener(this);

            large = new JRadioButton("large");
			large.addChangeListener(this);

            bg = new ButtonGroup();
            bg.add(small);
            bg.add(medium);
            bg.add(large);

            setBorder(BorderFactory.createTitledBorder("size"));

            add(small);
            add(medium);
            add(large);
        }

        @Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource()==small && small.isSelected()) temp3 = 0;
			else if (e.getSource()== medium && medium.isSelected()) temp3 = 1;
			else if(e.getSource()==large && large.isSelected()) temp3 = 2;
		}
    }
}
public class PizzaOrder {
    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }
}

