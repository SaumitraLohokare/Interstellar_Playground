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

public class World1Level1 extends Level{
	public World1Level1() {
		super();

		out = new Portal(400, 500);

		player = new Player((int) out.pos.x, (int) out.pos.y, 200, new Vec2(0, -500));

		in = new Portal(50, 50, player);
		
		planets = new ArrayList<>();
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 200, 300, player, Assets.planet1));
		
		stars[0] = new Stars(325,160);
		stars[1] = new Stars(80,80);
		stars[2] = new Stars(395,410);

		
		levelEditor = new LevelEditor(this);		
	}
}
