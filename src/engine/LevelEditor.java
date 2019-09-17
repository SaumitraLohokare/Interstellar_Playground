package engine;

import java.util.ArrayList;

import engine.math.Collision;
import engine.math.Vec2;
import game.entities.Debris;
import game.entities.Deflector;
import game.entities.Planet;
import game.entities.Player;
import game.entities.Portal;
import game.entities.Stars;
import game.entities.Teleporter;

public class LevelEditor {
	
	private Player player;
	private Portal in, out;
	private ArrayList<Planet> planets;
	private ArrayList<Deflector> deflectors;
	private ArrayList<Debris> debris;
	private ArrayList<Teleporter> teleporters;
	
	public LevelEditor(Level l) {
		this.player = l.player;
		this.in = l.in;
		this.out = l.out;
		
		this.planets = (ArrayList<Planet>) l.planets;
		this.deflectors = (ArrayList<Deflector>) l.deflectors;
		this.debris = (ArrayList<Debris>) l.debris;
		this.teleporters = (ArrayList<Teleporter>) l.teleporters;
		
	}
	
	public void update(double dt) {
		player.updateEditor(dt);
		in.updateEditor(dt);
		out.updateEditor(dt);
		
		if(!player.isInField()) {				
			player.setAcc(new Vec2());
		}

		player.setInField(false);
		
		for(Planet planet : planets) {
			planet.updateEditor(dt);
		}
		
		for (Deflector def : deflectors) {
			def.updateEditor(dt);
		}
		
		for (Debris deb : debris) {
			deb.updateEditor(dt);
		}
		
		for (Teleporter tp : teleporters) {
			tp.update(dt);
		}
	}
	
	public void render() {
		player.renderEditor();
		in.renderEditor();
		out.renderEditor();
		
		for(Planet planet : planets) {
			planet.renderEditor();
		}
		
		for (Deflector def : deflectors) {
			def.renderEditor();
		}
		
		for (Debris deb : debris) {
			deb.renderEditor();
		}
		
		for (Teleporter tp : teleporters) {
			tp.render();
		}
	}

}
