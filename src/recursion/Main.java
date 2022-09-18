package recursion;

import java.util.Scanner;

public class Main {

	// Map 크기
	static final int WIDTH = 9;
	static final int HEIGHT = 9;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Cheese cheese = new Cheese();

		System.out.println("Cheese의 좌표를 입력하세요.");
		System.out.print("x 좌표 : ");
		cheese.setLocationX(input.nextInt());

		System.out.print("y 좌표 : ");
		cheese.setLocationY(input.nextInt());

		if (cheese.getLocationX() < 0 || cheese.getLocationY() < 0 || cheese.getLocationX() > WIDTH
				|| cheese.getLocationY() > HEIGHT) {
			System.out.println("좌표의 범위를 벗어났습니다. 다시 입력해주세요.");

			System.out.print("x 좌표 : ");
			cheese.setLocationX(input.nextInt());

			System.out.print("y 좌표 : ");
			cheese.setLocationY(input.nextInt());
		}

		Mouse mouse = new Mouse();

		input.close();

		// mouse.move(Direction.RIGHT);

		System.out.println("[ 쥐의 행동 횟수 ]\n" + mouse);
	}

}
