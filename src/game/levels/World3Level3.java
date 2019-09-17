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
import game.entities.Teleporter;

public class World3Level3 extends Level{

	public World3Level3() {
		super();
		
		out = new Portal(100,150);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
		
		in = new Portal(700, 500, player);
		
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player));
		
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 750,400,player,Assets.planet1, false));
		
		debris.add(new Debris(950,350,player, Assets.debris));
		debris.add(new Debris(850,350,player, Assets.debris));
		debris.add(new Debris(750,350,player, Assets.debris));
		debris.add(new Debris(650,350,player, Assets.debris));
		debris.add(new Debris(550,350,player, Assets.debris));
		debris.add(new Debris(450,350,player, Assets.debris));
		debris.add(new Debris(350,350,player, Assets.debris));
		debris.add(new Debris(250,350,player, Assets.debris));
		debris.add(new Debris(150,350,player, Assets.debris));
		debris.add(new Debris(50,350,player, Assets.debris));
		
		teleporters.add(new Teleporter(new Vec2(300, 50), new Vec2(600,100), player, Assets.teleportal));
		teleporters.add(new Teleporter(new Vec2(300, 200), new Vec2(300,500), player, Assets.teleportal));
		
		stars[0] = new Stars(235, 130);
		stars[1] = new Stars(650, 510);
		stars[2] = new Stars(415, 505);
		
		levelEditor = new LevelEditor(this);

	}
}
