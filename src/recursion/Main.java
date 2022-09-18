package recursion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Map map = new Map(8, 8);
		Mouse mouse = new Mouse();
		
		mouse.move(setCheeseLocation(map.getX(), map.getY()), map);
	}

	private static Cheese setCheeseLocation(int mapX, int mapY) {
		Scanner input = new Scanner(System.in);
		Cheese cheese = new Cheese();

		int cheeseX;
		int cheeseY;
		boolean flag = true;
		
		while (flag) {
			System.out.println("Cheese의 위치 좌표를 입력 해주세요.");
			System.out.print("x : ");
			cheeseX = input.nextInt();
			System.out.print("y : ");
			cheeseY = input.nextInt();
			
			if((cheeseX > mapX || cheeseY > mapY)
					|| (cheeseX < 0 || cheeseY < 0)) {
				System.out.println("Cheese의 위치가 맵의 범위를 벗어났습니다.");
			} else {
				cheese.setLocationX(cheeseX);
				cheese.setLocationY(cheeseY);
				flag = false;
			}
		}
		
		input.close();
		return cheese;
	}

}