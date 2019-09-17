package game.levels;

import engine.Assets;
import engine.Level;
import engine.LevelEditor;
import engine.math.Vec2;
import game.entities.Deflector;
import game.entities.Planet;
import game.entities.Player;
import game.entities.Portal;
import game.entities.Stars;

public class World2Level2 extends Level {
	
	public World2Level2() {
		super();
		
		out = new Portal(100,300);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
		
		in = new Portal(700, 300, player);
		
		deflectors.add(new Deflector(planetXPos, getNextPlanetPos(),750,200,player));
		
		planets.add(new Planet(200,400,750,200,player,Assets.planet1, true));
		
		in = new Portal(800, 300, player);
		
		stars[0] = new Stars(225, 300);
		stars[1] = new Stars(420, 300);
		stars[2] = new Stars(575, 300);
		
		levelEditor = new LevelEditor(this);
	}

}
