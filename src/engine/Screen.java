package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Screen extends Canvas {
	
	private BufferStrategy bs;
	private static Graphics2D g;
	
	public Screen() {
		this.setSize(Game.WIDTH, Game.HEIGHT);
	}
	
	public void init() {
		if(this.getBufferStrategy() == null) {
			this.createBufferStrategy(2);
		}
	}
	
	public void start() {
		bs = this.getBufferStrategy();
		g = (Graphics2D)bs.getDrawGraphics();
		
		g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(new Color(0x44314F));
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(null);
	}
	
	public void display() {
		bs.show();
		g.dispose();
	}
	
	//TODO: add methods to draw stuff
	
	public static void fillOval(int x, int y, int radius, Color c) {
		g.setColor(c);
		g.fillOval(x - (radius) + 16, y - (radius) + 16, radius*2, radius*2);
		g.setColor(null);
	}
	
	public static void fillRect(int x, int y, int width, int height, Color c) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
		g.setColor(null);
	}
	
	public static void drawImage(BufferedImage img, int x, int y, int width, int height) {
		g.drawImage(img, x, y, width, height, null);
	}
	
	public static void drawImage(BufferedImage img, int x, int y, int width, int height, Color c) {
		
		g.drawImage(img, x, y, width, height,c, null);
		
	}
	
	public static void drawImage(BufferedImage img, int x, int y, int width, int height, double theta) {
		g.rotate(theta, x + (width/2), y + (height/2));
		g.drawImage(img, x, y, width, height, null);
		g.rotate(-theta, x + (width/2), y + (height/2));
	}
	
	public static void drawImage(BufferedImage img, int x, int y, int width, int height, double theta, Color c) {
		g.rotate(theta, x + (width/2), y + (height/2));
		g.drawImage(img, x, y, width, height,c, null);
		g.rotate(-theta, x + (width/2), y + (height/2));
	}

}
