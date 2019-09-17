package engine;

public class Launcher {

	private static Game game;
	private static Thread thread;
	
	public static void main(String[] args) {
		//Launcher launcher = new Launcher();
		
		game = new Game();
		start();
	}
	
	public static synchronized void start() {
		thread = new Thread(game);
		thread.start();
	}
	
	public static synchronized void stop() {
		try {
			thread.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
