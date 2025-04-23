package assignment9;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.util.Random;

public class Food {
	private double x, y;
	private static final double SIZE = 0.02;

	public Food() {
		relocate();
	}

	public void relocate() {
		Random rand = new Random();
		// Snap food to grid based on SIZE
		x = rand.nextInt(50) * SIZE;
		y = rand.nextInt(50) * SIZE;
	}

	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, SIZE / 2);
	}

	public double getX() { return x; }
	public double getY() { return y; }
}
