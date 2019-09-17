package game.entities;

import java.awt.Color;

import engine.ParticleManager;
import engine.Screen;

public class Particle {
	
	private int x , y, width, height;
	private double velX = 0, velY = 0, lifeTime = 0, finalLifeTime , alpha = 255;
	private Color c;
	
	public Particle(int x, int y, int width, int height, double velX, double velY, double lifeTime, Color c) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.velX = velX;
		this.velY = velY;
		
		this.lifeTime = lifeTime;
		this.finalLifeTime = lifeTime;
		
		this.c = c;
	}
	
	public void update(double dt) {
		lifeTime -= dt;
		
		alpha = (1 - (finalLifeTime - lifeTime)/ finalLifeTime) * 255;
		
		if(lifeTime <= 0) {
			ParticleManager.removeParticle(this);
		}
		
		x += velX * dt;
		y += velY * dt;
	}
	
	public void render() {
		Screen.fillRect((int)(x - width/2), (int)(y - height/2), width, height, new Color(c.getRed(), c.getGreen(), c.getBlue(), (int)alpha));
	}

}
