package engine.math;

import java.awt.Rectangle;

public class Collision {

	public static boolean isColliding(Rectangle rect1, Rectangle rect2) {
		// TOP LEFT
		if ((rect2.x >= rect1.x && rect2.x <= rect1.x + rect1.width)
				&& (rect2.y >= rect1.y && rect2.y <= rect1.y + rect1.height)) {

			return true;

		}

		// TOP RIGHT
		if ((rect2.x + rect2.width >= rect1.x && rect2.x + rect2.width <= rect1.x + rect1.width)
				&& (rect2.y >= rect1.y && rect2.y <= rect1.y + rect1.height)) {

			return true;

		}

		// BOTTOM LEFT
		if ((rect2.x >= rect1.x && rect2.x <= rect1.x + rect1.width)
				&& (rect2.y + rect2.height >= rect1.y && rect2.y + rect2.height <= rect1.y + rect1.height)) {

			return true;

		}

		// BOTTOM RIGHT
		if ((rect2.x + rect2.width >= rect1.x && rect2.x + rect2.width <= rect1.x + rect1.width)
				&& (rect2.y + rect2.height >= rect1.y && rect2.y + rect2.height <= rect1.y + rect1.height)) {

			return true;

		}

		return false;
	}
}
