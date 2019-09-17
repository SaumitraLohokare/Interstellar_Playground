package game.levels;

import java.util.ArrayList;

import engine.Assets;
import engine.Level;
import engine.LevelEditor;
import engine.math.Vec2;
import game.entities.Planet;
import game.entities.Player;
import game.entities.Portal;
import game.entities.Stars;

public class World1Level5 extends Level{

	public World1Level5() {
		super();
		
		out = new Portal(100, 300);
		player = new Player((int) out.pos.x, (int) out.pos.y, 300, new Vec2(0, 100));
		
		in = new Portal(300, 300, player);
		
		planets = new ArrayList<>();
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 400, 200, player, Assets.planet1));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 650, 125, player, Assets.planet4));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 100, 200, player, Assets.planet2));
		
		
		stars[0] = new Stars(675, 195);
		stars[1] = new Stars(280, 240);
		stars[2] = new Stars(165, 540);
		
		levelEditor = new LevelEditor(this);		
	}
	
}
