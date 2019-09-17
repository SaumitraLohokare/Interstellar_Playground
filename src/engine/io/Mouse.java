package engine.io;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import engine.math.Vec2;

public class Mouse implements MouseListener, MouseMotionListener{
	
	private static Vec2 pos = new Vec2();
	
	private static boolean clicked = false;
	
	private static Rectangle mask = new Rectangle();

	//TODELETE
	public static boolean editBtn = false;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pos.x = e.getX();
		pos.y = e.getY();
		
		clicked = false;
		editBtn = false; //delete later
		
		mask.setBounds((int) pos.x, (int) pos.y, 1, 1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 1) {
			clicked = true;
		}
		//TO DELETE
		if(e.getButton() == 3) {
			editBtn = true;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	
	public static Vec2 getPos() {
		return pos;
	}
	
	public static boolean isClicked() {
		if(clicked) {
			clicked = false;
			return true;
		}
		
		return false;
	}
	
	public static Rectangle getBoundingBox() {
		return mask;
	}
	
	//TODELETE
	public static boolean isEditClicked() {
		if(editBtn) {
			editBtn = false;
			return true;
		}
		
		return false;
	}

}
