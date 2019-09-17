package engine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import engine.io.Mouse;
import engine.math.Collision;
import engine.math.Vec2;
import engine.ui.Button;
import engine.ui.ButtonAction;
import game.entities.Debris;
import game.entities.Deflector;
import game.entities.Planet;
import game.entities.Player;
import game.entities.Portal;
import game.entities.Stars;
import game.entities.Teleporter;

public class Level {

	protected Player player;
	protected Portal in, out;

	protected List<Planet> planets;
	protected List<Deflector> deflectors;
	protected List<Debris> debris;
	protected List<Teleporter> teleporters;

	protected LevelEditor levelEditor;

	protected boolean editing = false;

	protected Button editButton, saveButton, back;

	protected Stars[] stars = new Stars[3];

	public Level() {
		editButton = new Button(Game.WIDTH - 110, 50, 100, 50, "Edit", Assets.edit, new ButtonAction() {
			public void action() {
				editing = true;

				for (int i = 0; i < stars.length; i++) {
					stars[i].setCollected(false);
				}
			}
		});

		saveButton = new Button(Game.WIDTH - 110, 50, 100, 50, "Save", Assets.save, new ButtonAction() {
			public void action() {
				editing = false;
				player.resetPosWithDelay();
			}
		});
		
		back = new Button(30 , 30, 25, 25, "back", Assets.back, new ButtonAction() {
			public void action() {
				States.setCurrentState(Game.levelSelectState);
			}
		});

		planets = new ArrayList<>();
		deflectors = new ArrayList<>();
		debris = new ArrayList<>();
		teleporters = new ArrayList<>();

	}

	public void update(double dt) {
		if (!editing) {
			editButton.update(dt);

			player.update(dt);
			out.update(dt);
			in.update(dt);

			if (!player.isInField()) {
				player.setAcc(new Vec2());
			}

			player.setInField(false);

			for (Planet planet : planets) {
				planet.update(dt);
			}

			for (Deflector def : deflectors) {
				def.update(dt);
			}

			for (Debris deb : debris) {
				deb.update(dt);
			}

			for (Teleporter tp : teleporters) {
				tp.update(dt);
			}

			for (int i = 0; i < stars.length; i++) {
				if (!stars[i].isCollected())
					if (Collision.isColliding(stars[i].getBoundingBox(), player.getBoundingBox())) {
						stars[i].setCollected(true);
					}
			}

		} else {
			saveButton.update(dt);
			back.update(dt);

			levelEditor.update(dt);
		}

		if (Mouse.isEditClicked()) {
			System.out.println("-----------------------------------------------------");
			System.out.println("IN Wormhole : (" + in.pos.x + "," + in.pos.y + ")");
			System.out.println("OUT Wormhole : (" + out.pos.x + "," + out.pos.y + ")");
			System.out.println("Mouse : (" + Mouse.getPos().x + "," + Mouse.getPos().y + ")");
			for (Planet planet : planets) {
				System.out.println("Planet : (" + planet.getPos().x + "," + planet.getPos().y + ")");
			}
			System.out.println("-----------------------------------------------------");
		}
	}

	public void render() {
		if (!editing) {
			player.render();
			out.render();
			in.render();

			for (Planet planet : planets) {
				planet.render();
			}

			for (Deflector def : deflectors) {
				def.render();
			}

			for (Debris deb : debris) {
				deb.render();
			}

			for (Teleporter tp : teleporters) {
				tp.render();
			}

			for (int i = 0; i < stars.length; i++) {
				stars[i].render();
			}

			editButton.render();
		} else {
			levelEditor.render();
			back.render();

			saveButton.render();
		}
	}

	protected int planetXPos = Game.WIDTH - 100;
	protected int planetCounter = 0;

	public int getNextPlanetPos() {
		return 200 + (75 * planetCounter++);
	}

}
