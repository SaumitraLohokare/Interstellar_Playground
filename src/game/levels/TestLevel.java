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

public class TestLevel extends Level {

	public TestLevel() {
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
//World1Level2
//out = new Portal(700, 500);
//
//player = new Player((int) out.pos.x, (int) out.pos.y, 10, new Vec2(0, -100));
//
//in = new Portal(250, 500, player);
//
//planets = new ArrayList<>();
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 10, 300, player));
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 10, 300, player));
//
//levelEditor = new LevelEditor(player, in, out, planets);
//
//stars[0] = new Stars(240, 425);
//stars[1] = new Stars(385,240);
//stars[2] = new Stars(595,220);

//World1Level3
//out = new Portal(500, 300);
//
//player = new Player((int) out.pos.x, (int) out.pos.y, 10, new Vec2(100, -100));
//
//in = new Portal(200, 400, player);
//
//planets = new ArrayList<>();
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 50, 150, player, Assets.planet1));
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 50, 100, player, Assets.planet3));
//
//levelEditor = new LevelEditor(player, in, out, planets);
//
//stars[0] = new Stars(660, 210);
//stars[1] = new Stars(180, 445);
//stars[2] = new Stars(440, 515);

//World1Level4
//out = new Portal(300, 300);
//player = new Player((int) out.pos.x, (int) out.pos.y, 10, new Vec2(100, 150));
//
//in = new Portal(800, 300, player);
//
//planets = new ArrayList<>();
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 100, 150, player, Assets.planet1));
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 30, 100, player, Assets.planet3));
//
//levelEditor = new LevelEditor(player, in, out, planets);
//
//stars[0] = new Stars(535, 300);
//stars[1] = new Stars(665, 125);
//stars[2] = new Stars(400, 440);

//World1Level5
//out = new Portal(100, 300);
//player = new Player((int) out.pos.x, (int) out.pos.y, 10, new Vec2(0, 100));
//
//in = new Portal(300, 300, player);
//
//planets = new ArrayList<>();
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 40, 200, player, Assets.planet1));
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 65, 125, player, Assets.planet3));
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 10, 200, player, Assets.planet2));
//
//levelEditor = new LevelEditor(player, in, out, planets);
//
//stars[0] = new Stars(675, 195);
//stars[1] = new Stars(280, 240);
//stars[2] = new Stars(165, 540);

//World2Level1
//out = new Portal(250,500);
//player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(0, -100));
//
//in = new Portal(700, 500, player);
//
//deflectors.add(new Deflector(100,100,100,200,player,Assets.planet2));
//deflectors.add(new Deflector(100,100,100,200,player,Assets.planet2));
//
//stars[0] = new Stars(250, 240);
//stars[1] = new Stars(420, 195);
//stars[2] = new Stars(650, 365);
//
//levelEditor = new LevelEditor(this);

//World2Level2
//out = new Portal(100,300);
//player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
//
//in = new Portal(700, 300, player);
//
//deflectors.add(new Deflector(100,100,750,1000,player,Assets.planet2));
//
//planets.add(new Planet(200,400,750,1000,player,Assets.planet1, true));
//
//stars[0] = new Stars(225, 240);
//stars[1] = new Stars(420, 195);
//stars[2] = new Stars(650, 365);
//
//levelEditor = new LevelEditor(this);

//World2Level3
//out = new Portal(100,300);
//player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(0, -100));
//
//in = new Portal(900, 450, player);
//
//deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),400,200,player,Assets.planet2));
//
//planets.add(new Planet(planetXPos,getNextPlanetPos(), 300,200,player,Assets.planet1, false));
//planets.add(new Planet(planetXPos,getNextPlanetPos(), 500,200,player,Assets.planet3, false));
//
//debris.add(new Debris(150,270,player, Assets.planet5));
//debris.add(new Debris(835,370,player, Assets.planet5));
//debris.add(new Debris(285,435,player, Assets.planet5));
//debris.add(new Debris(555,290,player, Assets.planet5));
//
//stars[0] = new Stars(280, 220);
//stars[1] = new Stars(460, 450);
//stars[2] = new Stars(875, 480);
//
//levelEditor = new LevelEditor(this);

//World2Level4
//out = new Portal(100,100);
//player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(75, 75));
//
//in = new Portal(900, 500, player);
//
//deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player,Assets.planet2));
//deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200, 150,player,Assets.planet2));
//
//planets.add(new Planet(planetXPos,getNextPlanetPos(), 200,150,player,Assets.planet1, false));
//planets.add(new Planet(450,250, 200,250,player,Assets.planet4, true));
//
//debris.add(new Debris(435,455,player, Assets.planet5));
//debris.add(new Debris(375,200,player, Assets.planet5));
//debris.add(new Debris(720,405,player, Assets.planet5));
//debris.add(new Debris(90,560,player, Assets.planet5));
//
//stars[0] = new Stars(385, 525);
//stars[1] = new Stars(650, 530);
//stars[2] = new Stars(235, 245);
//
//levelEditor = new LevelEditor(this);

//World3Level1
//out = new Portal(100,300);
//player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
//
//in = new Portal(900, 300, player);
//
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 750,300,player,Assets.planet1, false));
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 200,250,player,Assets.planet2, false));
//
//debris.add(new Debris(425,300,player, Assets.debris));
//
//teleporters.add(new Teleporter(new Vec2(320, 560), new Vec2(625,115), player, Assets.teleportal));
//
//stars[0] = new Stars(853, 324);
//stars[1] = new Stars(630, 210);
//stars[2] = new Stars(200, 295);
//
//levelEditor = new LevelEditor(this);

//World3Level2
//out = new Portal(600,600);
//player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
//
//in = new Portal(70, 75, player);
//
//deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player));
//deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player));
//
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 200,150,player,Assets.planet1, false));
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 200,150,player,Assets.planet1, false));
//
//debris.add(new Debris(550,50,player, Assets.debris));
//debris.add(new Debris(550,100,player, Assets.debris));
//debris.add(new Debris(550,150,player, Assets.debris));
//debris.add(new Debris(550,200,player, Assets.debris));
//debris.add(new Debris(550,250,player, Assets.debris));
//debris.add(new Debris(550,300,player, Assets.debris));
//debris.add(new Debris(550,350,player, Assets.debris));
//debris.add(new Debris(550,400,player, Assets.debris));
//debris.add(new Debris(550,450,player, Assets.debris));
//debris.add(new Debris(550,500,player, Assets.debris));
//debris.add(new Debris(550,550,player, Assets.debris));
//debris.add(new Debris(550,600,player, Assets.debris));
//debris.add(new Debris(550,650,player, Assets.debris));
//debris.add(new Debris(550,700,player, Assets.debris));
//debris.add(new Debris(550,750,player, Assets.debris));
//debris.add(new Debris(550,800,player, Assets.debris));
//debris.add(new Debris(550,850,player, Assets.debris));
//
//teleporters.add(new Teleporter(new Vec2(1000, 80), new Vec2(400,600), player, Assets.teleportal));
//
//stars[0] = new Stars(790, 555);
//stars[1] = new Stars(450, 430);
//stars[2] = new Stars(140, 150);
//
//levelEditor = new LevelEditor(this);

//World3Level3
//out = new Portal(100,150);
//player = new Player((int) out.pos.x, (int) out.pos.y, 100, new Vec2(100, 0));
//
//in = new Portal(700, 500, player);
//
//deflectors.add(new Deflector(planetXPos,getNextPlanetPos(),200,150,player));
//
//planets.add(new Planet(planetXPos, getNextPlanetPos(), 750,400,player,Assets.planet1, false));
//
//debris.add(new Debris(950,350,player, Assets.debris));
//debris.add(new Debris(850,350,player, Assets.debris));
//debris.add(new Debris(750,350,player, Assets.debris));
//debris.add(new Debris(650,350,player, Assets.debris));
//debris.add(new Debris(550,350,player, Assets.debris));
//debris.add(new Debris(450,350,player, Assets.debris));
//debris.add(new Debris(350,350,player, Assets.debris));
//debris.add(new Debris(250,350,player, Assets.debris));
//debris.add(new Debris(150,350,player, Assets.debris));
//debris.add(new Debris(50,350,player, Assets.debris));
//
//teleporters.add(new Teleporter(new Vec2(300, 50), new Vec2(600,100), player, Assets.teleportal));
//teleporters.add(new Teleporter(new Vec2(300, 200), new Vec2(300,500), player, Assets.teleportal));
//
//stars[0] = new Stars(235, 130);
//stars[1] = new Stars(650, 510);
//stars[2] = new Stars(415, 505);
//
//levelEditor = new LevelEditor(this);

//World3Level4
