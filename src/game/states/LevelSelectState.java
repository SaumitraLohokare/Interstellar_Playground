package game.states;

import java.awt.Color;

import engine.Assets;
import engine.Game;
import engine.States;
import engine.ui.Button;
import engine.ui.ButtonAction;

public class LevelSelectState extends States{
	
	private Button level1, level2, level3, level4, back;
	
	public LevelSelectState() {
		level1 = new Button(400, 200, 150, 150, "Level1", Assets.l1, new ButtonAction() {
			public void action() {
				GameState.setLevel(0);
				States.setCurrentState(Game.gameState);
			}
		});
		
		level2 = new Button(700, 200, 150, 150, "Level2", Assets.l2, new ButtonAction() {
			public void action() {
				GameState.setLevel(1);
				States.setCurrentState(Game.gameState);
			}
		});
		
		level3 = new Button(400, 400, 150, 150, "Level3", Assets.l3, new ButtonAction() {
			public void action() {
				GameState.setLevel(2);
				States.setCurrentState(Game.gameState);
			}
		});
		
		level4 = new Button(700, 400, 150, 150, "Level4", Assets.l4, new ButtonAction() {
			public void action() {
				GameState.setLevel(3);
				States.setCurrentState(Game.gameState);
			}
		});
		
		back = new Button(30 , 30, 25, 25, "back", Assets.back, new ButtonAction() {
			public void action() {
				States.setCurrentState(Game.worldSelectState);
			}
		});
	}

	@Override
	public void update(double dt) {
		level1.update(dt);
		level2.update(dt);
		level3.update(dt);
		level4.update(dt);
		
		back.update(dt);
	}

	@Override
	public void render() {
		level1.render();
		level2.render();
		level3.render();
		level4.render();
		
		back.render();
	}

}
