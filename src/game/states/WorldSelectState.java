package game.states;

import java.awt.Color;

import engine.Assets;
import engine.Game;
import engine.States;
import engine.ui.Button;
import engine.ui.ButtonAction;

public class WorldSelectState extends States {

	private Button world1, world2, world3, back;

	public WorldSelectState() {
		world1 = new Button(400, 200, 150, 150, "World1", Assets.w1, new ButtonAction() {
			public void action() {
				GameState.setWorld(1);
				States.setCurrentState(Game.levelSelectState);
			}
		});

		world2 = new Button(700, 360, 150, 150, "World2", Assets.w2, new ButtonAction() {
			public void action() {
				GameState.setWorld(2);
				States.setCurrentState(Game.levelSelectState);
			}
		});

		world3 = new Button(400, 510, 150, 150, "World3", Assets.w3, new ButtonAction() {
			public void action() {
				GameState.setWorld(3);
				States.setCurrentState(Game.levelSelectState);
			}
		});
		
		back = new Button(30 , 30, 25, 25, "back", Assets.back, new ButtonAction() {
			public void action() {
				States.setCurrentState(Game.menuState);
			}
		});
	}

	@Override
	public void update(double dt) {
		world1.update(dt);
		world2.update(dt);
		world3.update(dt);
		
		back.update(dt);
	}

	@Override
	public void render() {
		world1.render();
		world2.render();
		world3.render();
		
		back.render();
	}

}
