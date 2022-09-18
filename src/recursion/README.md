

## 쥐의 행동 방식
<img src="https://user-images.githubusercontent.com/96460131/190893540-f1f006d6-91a4-4d1a-94d2-6d7d49973672.jpg" width=40% height=40%>


<p> 쥐는 치즈의 위치를 모르므로, <br>
위 그림과 같이 치즈에 도달할 때까지 계속 전진하며 좌표의 끝에 도달하면 방향을 변경하여 전진한다.</p>

<br>

## 클래스 설명

### Mouse


### Cheese


    @Setter
    @Getter
	public class Cheese {
		private int locationX;
		private int locationY;
	}
- 쥐가 찾아야 하는 Cheese 객체
- 쥐와 마찬가지로 위치로서 좌표값을 가짐


### Map

### Service


    @Data
	public class Service {
		private Mouse mouse;
		private Cheese cheese;
		private Map map;

	public void play() {
		while (mouse.isMoveable()) {
			checkFaceCheese();
			checkCrashWall();
			mouse.move();
		}
	}

	private void checkFaceCheese() {
		if (mouse.getLocationX() == cheese.getLocationX() && mouse.getLocationY() == cheese.getLocationY()) {
			mouse.setMoveable(false);
		}
	}

	private void checkCrashWall() {
		if (mouse.getDirection() == Direction.RIGHT && mouse.getLocationX() == map.getX()) {
			mouse.setRightWallCrash(true);
		}

		if (mouse.getDirection() == Direction.LEFT && mouse.getLocationX() == 0) {
			mouse.setLeftWallCrash(true);
		}
		}

	}


<br>


## 실행코드



