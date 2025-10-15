package game;

import java.awt.*;
import java.awt.event.*;
import game.Polygon;

class AirHockey extends Game implements KeyListener {
    static int counter = 0;
    Striker striker1;
    Striker striker2;

    public AirHockey() {
        super("Air Hockey", 800, 428);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocus();

        striker1 = new Striker(200, 200, Color.blue, true);   // WASD
        striker2 = new Striker(600, 200, Color.green, false); // Arrows
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.white);
        brush.fillRect(0, 0, width, height);
        brush.setColor(Color.red);
        brush.drawOval(-75, 125, 150, 150);
        brush.drawOval(725, 125, 150, 150);
        brush.drawOval(360, 160, 80, 80);
        brush.fillOval(390, 190, 20, 20);
        brush.fillRect(399, 0, 2, 400);

        Polygon goalLeft = makeRectangle(0, 125, 8, 150);
        drawRectangle(goalLeft, brush, Color.red);

        Polygon goalRight = makeRectangle(792, 125, 8, 150);
        drawRectangle(goalRight, brush, Color.red);

        Polygon leftTopBorder = makeRectangle(0, 0, 8, 127);
        drawRectangle(leftTopBorder, brush, Color.black);

        Polygon leftBottomBorder = makeRectangle(0, 273, 8, 150);
        drawRectangle(leftBottomBorder, brush, Color.black);

        Polygon rightTopBorder = makeRectangle(792, 0, 8, 127);
        drawRectangle(rightTopBorder, brush, Color.black);

        Polygon rightBottomBorder = makeRectangle(792, 273, 8, 150);
        drawRectangle(rightBottomBorder, brush, Color.black);

        Polygon topBorder = makeRectangle(0, 0, 800, 8);
        drawRectangle(topBorder, brush, Color.black);

        Polygon bottomBorder = makeRectangle(0, 392, 800, 8);
        drawRectangle(bottomBorder, brush, Color.black);

        striker1.update(width, height);
        striker2.update(width, height);

        striker1.draw(brush);
        striker2.draw(brush);

        counter++;
        brush.setColor(Color.white);
        brush.drawString("Counter is " + counter, 10, 10);
    }

    public Polygon makeRectangle(int x_position, int y_position, int width, int height) {
        Point[] rectPoints = {
            new Point(0, 0),
            new Point(width, 0),
            new Point(width, height),
            new Point(0, height)
        };
        Polygon rectangle = new Polygon(rectPoints, new Point(x_position, y_position), 0);
        return rectangle;
    }

    public void drawRectangle(Polygon rectangle, Graphics brush, Color color) {
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

    public void keyPressed(KeyEvent e) {
        striker1.handleKeyPress(e);
        striker2.handleKeyPress(e);
    }

    public void keyReleased(KeyEvent e) {
        striker1.handleKeyRelease(e);
        striker2.handleKeyRelease(e);
    }

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        AirHockey a = new AirHockey();
        a.repaint();
    }
}
