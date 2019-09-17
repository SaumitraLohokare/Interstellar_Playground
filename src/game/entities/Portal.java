package game.entities;

import java.awt.Color;
import java.awt.Rectangle;

import engine.Assets;
import engine.Screen;
import engine.math.Collision;
import engine.math.Vec2;
import game.states.GameState;

public class Portal {

	public Vec2 pos;
	private Player target;
	//increase size
	private int width = 32, height = 32;
	private boolean isEnd = false;
	
	private double theta = 0;

	public Portal(int x, int y, Player target) {
		pos = new Vec2(x, y);
		this.isEnd = true;
		
		this.target = target;
	}
	
	public Portal(int x, int y) {
		pos = new Vec2(x, y);
		this.isEnd = false;
		
		this.target = null;
	}
	
	public void updateEditor(double dt) {
  		theta += dt * 2;
		
		if(target != null) {
			
			if(Collision.isColliding(getBoundingBox(), target.getBoundingBox())) {
				target.resetPos();
			}

			double dx = pos.x - target.getPos().x,
					dy = pos.y - target.getPos().y;
			
			target.setTheta(Math.atan2(dy, dx));
		}
	}
	
	public void update(double dt) {
		// TODO: can optimize here
		
		theta += dt * 2;
		
		if(target != null) {

			if(Collision.isColliding(getBoundingBox(), target.getBoundingBox())) {
				GameState.nextLevel();
			}
			
			double dx = pos.x - target.getPos().x,
					dy = pos.y - target.getPos().y;
			
			target.setTheta(Math.atan2(dy, dx));
		}
		
	}
	
	public void renderEditor() {
		Screen.fillRect((int)( pos.x - (width/2)), (int) (pos.y - (height/2)), width, height, new Color(10,200,100,100));
		Screen.drawImage(Assets.wormhole, (int)( pos.x - (width/2)), (int) (pos.y - (height/2)), width, height, theta);
	}
	
	public void render() {
		//Screen.fillRect((int)( pos.x - (width/2)), (int) (pos.y - (height/2)), width, height, new Color(10,200,100,100));
		Screen.drawImage(Assets.wormhole, (int)( pos.x - (width/2)), (int) (pos.y - (height/2)), width, height, theta);
	}
	
	public Rectangle getBoundingBox() {
		return new Rectangle((int)( pos.x - (width/2)), (int) (pos.y - (height/2)), width, height);
	}

}
