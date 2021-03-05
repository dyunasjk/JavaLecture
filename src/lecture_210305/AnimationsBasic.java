package lecture_210305;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;

class MyPanel extends JPanel implements ActionListener() {
	
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int START_X = 0;
	private final int START_Y = 250;
	
	private BufferedImage image;
	private Timer timer;
	private int x, y;
	
	public MyPanel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDoubleBuffered(true);
		
		//이미지 파일을 읽어서 이미지 파일을 객체로 생성
		//20밀리세크 마다 이벤트를 발생시키는 타이머 객체를 생성하고 타이머 = 스타트 시킴
		File input = new File("ship.jpg");
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = START_X;
		y = START_Y;
		
		timer = new Timer(20, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		x += 1;
		y -= 1;
		if (x > WIDTH) {
			x = START_X;
			y = START_Y;
			
		}
		repaint();
	}
}

public class AnimationsBasic extends JFrame {
	public AnimationsBasic() {
		add(new MyPanel());
		setTitle("Animation test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnimationsBasic();
	}
}