package game.entities;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import engine.Assets;
import engine.Screen;
import engine.io.Mouse;
import engine.math.Collision;
import engine.math.Vec2;

public class Planet {

	private Vec2 pos;
	private int mass, zoneRadius, width = 32, height = 32;
	private Player target;

	private BufferedImage img;

	// EDITOR
	private boolean selected = false, placed = false;

	private boolean locked = false;

	public Planet(int x, int y, int mass, int zoneRadius, Player target, BufferedImage img) {
		this.mass = mass;
		this.zoneRadius = zoneRadius;
		this.target = target;

		pos = new Vec2(x, y);

		this.img = img;

		locked = false;
	}

	public Planet(int x, int y, int mass, int zoneRadius, Player target, BufferedImage img, boolean isLocked) {
		this.mass = mass;
		this.zoneRadius = zoneRadius;
		this.target = target;

		pos = new Vec2(x, y);

		this.img = img;

		locked = isLocked;
	}

	public void updateEditor(double dt) {

		if (selected || placed || locked) {
			if (Vec2.distSqr(pos, target.getPos()) <= zoneRadius * zoneRadius) {
				target.setInField(true);

				Vec2 temp = pos.add(target.getPos().scalarMultiply(-1f));
				target.addAcc(temp.scalarMultiply((float) ((mass * target.mass)
						/ (Vec2.distSqr(pos, target.getPos()) * Math.sqrt(temp.magnitudeSqr())))));
			}
			if (Collision.isColliding(getBoundingBox(), target.getBoundingBox())) {
				// System.out.println("Crashed");
				// Add Delay
				target.resetPos();
			}
		}

		if (locked) {
			return;
		}

		if (selected) {
			pos.x = Mouse.getPos().x;
			pos.y = Mouse.getPos().y;

			if (Mouse.isClicked()) {
				selected = false;
				placed = true;
			}
		} else {
			if (Collision.isColliding(getBoundingBox(), Mouse.getBoundingBox()) && Mouse.isClicked()) {
				selected = true;
			}
		}

	}

	public void update(double dt) {

		if (placed || locked) {
			if (Vec2.distSqr(pos, target.getPos()) <= zoneRadius * zoneRadius) {
				target.setInField(true);
				Vec2 temp = pos.add(target.getPos().scalarMultiply(-1f));
				target.addAcc(temp.scalarMultiply((float) ((mass * target.mass)
						/ (Vec2.distSqr(pos, target.getPos()) * Math.sqrt(temp.magnitudeSqr())))));
			}
		}
		if (Collision.isColliding(getBoundingBox(), target.getBoundingBox())) {
			// Add Delay
			target.resetPosWithDelay();
		}
	}

	public void renderEditor() {

		if (!selected) {
			// Screen.fillRect((int) pos.x - (width/2), (int) pos.y - (height/2), width,
			// height, new Color(200, 180, 20));
			Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height);
		} else {
			Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height,
					new Color(200, 180, 20, 100));
		}

		if (locked) {
			Screen.drawImage(Assets.lock, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height);
		}

		Color zoneC;

		if (mass < 100) {
			zoneC = new Color(200, 200, 200, 50);
		} else if (mass < 200) {
			zoneC = new Color(200, 150, 150, 50);
		} else if (mass < 300) {
			zoneC = new Color(200, 100, 100, 50);
		} else if (mass < 400) {
			zoneC = new Color(200, 50, 50, 50);
		} else if (mass < 500) {
			zoneC = new Color(200, 0, 0, 50);
		} else {
			zoneC = new Color(255, 0, 0, 50);
		}

		Screen.fillOval((int) pos.x - (width / 2), (int) pos.y - (height / 2), zoneRadius, zoneC);

	}

	public void render() {

		if (placed || locked) {
			Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height);
		}
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
