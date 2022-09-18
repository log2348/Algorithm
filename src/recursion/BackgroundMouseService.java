package recursion;

/*
 * Mouse의 행동 계속 주시
 */
public class BackgroundMouseService implements Runnable {

	private boolean isMoveable;

	private Mouse mouse;
	
	private Cheese cheese;
	
	public BackgroundMouseService(Mouse mouse, Cheese cheese) {
		this.mouse = mouse;
		this.cheese = cheese;
		isMoveable = true;
	}

	@Override
	public void run() {
		
		System.out.println("백그라운드 서비스 진행 중");

		while (isMoveable) {
			if (mouse.getLocationX() == 9) { // 오른쪽 끝에 닿으면
				System.out.println("오른쪽 벽에 도달했습니다.");
				mouse.setRightWallCrash(true);
				mouse.setDirection(Direction.DOWN);
			}
			
			if (mouse.getLocationX() == 0 && mouse.getLocationY() != 0) {
				System.out.println("왼쪽 벽에 도달했습니다.");
				mouse.setLeftWallCrash(true);
			}
			
			if(mouse.getLocationX() == cheese.getLocationX()
					&& mouse.getLocationY() == cheese.getLocationY()) {
				System.out.println("쥐가 치즈를 찾았습니다.");
				isMoveable = false;
			}
		}

	}

}
