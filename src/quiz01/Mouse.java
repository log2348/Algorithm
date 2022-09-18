package quiz01;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mouse {
	
	private static Mouse instance = new Mouse();

	private static final String LEFT = "LEFT";
	private static final String RIGHT = "RIGHT";
	private static final String DOWN = "DOWN";
	
	private BackgroundMouseService backgroundService;

	// 쥐의 현재 좌표
	private int locationX;
	private int locationY;

	// 쥐의 행동 실행 횟수
	private int leftTurnCount; // 왼쪽 회전
	private int rightTurnCount; // 오른쪽 회전
	private int forwardCount; // 전진

	// 벽에 충돌한 상태
	private boolean isLeftWallCrash;
	private boolean isRightWallCrash;

	// 쥐의 방향
	private Direction direction;

	// 움직임 상태 (쥐는 치즈에 도달할 때까지 움직여야함)
	private boolean isMoveable;

	public Mouse() {
		initSetting();
		new Thread(backgroundService).start();
	}
	
	public static Mouse getInstance() {
		if (instance == null) {
			instance = new Mouse();
		}
		return instance;
	}

	private void initSetting() {
		locationX = 0;
		locationY = 0;

		leftTurnCount = 0;
		rightTurnCount = 0;
		forwardCount = 0;

		isLeftWallCrash = false;
		isRightWallCrash = false;
		isMoveable = true;
		
		backgroundService = new BackgroundMouseService(this, Cheese.getInstance());

	}

	@Override
	public String toString() {
		return "전진 : " + forwardCount + "번\n왼쪽 회전 : " + leftTurnCount + "번\n오른쪽 회전 : " + rightTurnCount + "번";
	}

	// 재귀함수
	public void move(Direction direction) {

		if (!isMoveable) { // 쥐가 치즈에 도달하면 재귀 호출 종료
			return;
		}
		
		switch (direction) {
		case LEFT:
			locationX--;
			move(direction);
			break;
		case RIGHT:
			locationX++;
			move(direction);
			break;
		case DOWN:
			locationY++;
			move(direction);
			break;

		}

	}

	public void changeDirection() {
		
	}

}
