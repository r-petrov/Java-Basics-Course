package Game;

import Display.Display;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Java Game Workshop", 800, 600);
		game.start();
	}
}
