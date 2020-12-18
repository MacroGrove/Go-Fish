package game;

public class Main {

	public static void main(String args[]) {

		try {
			GoFish game = new GoFish();
			game.play();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
