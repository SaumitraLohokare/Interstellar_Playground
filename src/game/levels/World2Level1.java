package game.levels;

import engine.Level;
import engine.LevelEditor;
import engine.math.Vec2;
import game.entities.Deflector;
import game.entities.Player;
import game.entities.Portal;
import game.entities.Stars;

public class World2Level1 extends Level {
	
	public World2Level1() {
		super();
		
		out = new Portal(250,500);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(0, -100));
		
		in = new Portal(700, 500, player);
		
		deflectors.add(new Deflector(planetXPos, getNextPlanetPos(),100,200,player));
		deflectors.add(new Deflector(planetXPos, getNextPlanetPos(),100,200,player));
		
		stars[0] = new Stars(250, 240);
		stars[1] = new Stars(420, 195);
		stars[2] = new Stars(650, 365);
		
		levelEditor = new LevelEditor(this);
		
	}

}
