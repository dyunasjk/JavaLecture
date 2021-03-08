package lecture_210308;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class ImageLabelTest extends JFrame implements ActionListener {
	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	public ImageLabelTest() {
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel= new JPanel();
		label = new JLabel("이미지를 보려면 버튼을 누르세요");
		
		button = new JButton("see Image");
		ImageIcon icon = new ImageIcon("icon.gif");
		button.setIcon(icon);
		button.addActionListener(this);
		
		panel.add(label);
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon dog = new ImageIcon("dog.gif");
		File file = new File("dog.gif");
		System.out.println(file.getAbsolutePath());
		label.setIcon(dog);
		label.setText(null);
	}
	
	public static void main(String[] args) {
		new ImageLabelTest();
	}
}
