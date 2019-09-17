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

public class World2Level4 extends Level {
	
	public World2Level4() {
		super();
		
		out = new Portal(100,100);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(75, 75));
		
		in = new Portal(900, 500, player);
		
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player));
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200, 150,player));
		
		planets.add(new Planet(planetXPos,getNextPlanetPos(), 200,150,player,Assets.planet1, false));
		planets.add(new Planet(450,250, 200,250,player,Assets.planet4, true));
		
		debris.add(new Debris(435,455,player, Assets.planet5));
		debris.add(new Debris(375,200,player, Assets.planet5));
		debris.add(new Debris(720,405,player, Assets.planet5));
		debris.add(new Debris(90,560,player, Assets.planet5));
		
		stars[0] = new Stars(385, 525);
		stars[1] = new Stars(650, 530);
		stars[2] = new Stars(235, 245);
		
		levelEditor = new LevelEditor(this);
	}

}