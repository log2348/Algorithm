

## 🐭 Mouse의 행동 방식

<br>

<div>
<img src="https://user-images.githubusercontent.com/96460131/190904149-c3aaec2e-593b-42f6-91ea-7ebc01e81391.jpg" width=40% height=40%>

 - Mouse는 Cheese의 위치를 모른다는 가정
 - Mouse는 위 그림과 같이 치즈에 도달할 때까지 계속 전진하며,
좌표의 끝에 도달하면 방향을 변경하여 전진함

</div>

<br>

## 📌 클래스 설명

### Mouse

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

		...

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

 - Mouse의 행동 함수화 (recursion function call)
 - Mouse가 Cheese를 만나면 동작(move)이 종료되도록 함


### Cheese

    @Getter
	@Setter
	public class Cheese {
	
		private int locationX;
		private int locationY;

	}

- Mouse가 찾아야 하는 Cheese 클래스
- Mouse와 마찬가지로, 위치로서의 좌표값을 가짐


### Map

    @Getter
	public class Map {
		private int x;
		private int y;

		public Map(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

- Map 객체 생성시 좌표 공간의 크기 지정 (기준 좌표 설정)


### Direction

    public enum Direction {
		LEFT, RIGHT
	}

- Mouse의 방향을 정의한 상수 집합

<br>


## 📌 실행 코드


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

 - 사용자의 입력값에 대한 validation 체크

