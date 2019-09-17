package engine;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import engine.io.Mouse;
import engine.math.Vec2;
import game.states.GameState;
import game.states.LevelSelectState;
import game.states.MenuState;
import game.states.WorldSelectState;

public class Game extends JFrame implements Runnable {

	public static final int WIDTH = 1080, HEIGHT = 720;
	private static boolean running = false;

	private Screen screen;

	private Mouse mouse;

	private ParticleManager pm;

	// STATES
	public static States menuState, gameState, worldSelectState, levelSelectState;

	// ParallaxShit
	private BufferedImage bg;
	private int maxParallax = 50;
	private Vec2 bgPos;

	public Game() {
		this.setTitle("Interstellar Playground");
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		running = true;

		this.setVisible(true);

		screen = new Screen();
		this.add(screen);
		screen.init();

		mouse = new Mouse();
		screen.setFocusable(true);
		screen.addMouseListener(mouse);
		screen.addMouseMotionListener(mouse);

		init();
	}

	public void init() {
		new Assets();

		bg = Assets.starryNight;
		bgPos = new Vec2();

		pm = new ParticleManager();

		menuState = new MenuState();
		gameState = new GameState();
		worldSelectState = new WorldSelectState();
		levelSelectState = new LevelSelectState();

		States.setCurrentState(menuState);
	}

	public void update(double dt) {

		bgPos.x = ((Game.WIDTH / 2 - Mouse.getPos().x) / (Game.WIDTH / 2)) * maxParallax;
		bgPos.y = ((Game.HEIGHT / 2 - Mouse.getPos().y) / (Game.HEIGHT / 2)) * maxParallax;

		if (States.getCurrentState() != null) {
			States.getCurrentState().update(dt);
		}

		pm.update(dt);
		// System.out.println(1/dt);
	}

	public void render() {
		screen.start();

		if (States.getCurrentState() != gameState)
			Screen.drawImage(bg, (int) bgPos.x, (int) bgPos.y, WIDTH, HEIGHT);
		pm.render();

		if (States.getCurrentState() != null) {
			States.getCurrentState().render();
		}

		screen.display();
	}

	@Override
	public void run() {

		long last = System.nanoTime(), now;
		double delta = 0;
		int fps = 60;
		double timePerTick = 1000000000 / fps;

		long elapsedLast = System.nanoTime(), elapsedNow;
		double dt;

		double timerLast = System.nanoTime(), timerNow;

		while (running) {
			now = System.nanoTime();

			delta += (now - last) / timePerTick;

			last = now;

			if (delta >= 1) {

				elapsedNow = System.nanoTime();
				dt = (elapsedNow - elapsedLast) / 1000000000.0;
				elapsedLast = elapsedNow;

				timerNow = System.nanoTime();
				if (timerNow - timerLast >= 1000000000) {
					// System.out.println(1/dt);
					timerLast = timerNow;
				}

				update(dt);

				delta--;
			}

			render();
		}

		this.dispose();

		Launcher.stop();
	}

	public static void close() {
		running = false;
	}

}
