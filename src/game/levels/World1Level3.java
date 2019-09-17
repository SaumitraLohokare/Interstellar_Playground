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

public class World1Level3 extends Level {

	public World1Level3() {
		super();

		out = new Portal(500, 300);

		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, -100));

		in = new Portal(200, 400, player);

		planets = new ArrayList<>();
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 500, 150, player, Assets.planet1));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 750, 100, player, Assets.planet2));

		stars[0] = new Stars(660, 210);
		stars[1] = new Stars(180, 445);
		stars[2] = new Stars(440, 515);

		levelEditor = new LevelEditor(this);
	}

}
