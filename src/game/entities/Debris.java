package game.entities;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import engine.Screen;
import engine.io.Mouse;
import engine.math.Collision;
import engine.math.Vec2;

public class Debris {

	private Vec2 pos;
	private int width = 32, height = 32;
	private Player target;
	private double theta = 0;
	private BufferedImage img;

	// EDITOR
	private boolean selected = false;

	public Debris(int x, int y, Player target, BufferedImage img) {
		this.target = target;
		theta = Math.random() * Math.PI;
		pos = new Vec2(x, y);

		this.img = img;
	}

	public void updateEditor(double dt) {
		
		if (Collision.isColliding(getBoundingBox(), target.getBoundingBox())) {
			//Add delay
			target.resetPos();
		}

	}

	public void update(double dt) {
		if (Collision.isColliding(getBoundingBox(), target.getBoundingBox())) {
			//Add delay
			target.resetPosWithDelay();
		}
	}

	public void renderEditor() {

		if (!selected) {
			Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height, theta);
		} else {
			Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height, theta, 
					new Color(200, 180, 20, 100));
		}

	}

	public void render() {
		Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height, theta);

	}

	public Rectangle getBoundingBox() {
		return new Rectangle((int) (pos.x - (width / 2)), (int) (pos.y - (height / 2)), width, height);
	}

	public Vec2 getPos() {
		return pos;
	}

	public void setPos(Vec2 pos) {
		this.pos = pos;
	}

}
