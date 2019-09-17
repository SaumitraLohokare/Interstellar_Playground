package game.levels;

import engine.Assets;
import engine.Level;
import engine.LevelEditor;
import engine.math.Vec2;
import game.entities.Debris;
import game.entities.Planet;
import game.entities.Player;
import game.entities.Portal;
import game.entities.Stars;
import game.entities.Teleporter;

public class World3Level1 extends Level{

	public World3Level1() {
		super();
		
		out = new Portal(100,300);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
		
		in = new Portal(900, 300, player);
		
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 750,300,player,Assets.planet1, false));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 200,250,player,Assets.planet2, false));
		
		debris.add(new Debris(425,300,player, Assets.debris));
		
		teleporters.add(new Teleporter(new Vec2(320, 560), new Vec2(625,115), player, Assets.teleportal));
		
		stars[0] = new Stars(853, 324);
		stars[1] = new Stars(630, 210);
		stars[2] = new Stars(200, 295);
		
		levelEditor = new LevelEditor(this);

	}
}
