package recursion;

import lombok.Data;

@Data
public class Service {
	private Mouse mouse;
	private Cheese cheese;
	private Map map;

	/*
	public void play() {
		while (mouse.isMoveable()) {
			checkFaceCheese();
			checkCrashWall();
			// mouse.move();
		}
	}

	private void checkFaceCheese() {
		if (mouse.getLocationX() == cheese.getLocationX() && mouse.getLocationY() == cheese.getLocationY()) {
			mouse.setMoveable(false);
		}
	}

	private void checkCrashWall() {
		if (mouse.getDirection() == Direction.RIGHT && mouse.getLocationX() == map.getX()) {
			mouse.setRightWallCrash(true);
		}

		if (mouse.getDirection() == Direction.LEFT && mouse.getLocationX() == 0) {
			mouse.setLeftWallCrash(true);
		}
	}
	*/

}
