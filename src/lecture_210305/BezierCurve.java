package lecture_210305;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener{
	
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	
	private int dragIndex = -1;
	
	class BezierPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			/*  xs배열, ys 배열의 좌표를 이용해서 베지어 곡선을 그린다 */
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub 네개의 점 중에서 어떤 점이 선택되었는지를 체크
		dragIndex = 0;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub 
		dragIndex = -1;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub 선택된 점이 있는지 보고, 즉 드래그 인덱스가 -1이 아닌지 보고 아니라면 선택된 점의 좌표를 변경
		dragIndex = -1;
		repaint();

	}
//
//	@Override
//	public void mouseMoved(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
	
}

