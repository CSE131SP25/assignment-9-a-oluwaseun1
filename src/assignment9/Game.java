package assignment9;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

public class Game {
	private Snake snake;
	private Food food;
	private int applesEaten = 0;
	private boolean isPaused = false;

	public Game() {
		this.snake = new Snake();
		this.food = new Food();

		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.enableDoubleBuffering();
	}

	public void run() {
		while (true) {
			if (!isPaused) {
				StdDraw.clear();

				snake.move();

				if (snake.eats(food)) {
					snake.grow();
					food.relocate();
					applesEaten++;
				}

				if (snake.hitsWall()) {
					break;
				}

				snake.draw();
				food.draw();

				StdDraw.setPenColor(Color.BLACK);
				StdDraw.textLeft(0.02, 0.97, "Apples Eaten: " + applesEaten);
			} else {
				StdDraw.setPenColor(Color.PINK);
				StdDraw.text(0.5, 0.5, "Paused - Press P to Resume");
			}

			StdDraw.show();
			StdDraw.pause(100);

			// Arrow key movement
			if (StdDraw.isKeyPressed(38)) {
				snake.changeDirection(0, 0.02); // UP
			} else if (StdDraw.isKeyPressed(40)) {
				snake.changeDirection(0, -0.02); // DOWN
			} else if (StdDraw.isKeyPressed(37)) {
				snake.changeDirection(-0.02, 0); // LEFT
			} else if (StdDraw.isKeyPressed(39)) {
				snake.changeDirection(0.02, 0); // RIGHT
			}

			// Pause/Unpause with 'P' key
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				if (key == 'p' || key == 'P') {
					isPaused = !isPaused;
				}
			}
		}

		// Game over screen
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.55, "Game Over!");
		StdDraw.text(0.5, 0.5, "Apples Eaten: " + applesEaten);
		StdDraw.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}
}
