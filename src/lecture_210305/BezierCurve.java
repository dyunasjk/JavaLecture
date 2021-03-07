package lecture_210305;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

// warning!! if play this file, need to resizable JFrame!
public class BezierCurve extends JFrame implements MouseListener,MouseMotionListener{

	   private int[] xs= {50,150,400,450};
	   private int[] ys= {200,50,300,200};
	   
	   private int dragIndex = -1;
	   
	   private BezierPanel drawPanel;
	   
	   public BezierCurve() {
		   setSize(800,500);
		   setVisible(true);
		   setTitle("Bezier curve");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   drawPanel = new BezierPanel();
		   drawPanel.addMouseListener(this);
		   drawPanel.addMouseMotionListener(this);
		   this.add(drawPanel,BorderLayout.CENTER);
		}
	   
	   
	   class BezierPanel extends JPanel{
		   
	      @Override
	      public void paintComponent(Graphics g) {
	         //xs ,ys 배열 이용해서 베지어곡선 그리기
	    	  g.setColor(Color.blue);
	    	  g.fillRect(xs[0], ys[0], 16, 16);
	    	  g.fillRect(xs[2], ys[2], 16, 16);
	    	  g.setColor(Color.red);
	    	  g.fillRect(xs[1], ys[1], 16, 16);
	    	  g.fillRect(xs[3], ys[3], 16, 16);	 
	    	  
	    	  Graphics2D g2d = (Graphics2D) g;
	    	  g2d.setColor(Color.black);
	    	  GeneralPath path = new GeneralPath();
	    	  path.moveTo(xs[0], ys[0]);
	    	  path.curveTo(xs[2], ys[2], xs[3], ys[3], xs[1], ys[1]);
	    	  g2d.draw(path);  
	    	  path.moveTo(xs[2], ys[2]);
	    	  path.curveTo(xs[1], ys[1], xs[0], ys[0], xs[3], ys[3]);
	    	  g2d.draw(path);  
	    	  
	    	
	      }
	   }  
	   
	   @Override
	   public void mouseDragged(MouseEvent e) {
	      //dragindex -1 여부판단 후 선택된점 의 위치를 바꿈
	      if(dragIndex!=-1) {
	    	  xs[dragIndex]=e.getX();
    	  	  ys[dragIndex]=e.getY();
    		  repaint();
	      }
	   }

	   @Override
	   public void mouseReleased(MouseEvent e) {
	      dragIndex=-1;
	      repaint();
	   }

	   @Override
	   public void mousePressed(MouseEvent e) {
	      // 4개점 선택 할거 체크
	      dragIndex = -1;// 1,2,3,4
	      for (int i = 0; i < 4; i++) {
	    	  Rectangle r = new Rectangle(xs[i]-4,ys[i]-4,20,20);
	    	  if(r.contains(e.getX(),e.getY())) {
	    		  dragIndex = i;
	    	  }
	      }
	      repaint();
	   }
	   
	   
	   @Override
	   public void mouseClicked(MouseEvent e) {}
	   @Override
	   public void mouseMoved(MouseEvent e) {}
	   @Override
	   public void mouseEntered(MouseEvent e) {}
	   @Override
	   public void mouseExited(MouseEvent e) {}

	   
	   
	   public static void main(String[] args) {
		   new BezierCurve();
	   }
}