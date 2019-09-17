package engine.ui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import engine.Screen;
import engine.io.Mouse;
import engine.math.Collision;
import engine.math.Vec2;

public class Button {

	private Vec2 pos;
	private int width, height;
	private Color color;

	private ButtonAction action;

	private BufferedImage img = null;

	public Button(int x, int y, int width, int height, String s, Color color, ButtonAction action) {
		pos = new Vec2(x, y);
		this.width = width;
		this.height = height;
		this.color = color;

		this.action = action;
	}

	public Button(int x, int y, int width, int height, String s, BufferedImage img, ButtonAction action) {
		pos = new Vec2(x, y);
		this.width = width;
		this.height = height;
		this.img = img;

		this.action = action;
	}

	public void update(double dt) {

		if (Collision.isColliding(getBoundingBox(), Mouse.getBoundingBox()) && Mouse.isClicked()) {
			action.action();
		}
	}

	public void render() {
		if (img == null) {
			Screen.fillRect((int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height, color);
		} else {
			Screen.drawImage(img,(int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height);
		}
	}

	public Rectangle getBoundingBox() {
		return new Rectangle((int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height);
	}

}
