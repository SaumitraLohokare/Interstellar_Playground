package engine;

import java.util.ArrayList;

import game.entities.Particle;

public class ParticleManager {
	
	private static ArrayList<Particle> particles;
	
	public ParticleManager() {
		particles = new ArrayList<>();
	}
	
	public void update(double dt) {
		for(int i = particles.size() - 1; i >= 0; i--) {
			particles.get(i).update(dt);
		}
	}
	
	public void render() {
		for(int i = particles.size() - 1; i >= 0; i--) {
			particles.get(i).render();
		}
	}
	
	public static void addParticle(Particle p) {
		particles.add(p);
	}
	
	public static void removeParticle(Particle p) {
		particles.remove(p);
	}

}
