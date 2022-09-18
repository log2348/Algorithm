


# Assignment-1
🐭🧀 Mouse가 Cheese를 찾아가는 프로그램 구현

<br>

## 🐭 Mouse의 행동 방식


<div>
<img src="https://user-images.githubusercontent.com/96460131/190904149-c3aaec2e-593b-42f6-91ea-7ebc01e81391.jpg" width=40% height=40%>

 - Mouse는 Cheese의 위치를 모른다는 가정
 - Mouse는 위 그림과 같이 치즈에 도달할 때까지 계속 전진하며,
좌표의 끝에 도달하면 방향을 변경하여 전진함

</div>

<br>

## 📌 클래스 설명

### Mouse

 - Mouse의 행동 함수화 (recursive function)
 - Mouse가 Cheese를 만나면 동작(move)이 종료되도록 함

		public void move(Cheese cheese, Map map) {

			/**
			 * Mouse와 Cheese의 좌표가 같아지면 재귀 호출 종료
			 */
			if (locationX == cheese.getLocationX() && locationY == cheese.getLocationY()) {
				System.out.println("Mouse가 Cheese를 찾았습니다 !");
				System.out.println(this);
				return;
			}
			
				...
				

			move(cheese, map);

		}





### Cheese

- Mouse가 찾아야 하는 Cheese 클래스
- Mouse와 마찬가지로, 위치로서의 좌표값을 가짐


	    @Getter
		@Setter
		public class Cheese {
	
			private int locationX;
			private int locationY;

		}




### Map

- 프로그램의 좌표 공간
- Map 객체 생성시 크기 지정 (기준 좌표 설정)

	    @Getter
		public class Map {
			private int x;
			private int y;

			public Map(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}




### Direction
- Mouse의 방향을 정의한 상수 집합

	    public enum Direction {
			LEFT, RIGHT
		}




### Main

- main 함수 실행
 - Cheese의 위치 좌표 입력 받아 Cheese 객체 초기화
 - 사용자의 입력값에 대한 validation 체크


		public class Main {

			public static void main(String[] args) throws IOException {
				Map map = new Map(8, 8);
				Mouse mouse = new Mouse();

				mouse.move(setCheeseLocation(map.getX(), map.getY()), map);
			}

			private static Cheese setCheeseLocation(int mapX, int mapY) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				Cheese cheese = new Cheese();

				int cheeseX;
				int cheeseY;
				boolean flag = true;

				while (flag) {
				
					...

					if ((cheeseX > mapX || cheeseY > mapY) || (cheeseX < 0 || cheeseY < 0)) {
						System.out.println("Cheese의 위치가 맵의 범위를 벗어났습니다.");
					} else {
						cheese.setLocationX(cheeseX);
						cheese.setLocationY(cheeseY);
						flag = false;
					}
				}

				return cheese;
			}

		}



