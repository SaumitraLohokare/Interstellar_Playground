package engine.math;

public class Vec2 {

	public float x , y;
	
	public Vec2 (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vec2 add(Vec2 v) {
		float nX = this.x + v.x;
		float nY = this.y + v.y;
		
		return new Vec2(nX, nY);
	}
	
	public double magnitudeSqr() {
		return Math.pow(x, 2) + Math.pow(y, 2);
	}
	
	public Vec2 scalarMultiply(float s) {
		return new Vec2(s * this.x, s * this.y);
	}
	
	public static double distSqr(Vec2 v1 , Vec2 v2) {
		return Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2);
	}
	
}
