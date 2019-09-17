package game.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import engine.Screen;
import engine.math.Collision;
import engine.math.Vec2;

public class Teleporter {

	private Vec2 pos1, pos2;
	private int width = 64, height = 64;
	private BufferedImage img;

	private Player target;

	private double theta = 0, timer = 0;
	private final double timerReset = 1.5d;
	private boolean canTeleport = true;

	public Teleporter(Vec2 pos1, Vec2 pos2, Player target, BufferedImage img) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.target = target;
		this.img = img;
	}

	public void update(double dt) {
		theta -= dt * 0.5;
		
		if(!canTeleport) {
			if(timer <= timerReset) {
				timer += dt;
				return;
			} else {
				timer = 0;
				canTeleport = true;
			}
		}
		
		if(Collision.isColliding(getBoundingBox1(), target.getBoundingBox()) && canTeleport) {
			target.setPos(pos2);
			canTeleport = false;
			target.setAcc(new Vec2());
		}
		
		if(Collision.isColliding(getBoundingBox2(), target.getBoundingBox()) && canTeleport) {
			target.setPos(pos1);
			canTeleport = false;
			target.setAcc(new Vec2());
			System.out.println("Teleported back");
		}
		
	}

	public void render() {
		Screen.drawImage(img, (int) (pos1.x - width / 2), (int) (pos1.y - height / 2), width, height, theta);
		Screen.drawImage(img, (int) (pos2.x - width / 2), (int) (pos2.y - height / 2), width, height, theta);
	}

	public Rectangle getBoundingBox1() {
		return new Rectangle((int) (pos1.x - width / 2), (int) (pos1.y - height / 2), width, height);
	}
	
	public Rectangle getBoundingBox2() {
		return new Rectangle((int) (pos2.x - width / 2), (int) (pos2.y - height / 2), width, height);
	}

}
