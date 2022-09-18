package quiz01;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cheese {
	
	private static Cheese instance = new Cheese();
	
	private int locationX;
	private int locationY;
	
	public static Cheese getInstance() {
		if (instance == null) {
			instance = new Cheese();
		}
		return instance;
	}

}
