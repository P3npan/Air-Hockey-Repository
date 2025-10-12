package game;

import java.awt.*;
import java.awt.event.*;
import game.Polygon;

class AirHockey extends Game implements KeyListener {
    static int counter = 0;
    int puck1X = 200, puck1Y = 200;
    int puck2X = 600, puck2Y = 200;
    int puckSpeed = 5;
    boolean wPressed, aPressed, sPressed, dPressed;
    boolean upPressed, downPressed, leftPressed, rightPressed;

    public AirHockey() {
        super("Air Hockey", 800, 428);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocus();
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

        updatePucks();

        brush.setColor(Color.blue);
        brush.fillOval(puck1X, puck1Y, 30, 30);

        brush.setColor(Color.green);
        brush.fillOval(puck2X, puck2Y, 30, 30);

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

    public void updatePucks() {
        int radius = 15;

        if (wPressed && puck1Y > 8) {
            puck1Y -= puckSpeed;
        }

        if (sPressed && puck1Y < height - 38) {
            puck1Y += puckSpeed;
        }

        if (aPressed && puck1X > 8) {
            puck1X -= puckSpeed;
        }

        if (dPressed && puck1X < 400 - radius * 2) {
            puck1X += puckSpeed;
        }

        if (upPressed && puck2Y > 8) {
            puck2Y -= puckSpeed;
        }

        if (downPressed && puck2Y < height - 38) {
            puck2Y += puckSpeed;
        }

        if (leftPressed && puck2X > 400 + radius) {
            puck2X -= puckSpeed;
        }

        if (rightPressed && puck2X < width - 38) {
            puck2X += puckSpeed;
        }
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            sPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            aPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            dPressed = true;
        }

        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            sPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            aPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            dPressed = false;
        }

        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        AirHockey a = new AirHockey();
        a.repaint();
    }
}
