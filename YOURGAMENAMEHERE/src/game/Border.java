package game;

import java.awt.Color;
import java.awt.Graphics;

public class Border {
	private Polygon rectangle;
	
	public Border(int x_position, int y_position, int width, int height){
		Point[] rectPoints = {
	            new Point(0, 0),
	            new Point(width, 0),
	            new Point(width, height),
	            new Point(0, height)
	        };
	        Polygon rectangle = new Polygon(rectPoints, new Point(x_position, y_position), 0);
	        this.rectangle = rectangle;
	}

    public void drawRectangle(Graphics brush, Color color) {
        Point[] points = rectangle.getPoints();
        int[] x_points = new int[points.length];
        int[] y_points = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            x_points[i] = (int) points[i].x;
            y_points[i] = (int) points[i].y;
        }
        brush.setColor(color);
        brush.fillPolygon(x_points, y_points, points.length);
    }
}
