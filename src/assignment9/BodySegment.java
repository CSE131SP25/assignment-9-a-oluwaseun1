package assignment9;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

public class BodySegment {
	private double x, y; // using double for compatibility with StdDraw
	private static final double SIZE = 0.02; // based on StdDraw 0-1 coordinate system

	public BodySegment(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void draw() {
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.filledSquare(x, y, SIZE / 2); // square centered at (x, y)
	}

	public double getX() { return x; }
	public double getY() { return y; }

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
