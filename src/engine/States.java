package engine;

public abstract class States {

	public abstract void update(double dt);
	public abstract void render();

	//-----------------------------------------------------
	
	private static States currentState = null;
	
	public static States getCurrentState() {
		return currentState;
	}
	
	public static void setCurrentState(States currentState) {
		States.currentState = currentState;
	}
	
	
}
