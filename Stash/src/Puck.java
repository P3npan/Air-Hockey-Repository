package game;

import java.awt.Color;
import java.awt.Graphics;

public class Puck {
	private int xPos = 400;
	private int yPos = 200;
	private int speed = 10;
	private int[] direction;
	private int bounceCount;
	
	private int size = 20;
	private int radius = 10;
	
	private Point[] points = {new Point(xPos, yPos)};
	private double rotation = 0;
	private Polygon puck;
	
	public Puck() {
		puck = new Polygon(points, new Point(0,0), rotation);
		bounceCount = 0;
	}
	
	public void paint(Graphics brush) {
		brush.setColor(Color.ORANGE);
		brush.fillOval(xPos - radius,yPos - radius, size,size);
	}
	
	public void move() {
		updateCollision();
		xPos += speed;
		yPos += speed;
	}
	
	private void updateCollision() {
		
	}
}

