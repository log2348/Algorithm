package recursion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mouse {

	// Mouse의 현재 좌표
	private int locationX;
	private int locationY;

	// Mouse의 행동 실행 횟수
	private int leftTurnCount;
	private int rightTurnCount;
	private int forwardCount;

	// 벽에 충돌한 상태
	private boolean isLeftWallCrash;
	private boolean isRightWallCrash;

	// Mouse의 방향
	private Direction direction;

	public Mouse() {
		initSetting();
	}

	private void initSetting() {
		locationX = 0;
		locationY = 0;

		leftTurnCount = 0;
		rightTurnCount = 0;
		forwardCount = 0;

		isLeftWallCrash = false;
		isRightWallCrash = false;
		direction = Direction.RIGHT;
	}

	@Override
	public String toString() {
		return "[ Mouse의 행동 실행 횟수 ]\n전진 : " + forwardCount + "번\n왼쪽 회전 : " + leftTurnCount + "번\n오른쪽 회전 : " + rightTurnCount + "번";
	}

	public void move(Cheese cheese, Map map) {

		/**
		 * Mouse와 Cheese의 좌표가 같아지면 재귀 호출이 종료되며, 결과값을 반환한다.
		 */
		if (locationX == cheese.getLocationX() && locationY == cheese.getLocationY()) {
			System.out.println("Mouse가 Cheese를 찾았습니다 !");
			System.out.println(this);
			return;
		}

		/**
		 * 벽 충돌 체크
		 */
		if (direction == Direction.RIGHT && locationX == map.getX()) {
			isRightWallCrash = true;
		} else if (direction == Direction.LEFT && locationX == 0) {
			isLeftWallCrash = true;
		}

		/**
		 * 좌표 이동 동작
		 */
		if (direction == Direction.RIGHT) {
			if (isRightWallCrash) {
				turnRight();
			} else {
				forwardCount++;
				locationX++;
			}
		} else if (direction == Direction.LEFT) {
			if (isLeftWallCrash) {
				turnLeft();
			} else {
				forwardCount++;
				locationX--;
			}
		}

		System.out.println("[ Mouse의 현재 좌표 ]");
		System.out.println("x : " + locationX + "\ny : " + locationY + "\n");

		move(cheese, map);

	}

	/**
	 * 오른쪽 벽에 도달했을 시,
	 * 오른쪽 회전한 후, 아래로 한 칸 이동하여 다시 오른쪽으로 회전한다.
	 */
	private void turnRight() {
		rightTurnCount += 2;
		forwardCount++;
		locationY++;
		direction = Direction.LEFT;
		isRightWallCrash = false;
	}

	/**
	 * 왼쪽 벽에 도달했을 시,
	 * 왼쪽 회전 후, 아래로 한칸 이동하여 다시 왼쪽으로 회전한다.
	 */
	private void turnLeft() {
		leftTurnCount += 2;
		forwardCount++;
		locationY++;
		direction = Direction.RIGHT;
		isLeftWallCrash = false;
	}

}
