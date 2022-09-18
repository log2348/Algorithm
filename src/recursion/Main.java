package recursion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1. Cheese, Mouse, Map, BackgroundService 생성
		Service service = new Service();
		Map map = new Map(8, 8);
		// 2. service DI
		service.setMap(map);
		service.setMouse(new Mouse());
		// 3. Cheese 좌표값 세팅
		service.setCheese(setCheeseLocation(map.getX(), map.getY()));
		// 4. service 가동
		service.play();

	}

	private static Cheese setCheeseLocation(int mapX, int mapY) {
		/**
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		Cheese cheese = new Cheese();

		int cheeseX;
		int cheeseY;
		boolean flag = true;
		while (flag) {
			System.out.println("치즈의 위치를 입력 해주세요.");
			System.out.print("X : ");
			cheeseX = sc.nextInt();
			System.out.print("Y : ");
			cheeseY = sc.nextInt();
			if (cheeseX < mapX && cheeseY < mapY) {
				// System.out.println("mapX : " + mapX + " mapY : " + mapY);
				cheese.setLocationX(cheeseX);
				cheese.setLocationY(cheeseY);
				flag = false;
			} else {
				System.out.println("치즈의 위치가 맵의 위치를 벗어났습니다.");
			}
		}
		sc.close();
		return cheese;
	}

}