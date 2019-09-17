package game.states;

import java.awt.image.BufferedImage;

import engine.Assets;
import engine.Game;
import engine.Screen;
import engine.States;
import engine.math.Vec2;
import engine.ui.Button;
import engine.ui.ButtonAction;
import game.entities.Player;

public class MenuState extends States {

	private Button levelSelectButton, quit;
	
	private BufferedImage titleImg, credits;

	private Player menuShip;

	public MenuState() {
		levelSelectButton = new Button(Game.WIDTH / 2, 450, 150, 50, "Level Select", Assets.play,
				new ButtonAction() {
					public void action() {
						States.setCurrentState(Game.worldSelectState);
					}
				});

		quit = new Button(Game.WIDTH / 2, 525, 130, 30, "Quit", Assets.quit, new ButtonAction() {
			public void action() {
				Game.close();
			}
		});
		
		titleImg = Assets.title;
		credits = Assets.credits;

		menuShip = new Player(0, 0, 0, new Vec2());
		menuShip.setPos(getRandomBorder());
	}

	@Override
	public void update(double dt) {
		menuShip.updateMenu(dt);
		
		if (menuShip.pos.x < 0 || menuShip.pos.x > Game.WIDTH || menuShip.pos.y < 0 || menuShip.pos.y > Game.HEIGHT) {
			menuShip.setPos(getRandomBorder());
		}

		levelSelectButton.update(dt);
		quit.update(dt);
	}

	@Override
	public void render() {

		Screen.drawImage(titleImg, Game.WIDTH/2 - 400, 200 - 150, 800, 300);
		Screen.drawImage(credits, 700, 640, credits.getWidth()/2, credits.getHeight()/2);
		
		menuShip.render();

		levelSelectButton.render();
		quit.render();
	}

	public Vec2 getRandomBorder() {
		int r = (int) (Math.random() * 4);

		switch (r) {
		case 1:
			menuShip.setVel(new Vec2(0, 200));
			menuShip.setTheta(Math.PI / 2);
			return new Vec2(50 + ((float) (Math.random() * (Game.WIDTH- 100))), 0);
		case 2:
			menuShip.setVel(new Vec2(-200, 0));
			menuShip.setTheta(Math.PI);
			return new Vec2(Game.WIDTH, 50 + ((float) (Math.random() * (Game.HEIGHT - 100))));
		case 3:
			menuShip.setVel(new Vec2(0, -200));
			menuShip.setTheta(3 * (Math.PI / 2));
			return new Vec2(50 + ((float) (Math.random() * (Game.WIDTH- 100))), Game.HEIGHT);
		default:
			menuShip.setVel(new Vec2(200, 0));
			menuShip.setTheta(0);
			return new Vec2(0, 50 + ((float) (Math.random() * (Game.HEIGHT - 100))));

		}
	}

}
