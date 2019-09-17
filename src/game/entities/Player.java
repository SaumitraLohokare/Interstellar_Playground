package game.entities;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import engine.Assets;
import engine.Game;
import engine.ParticleManager;
import engine.Screen;
import engine.math.Vec2;

public class Player {

	public Vec2 acc, vel, pos, startPos, startVel;

	private int width = 32, height = 32, maxVel = 250;

	public int mass;

	private double theta = 0;

	private BufferedImage img;

	private boolean isInField = false;

	private double particleSpawnerTime = 0, resetTimer = 0;
	private final double spawnDelay = 0.1d, resetDelay = 0.5d;

	public Player(int x, int y, int mass, Vec2 initialVel) {

		this.mass = mass;

		acc = new Vec2();
		vel = new Vec2(initialVel.x, initialVel.y);
		pos = new Vec2(x, y);
		startPos = new Vec2(pos.x, pos.y);
		startVel = new Vec2(initialVel.x, initialVel.y);

		img = Assets.ship;
	}

	public void resetPos() {

		pos.x = startPos.x;
		pos.y = startPos.y;

		vel.x = startVel.x;
		vel.y = startVel.y;

		setAcc(new Vec2());
	}

	public void resetPosWithDelay() {
		resetTimer = resetDelay;

		pos.x = startPos.x;
		pos.y = startPos.y;

		vel.x = startVel.x;
		vel.y = startVel.y;

		setAcc(new Vec2());
	}

	public void updateEditor(double dt) {
		particleSpawnerTime += dt;

		if (particleSpawnerTime >= spawnDelay) {

			ParticleManager.addParticle(new Particle((int) pos.x, (int) pos.y, 5, 5, 0, 0, 1, Color.red));

			particleSpawnerTime = 0;
		}

		vel.x += acc.x * dt;
		vel.y += acc.y * dt;

		if (vel.magnitudeSqr() > Math.pow(maxVel, 2)) {
			vel.x *= ((float) (maxVel / Math.sqrt(vel.magnitudeSqr())));
			vel.y *= ((float) (maxVel / Math.sqrt(vel.magnitudeSqr())));
		}

		pos.x += vel.x * dt;
		pos.y += vel.y * dt;

		if (pos.x < 0 || pos.x > Game.WIDTH || pos.y < 0 || pos.y > Game.HEIGHT) {
			resetPos();
		}
	}

	public void update(double dt) {
		if (resetTimer <= 0) {
			particleSpawnerTime += dt;

			if (particleSpawnerTime >= spawnDelay) {

				ParticleManager.addParticle(new Particle((int) pos.x, (int) pos.y, 5, 5, 0, 0, 1, Color.red));

				particleSpawnerTime = 0;
			}

			vel = vel.add(acc.scalarMultiply((float) dt));

			if (vel.magnitudeSqr() > Math.pow(maxVel, 2)) {
				vel = vel.scalarMultiply((float) (maxVel / Math.sqrt(vel.magnitudeSqr())));
			}

			pos = pos.add(vel.scalarMultiply((float) dt));

			if (pos.x < 0 || pos.x > Game.WIDTH || pos.y < 0 || pos.y > Game.HEIGHT) {
				resetPos();
			}
		} else {
			resetTimer -= dt;
		}
	}
	
	public void updateMenu(double dt) {
		if (resetTimer <= 0) {
			particleSpawnerTime += dt;

			if (particleSpawnerTime >= spawnDelay) {

				ParticleManager.addParticle(new Particle((int) pos.x, (int) pos.y, 5, 5, 0, 0, 1, Color.red));

				particleSpawnerTime = 0;
			}

			vel = vel.add(acc.scalarMultiply((float) dt));

			if (vel.magnitudeSqr() > Math.pow(maxVel, 2)) {
				vel = vel.scalarMultiply((float) (maxVel / Math.sqrt(vel.magnitudeSqr())));
			}

			pos = pos.add(vel.scalarMultiply((float) dt));

			
		} else {
			resetTimer -= dt;
		}
	}

	public void render() {
		// Screen.fillRect((int) pos.x - (width/2), (int) pos.y - (height/2), width,
		// height, new Color(100, 50, 20));
		Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height, theta);
	}

	public void renderEditor() {
		Screen.drawImage(img, (int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height, theta);
		Screen.fillRect((int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height,
				new Color(255, 255, 255, 100));
	}

	public Rectangle getBoundingBox() {
		return new Rectangle((int) pos.x - (width / 2), (int) pos.y - (height / 2), width, height);
	}

	public Vec2 getAcc() {
		return acc;
	}

	public void setAcc(Vec2 a) {
		this.acc = a;
	}

	public void addAcc(Vec2 a) {
		this.acc = this.acc.add(a);
	}

	public Vec2 getPos() {
		return pos;
	}

	public Vec2 getVel() {
		return vel;
	}

	public void setVel(Vec2 vel) {
		this.vel = vel;
	}

	public int getMaxVel() {
		return maxVel;
	}

	public void setMaxVel(int maxVel) {
		this.maxVel = maxVel;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public boolean isInField() {
		return isInField;
	}

	public void setInField(boolean isInField) {
		this.isInField = isInField;
	}

	public void setPos(Vec2 pos) {
		this.pos.x = pos.x;
		this.pos.y = pos.y;
	}

}
