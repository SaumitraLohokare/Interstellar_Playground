package game.levels;

import engine.Assets;
import engine.Level;
import engine.LevelEditor;
import engine.math.Vec2;
import game.entities.Debris;
import game.entities.Deflector;
import game.entities.Planet;
import game.entities.Player;
import game.entities.Portal;
import game.entities.Stars;

public class World2Level3 extends Level {
	
	public World2Level3() {
		super();
		
		out = new Portal(100,300);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(0, -100));
		
		in = new Portal(900, 450, player);
		
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),400,200,player));
		
		planets.add(new Planet(planetXPos,getNextPlanetPos(), 300,200,player,Assets.planet1, false));
		planets.add(new Planet(planetXPos,getNextPlanetPos(), 500,200,player,Assets.planet4, false));
		
		debris.add(new Debris(160,270,player, Assets.planet5));
		debris.add(new Debris(835,370,player, Assets.planet5));
		debris.add(new Debris(285,435,player, Assets.planet5));
		debris.add(new Debris(555,290,player, Assets.planet5));
		
		stars[0] = new Stars(280, 220);
		stars[1] = new Stars(460, 450);
		stars[2] = new Stars(875, 480);
		
		levelEditor = new LevelEditor(this);
	}

}