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

public class World3Level2 extends Level{

	public World3Level2() {
		super();
		
		out = new Portal(600,600);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
		
		in = new Portal(70, 75, player);
		
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player));
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player));
		
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 200,150,player,Assets.planet1, false));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 200,150,player,Assets.planet1, false));
		
		debris.add(new Debris(550,50,player, Assets.debris));
		debris.add(new Debris(550,100,player, Assets.debris));
		debris.add(new Debris(550,150,player, Assets.debris));
		debris.add(new Debris(550,200,player, Assets.debris));
		debris.add(new Debris(550,250,player, Assets.debris));
		debris.add(new Debris(550,300,player, Assets.debris));
		debris.add(new Debris(550,350,player, Assets.debris));
		debris.add(new Debris(550,400,player, Assets.debris));
		debris.add(new Debris(550,450,player, Assets.debris));
		debris.add(new Debris(550,500,player, Assets.debris));
		debris.add(new Debris(550,550,player, Assets.debris));
		debris.add(new Debris(550,600,player, Assets.debris));
		debris.add(new Debris(550,650,player, Assets.debris));
		debris.add(new Debris(550,700,player, Assets.debris));
		debris.add(new Debris(550,750,player, Assets.debris));
		debris.add(new Debris(550,800,player, Assets.debris));
		debris.add(new Debris(550,850,player, Assets.debris));
		
		teleporters.add(new Teleporter(new Vec2(1000, 80), new Vec2(400,600), player, Assets.teleportal));
		
		stars[0] = new Stars(790, 555);
		stars[1] = new Stars(450, 430);
		stars[2] = new Stars(140, 150);
		
		levelEditor = new LevelEditor(this);

	}
}
