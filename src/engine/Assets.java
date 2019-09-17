package engine;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Assets {
	
	//ASSETS
	public static BufferedImage ship, wormhole, sat1, sat2, sat3, debris, teleportal, lock;
	public static BufferedImage planet1, planet2, planet3, planet4, planet5, star;
	
	public static BufferedImage w1, w2, w3, l1, l2, l3, l4, edit, save, play, quit, back;
	
	public static BufferedImage title, starryNight, credits;
	
	//LOADING ASSETS
	public Assets() {
		ship = loadImage("ship");
		
		planet1 = loadImage("Planet1");
		planet2 = loadImage("Planet2");
		planet3 = loadImage("Planet3");
		planet4 = loadImage("Planet4");
		planet5 = loadImage("Planet5");
		
		wormhole = loadImage("Wormhole");
		
		star = loadImage("Star");
		
		sat1 = loadImage("sat1");
		sat2 = loadImage("sat2");
		sat3 = loadImage("sat3");
		
		debris = loadImage("debris");
		
		teleportal = loadImage("teleportal");
		
		lock = loadImage("lock");
		
		w1 = loadImage("World1Btn");
		w2 = loadImage("World2Btn");
		w3 = loadImage("World3Btn");
		
		l1 = loadImage("Level1Btn");
		l2 = loadImage("Level2Btn");
		l3 = loadImage("Level3Btn");
		l4 = loadImage("Level4Btn");
		
		edit = loadImage("EditBtn");
		save = loadImage("SaveBtn");
		
		play = loadImage("PlayBtn");
		quit = loadImage("CloseBtn");	
		
		back = loadImage("BackBtn");
		
		title = loadImage("Title");
		starryNight = loadImage("StarryNight");
		credits = loadImage("credits");
	}

	
	public BufferedImage loadImage(String filePath) {
		try {
			return ImageIO.read(Assets.class.getResource("/imgs/"+filePath+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
