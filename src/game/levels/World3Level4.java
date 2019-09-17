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

public class World3Level4 extends Level{

	public World3Level4() {
		super();
		

		out = new Portal(35,125);
		player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(0, 100));

		in = new Portal(800, 600, player);
		
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),500,150,player));
		deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),500,150,player));
		
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 200,150,player,Assets.planet1, false));
		planets.add(new Planet(planetXPos, getNextPlanetPos(), 1000,150,player,Assets.planet2, false));

		debris.add(new Debris(85,90,player, Assets.debris));
		debris.add(new Debris(500,350,player, Assets.debris));
		debris.add(new Debris(1000,650,player, Assets.debris));
		debris.add(new Debris(60,650,player, Assets.debris));
		debris.add(new Debris(150,140,player, Assets.debris));
		debris.add(new Debris(220,185,player, Assets.debris));
		debris.add(new Debris(305,240,player, Assets.debris));
		debris.add(new Debris(390,295,player, Assets.debris));
		debris.add(new Debris(580,410,player, Assets.debris));
		debris.add(new Debris(670,470,player, Assets.debris));
		debris.add(new Debris(750,530,player, Assets.debris));
		debris.add(new Debris(830,585,player, Assets.debris));
		debris.add(new Debris(900,620,player, Assets.debris));
		debris.add(new Debris(210,535,player, Assets.debris));
		debris.add(new Debris(270,495,player, Assets.debris));
		debris.add(new Debris(350,455,player, Assets.debris));
		debris.add(new Debris(420,395,player, Assets.debris));
		debris.add(new Debris(600,300,player, Assets.debris));
		debris.add(new Debris(655,250,player, Assets.debris));
		debris.add(new Debris(724,195,player, Assets.debris));
		debris.add(new Debris(795,140,player, Assets.debris));
		debris.add(new Debris(925,65,player, Assets.debris));
		debris.add(new Debris(975,30,player, Assets.debris));
		debris.add(new Debris(135,590,player, Assets.debris));
		debris.add(new Debris(40,30,player, Assets.debris));
		debris.add(new Debris(870,110,player, Assets.debris));
		
		teleporters.add(new Teleporter(new Vec2(235, 475), new Vec2(165,55), player, Assets.teleportal));
		teleporters.add(new Teleporter(new Vec2(730,55), new Vec2(685,410), player, Assets.teleportal));
		teleporters.add(new Teleporter(new Vec2(970, 560), new Vec2(480, 430), player, Assets.teleportal));
		
		stars[0] = new Stars(490, 230);
		stars[1] = new Stars(870, 390);
		stars[2] = new Stars(605, 600);
		
		levelEditor = new LevelEditor(this);

	}
}
