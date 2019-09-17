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

public class World1Level4 extends Level {

	public World1Level4() {
		super();

		out = new Portal(300, 300);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 150));

		in = new Portal(800, 300, player);

		planets = new ArrayList<>();
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 600, 150, player, Assets.planet1));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 500, 100, player, Assets.planet2));

		stars[0] = new Stars(535, 300);
		stars[1] = new Stars(665, 125);
		stars[2] = new Stars(400, 440);

		levelEditor = new LevelEditor(this);
	}

}
