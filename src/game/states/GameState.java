package game.states;

import engine.Level;
import engine.ParticleManager;
import engine.States;
import game.levels.World1Level1;
import game.levels.World1Level3;
import game.levels.World1Level4;
import game.levels.World1Level5;
import game.levels.World2Level1;
import game.levels.World2Level2;
import game.levels.World2Level3;
import game.levels.World2Level4;
import game.levels.World3Level1;
import game.levels.World3Level2;
import game.levels.World3Level3;
import game.levels.World3Level4;

public class GameState extends States{
	
	private static Level test;
	
	private static int worldIndex = 1;
	private static Level[] world1, world2, world3;
	
	private static int levelIndex = 0;
	
	public GameState() {
		
		world1 = new Level[4];
		world1[0] = new World1Level1();
		world1[1] = new World1Level3();
		world1[2] = new World1Level4();
		world1[3] = new World1Level5();
		
		world2 = new Level[4];
		world2[0] = new World2Level1();
		world2[1] = new World2Level2();
		world2[2] = new World2Level3();
		world2[3] = new World2Level4();
		
		world3 = new Level[4];
		world3[0] = new World3Level1();
		world3[1] = new World3Level2();
		world3[2] = new World3Level3();
		world3[3] = new World3Level4();
	}

	@Override
	public void update(double dt) {
		
		if(worldIndex == 1) {
			world1[levelIndex].update(dt);
		} else if(worldIndex == 2) {
			world2[levelIndex].update(dt);
		} else if(worldIndex == 3) {
			world3[levelIndex].update(dt);
		} else {
			throw new IllegalStateException("World does not exist.");
		}
	}

	@Override
	public void render() {
		
		if(worldIndex == 1) {
			world1[levelIndex].render();
		} else if(worldIndex == 2) {
			world2[levelIndex].render();
		} else if(worldIndex == 3) {
			world3[levelIndex].render();
		} else {
			throw new IllegalStateException("World does not exist.");
		}
	}
	
	public static void nextLevel() {		
		if(levelIndex == 3) {
			levelIndex = 1;
			if(worldIndex < 3) {
				worldIndex++;
			}
		} else {
			levelIndex++;
		}
	}
	
	public static void setWorld(int i) {
		worldIndex = i;
	}
	
	public static void setLevel(int i) {
		levelIndex = i;
	}

}
