package assignment9;

import java.util.LinkedList;

public class Snake {
	private LinkedList<BodySegment> body;
	private double dx = 0.02, dy = 0.0; // initial movement to the right

	public Snake() {
		body = new LinkedList<>();
		body.add(new BodySegment(0.5, 0.5)); // center starting point
	}

	public void draw() {
		for (BodySegment segment : body) {
			segment.draw();
		}
	}

	public void move() {
		BodySegment head = body.getFirst();
		double newX = head.getX() + dx;
		double newY = head.getY() + dy;
		body.addFirst(new BodySegment(newX, newY));
		body.removeLast(); // tail moves forward
	}

	public void grow() {
		BodySegment tail = body.getLast();
		body.addLast(new BodySegment(tail.getX(), tail.getY()));
	}

	public void changeDirection(double newDx, double newDy) {
		if (!(dx + newDx == 0 && dy + newDy == 0)) {
			dx = newDx;
			dy = newDy;
		}
	}

	public boolean eats(Food food) {
		BodySegment head = body.getFirst();
		return Math.abs(head.getX() - food.getX()) < 0.02 &&
				Math.abs(head.getY() - food.getY()) < 0.02;
	}

	public boolean hitsWall() {
		BodySegment head = body.getFirst();
		return head.getX() < 0 || head.getX() > 1 || head.getY() < 0 || head.getY() > 1;
	}

	public boolean hitsSelf() {
		BodySegment head = body.getFirst();
		for (int i = 1; i < body.size(); i++) {
			BodySegment segment = body.get(i);
			if (Math.abs(head.getX() - segment.getX()) < 0.001 &&
					Math.abs(head.getY() - segment.getY()) < 0.001) {
				return true;
			}
		}
		return false;
	}
}
