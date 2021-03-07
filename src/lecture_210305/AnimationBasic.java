package lecture_210305; // 마름모방향 회전 깃헙

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class AnimationBasic extends JPanel implements ActionListener{

   private final int WIDTH = 500, HEIGHT=300;
   private BufferedImage image;
   private Timer timer;
   private int x,y;
   private final int START_X=0,START_Y=250;
   
   public AnimationBasic() {
      //Image파일 읽어서 image객체로 생성
      //20ms마다 이벤트 발생 timer객체 생성 timer start 시킴
      File file=new File("ship.jpg");
      try {
         image = ImageIO.read(file);
      }
      catch(IOException e)
      {
         e.printStackTrace();
         System.exit(1);
      }
      x=START_X;
      y=START_Y;
      
      timer = new Timer(5,this);
      timer.start();
   }
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      //x,y좌표에 이미지를 그린다.
      g.drawImage(image,x,y,this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // x,y좌표 변경
      x += 1;
      y -= 1;
      int getX, getY;
      
      if(x < HEIGHT) {
        
         x += 1;
         y += 1;
         
      } else if (x > WIDTH) {
    	  
    	  x -= 1;
    	  y += 1;
    	  
      } else if (y > HEIGHT) {
    	  
    	  x -= 1;
    	  y -= 1;
    	  
      } else if (x < WIDTH) {
    	  
    	  x +=1;
    	  y -=1;
      }
      repaint();
      
   }
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.add(new AnimationBasic());
      frame.setTitle("애니메이션 테스트");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500,300);
      frame.setVisible(true);
      
   }
   

}