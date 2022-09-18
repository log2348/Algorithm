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
			System.out.println("치즈의 위치를 입력 해주세요.");
			System.out.print("X : ");
			cheeseX = input.nextInt();
			System.out.print("Y : ");
			cheeseY = input.nextInt();
			
			if((cheeseX > mapX || cheeseY > mapY)
					|| (cheeseX < 0 && cheeseY < 0)) {
				// 둘 중 하나가 0 인 경우는 가능
				System.out.println("치즈의 위치가 맵의 위치를 벗어났습니다.");
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