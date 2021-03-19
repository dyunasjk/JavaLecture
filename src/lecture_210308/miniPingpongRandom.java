package lecture_210308;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
// 점수, 졌을 시 새로 시작 등등의 기능을 구현
// 두명이 플레이 할수 있게 player 1 라켓 : ws 위아래로 이동 / player 2 : 화살표 위아래로 이동, 점수 표시
public class miniPingpongRandom extends JPanel implements KeyListener {
    private Ball ball;
    private Racquet racquet1;
    private Racquet racquet2;
    private ScoreBoard score;

    public miniPingpongRandom() {
        ball = new Ball(this,Color.white); // this를 준 이유: 
        this.setBackground(Color.black);
        racquet1 = new Racquet(this, 10, 150, Color.blue);
        racquet2 = new Racquet(this, 560, 150, Color.red);
        score = new ScoreBoard();
        this.setFocusable(true);
        this.addKeyListener(this);
        this.add(score, BorderLayout.NORTH);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        racquet1.keyPressed1(e);
        racquet2.keyPressed2(e);
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
        final int WIDTH = 600, HEIGHT = 400;
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        miniPingpongRandom game = new miniPingpongRandom();
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
        private static final int RADIUS = 5;
        private int x = 300, y=200, bXSpeed = 2, bYSpeed = 2;
        private miniPingpongRandom game;
        private Color color;
        public int sa = 0, sb =0;

        public Ball(miniPingpongRandom game, Color color) {
            this.game = game;
            this.color = color;
        }

        void move() { //공을 움직이는 코드
            
            if (x + bXSpeed < 0) {
                sb += 1;
                bXSpeed = 2;
            }
            if (x + bXSpeed > game.getWidth() -2*RADIUS) {
                sa += 1;
                bXSpeed = -2;
            }
            if (y + bYSpeed < 0) bYSpeed = 2;
            if (y + bYSpeed > game.getHeight() -2 * RADIUS) bYSpeed = -2;
            if (collision()) bXSpeed = -bXSpeed;
            x += bXSpeed;
            y += bYSpeed;
            
        }

        private boolean collision() { //
            return game.racquet1.getBounds().intersects(getBounds())
            || game.racquet2.getBounds().intersects(getBounds()); // 충돌했는지를 검사
        }

        public void draw(Graphics2D g) { //공을 그리는 메소드
            g.setColor(color);
            g.fillOval(x, y, 2 *RADIUS, 2 *RADIUS);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
        }
        // void restart() {
        //     if (collision()) {
        //         x = 300;
        //         y = 200;
        //     }
        // }
    }

    class Racquet {
        private static final int WIDTH =10;
        private static final int HEIGHT = 80;
        private int x = 0, y = 0;
        private int x1Speed = 0, y1Speed = 0;
        private miniPingpongRandom game;
        private Color color;

        public Racquet(miniPingpongRandom game, int x, int y, Color color) {
            this.game = game;
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void move() { // 라켓 이동 메소드
            if( y + y1Speed > 0 && y + y1Speed < game.getHeight() - HEIGHT) y += y1Speed;
        }
        public void draw(Graphics2D g) {
            g.setColor(color);
            g.fillRect(x,y,WIDTH, HEIGHT);
        }

        public void keyReleased(KeyEvent e) {
            y1Speed = 0;
        }

        public void keyPressed1(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_W) y1Speed = -3;
            else if (e.getKeyCode() == KeyEvent.VK_S) y1Speed = 3;
          
        }
        public void keyPressed2(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) y1Speed = -3;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) y1Speed = 3;
          
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, WIDTH, HEIGHT);
        }
    }
    class ScoreBoard extends JPanel{
        private JTextArea scoreA, scoreB;
        public ScoreBoard() {
            this.setLayout(new GridLayout(1, 1));
            this.setSize(100,50);
            scoreA = new JTextArea(2,3);
            scoreA.setEditable(false);
            scoreA.setText("0");
            scoreA.setBackground(Color.BLACK);
            scoreB = new JTextArea(2,3);
            scoreB.setEditable(false);
            scoreB.setText("0");
            scoreB.setBackground(Color.BLACK);
            
            // 벽에 충돌했을 때 점수 추가 및 공 한가운데에서 시작
            // 벽에 충돌하는 기준을 공의 x좌표를 기준으로
            // 
            // if () {
                
            // }
            // else if () {
                
            // }
            this.add(scoreA);
            this.add(scoreB);
            setVisible(true);
        }
       
    }
    
}

