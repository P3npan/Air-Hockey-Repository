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
    
    Board airHockey = new Board();

    public void paint(Graphics brush) {

        airHockey.draw(brush);

        updatePucks();

        brush.setColor(Color.blue);
        brush.fillOval(puck1X, puck1Y, 30, 30);

        brush.setColor(Color.green);
        brush.fillOval(puck2X, puck2Y, 30, 30);

        counter++;
        brush.setColor(Color.white);
        brush.drawString("Counter is " + counter, 10, 10);
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
