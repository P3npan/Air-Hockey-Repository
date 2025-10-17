package game;

import java.awt.Color;
import java.awt.Graphics;

public class Puck {
	private int size = 20;
	private int radius = 10;
	
	private Polygon[] puck = new Polygon[4];
	
	private int xPos = 400;
	private int yPos = 200;
	private int speed = 10;
	private int bounceCount;
	
	public Puck() {
		// left side
		Point[] lPoints = {new Point(xPos, yPos), new Point(xPos, yPos-radius)};
		Polygon lSide = new Polygon(lPoints, new Point(0,0), 0);
		puck[0] = lSide;
		// right side
		Point[] rPoints = {new Point(xPos-radius, yPos), new Point(xPos-radius, yPos-radius)};
		Polygon rSide = new Polygon(lPoints, new Point(0,0), 0);
		puck[0] = rSide;
		// top side
		Point[] tPoints = {new Point(xPos, yPos-radius), new Point(xPos-radius, yPos-radius)};
		Polygon tSide = new Polygon(lPoints, new Point(0,0), 0);
		puck[0] = tSide;
		// bottom side
		Point[] bPoints = {new Point(xPos, yPos), new Point(xPos-radius, yPos)};
		Polygon bSide = new Polygon(lPoints, new Point(0,0), 0);
		puck[0] = bSide;
		
		
		
		
		bounceCount = 0;
	}
	
	public void paint(Graphics brush) {
		brush.setColor(Color.ORANGE);
		brush.fillOval(xPos - radius,yPos - radius, size,size);
	}
	
	public void move() {
		xPos += speed;
		yPos += speed;
	}
}

