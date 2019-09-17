package game.entities;

import java.awt.Color;
import java.awt.Rectangle;

import engine.Assets;
import engine.Screen;
import engine.math.Vec2;

public class Stars {

	private Vec2 pos;
	private int width = 32, height = 32;
	private boolean collected = false;

	public Stars(int x, int y) {
		pos = new Vec2(x, y);
	}

	public void update(double dt) {

	}

	public void render() {
		if (!collected) {
			Screen.drawImage(Assets.star, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height);
		}
	}

	public Rectangle getBoundingBox() {
		return new Rectangle((int)(pos.x - (width / 2)), (int)( pos.y - (height / 2)), width, height);
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

}
