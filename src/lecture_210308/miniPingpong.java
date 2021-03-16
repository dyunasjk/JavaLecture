package lecture_210308;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 점수, 졌을 시 새로 시작 등등의 기능을 구현
public class miniPingpong extends JPanel implements KeyListener {
    private Ball ball;
    private Racquet racquet1;
    private Racquet racquet2;

    public miniPingpong() {
        ball = new Ball(this,Color.red); // this를 준 이유: 
        this.setBackground(Color.green);
        racquet1 = new Racquet(this, 10, 150, Color.blue);
        racquet2 = new Racquet(this, 560, 150, Color.yellow);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        racquet1.keyPressed(e);
        racquet2.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        racquet1.keyReleased(e);
        racquet2.keyReleased(e);
    }

    void move() {
        ball.move();
        racquet1.move();
        racquet2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ball.draw(g2d);
        racquet1.draw(g2d);
        racquet2.draw(g2d);
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame("pingpong Game");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        miniPingpong game = new miniPingpong();
        frame.add(game);
        frame.setVisible(true);
        while(true) {
            game.move();
            game.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Ball {
        private static final int RADIUS = 20;
        private int x = 0, y=0, xSpeed = 1, ySpeed = 1;
        private miniPingpong game;
        private Color color;

        public Ball(miniPingpong game, Color color) {
            this.game = game;
            this.color = color;
        }

        void move() {
            if (x + xSpeed < 0) xSpeed = 1;
            if (x + xSpeed > game.getWidth() -2*RADIUS) xSpeed = -1;
            if (y + ySpeed < 0) ySpeed = 1;
            if (y + ySpeed > game.getHeight() -2 * RADIUS) ySpeed = -1;
            if (collision()) xSpeed = -xSpeed;
            x += xSpeed;
            y += ySpeed;
        }

        private boolean collision() {
            return game.racquet1.getBounds().intersects(getBounds()) || game.racquet2.getBounds().intersects(getBounds());
        }

        public void draw(Graphics2D g) {
            g.setColor(color);
            g.fillOval(x, y, 2 *RADIUS, 2 *RADIUS);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
        }
    }

    class Racquet {
        private static final int WIDTH =10;
        private static final int HEIGHT = 80;
        private int x = 0, y = 0;
        private int xSpeed = 0, ySpeed = 0;
        private miniPingpong game;
        private Color color;

        public Racquet(miniPingpong game, int x, int y, Color color) {
            this.game = game;
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void move() {
            if( y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT) y += ySpeed;
        }
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.fillRect(x,y,WIDTH, HEIGHT);
        }

        public void keyReleased(KeyEvent e) {
            ySpeed = 0;
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) ySpeed = -3;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) ySpeed = 3;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, WIDTH, HEIGHT);
        }
    }
}

