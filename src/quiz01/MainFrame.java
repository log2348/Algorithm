package quiz01;

import java.util.Scanner;

public class MainFrame {

	// Map 크기
	static final int WIDTH = 9;
	static final int HEIGHT = 9;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Mouse mouse = Mouse.getInstance();
		Cheese cheese = Cheese.getInstance();

		System.out.println("Cheese의 좌표를 입력하세요.");
		System.out.print("x 좌표 : ");
		cheese.setLocationX(input.nextInt());

		System.out.print("y 좌표 : ");
		cheese.setLocationY(input.nextInt());

		if (mouse.getLocationX() == WIDTH) {
			mouse.setRightWallCrash(true);
		} else if (mouse.getLocationX() == 0 && mouse.getLocationY() != 0) {
			// (0,0)일 경우 출발 상태(원점)이므로
			mouse.setLeftWallCrash(true);
		}

		mouse.move(Direction.RIGHT);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("[ 쥐의 행동 횟수 ]\n" + mouse);
	}

}
