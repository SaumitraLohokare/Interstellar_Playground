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

public class World1Level2 extends Level{
	public World1Level2() {
		super();
		out = new Portal(700, 500);
		
		player = new Player((int) out.pos.x, (int) out.pos.y, 200, new Vec2(0, -100));
		
		in = new Portal(250, 500, player);
		
		planets = new ArrayList<>();
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 4000, 300, player, Assets.planet2));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 400, 300, player, Assets.planet2));
		
		//levelEditor = new LevelEditor(player, in, out, planets);
		
		stars[0] = new Stars(240, 425);
		stars[1] = new Stars(385,240);
		stars[2] = new Stars(595,220);
		
		
	}
}
