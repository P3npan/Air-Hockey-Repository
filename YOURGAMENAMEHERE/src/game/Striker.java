package game;

import java.awt.*;
import java.awt.event.*;

public class Striker implements Drawable{
    private int x;
    private int y;
    private int speed = 5;
    private int radius = 15;
    private Color color;
    private boolean isLeftSide;
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    public Striker(int startX, int startY, Color color, boolean isLeftSide) {
        this.x = startX;
        this.y = startY;
        this.color = color;
        this.isLeftSide = isLeftSide;
    }

    public void update(int width, int height) {
        if (upPressed && y > 8) {
            y -= speed;
        }
        if (downPressed && y < height - radius * 2 - 8) {
            y += speed;
        }

        if (isLeftSide) {
            if (leftPressed && x > 8) {
                x -= speed;
            }
            if (rightPressed && x < 400 - radius * 2) {
                x += speed;
            }
        } else {
            if (leftPressed && x > 400 + radius) {
                x -= speed;
            }
            if (rightPressed && x < width - radius * 2 - 8) {
                x += speed;
            }
        }
    }

    public void draw(Graphics brush) {
        brush.setColor(color);
        brush.fillOval(x, y, radius * 2, radius * 2);
    }

    public void handleKeyPress(KeyEvent e) {
        int code = e.getKeyCode();
        if (isLeftSide) {
            switch (code) {
                case KeyEvent.VK_W -> upPressed = true;
                case KeyEvent.VK_S -> downPressed = true;
                case KeyEvent.VK_A -> leftPressed = true;
                case KeyEvent.VK_D -> rightPressed = true;
            }
        } else {
            switch (code) {
                case KeyEvent.VK_UP -> upPressed = true;
                case KeyEvent.VK_DOWN -> downPressed = true;
                case KeyEvent.VK_LEFT -> leftPressed = true;
                case KeyEvent.VK_RIGHT -> rightPressed = true;
            }
        }
    }

    public void handleKeyRelease(KeyEvent e) {
        int code = e.getKeyCode();
        if (isLeftSide) {
            switch (code) {
                case KeyEvent.VK_W -> upPressed = false;
                case KeyEvent.VK_S -> downPressed = false;
                case KeyEvent.VK_A -> leftPressed = false;
                case KeyEvent.VK_D -> rightPressed = false;
            }
        } else {
            switch (code) {
                case KeyEvent.VK_UP -> upPressed = false;
                case KeyEvent.VK_DOWN -> downPressed = false;
                case KeyEvent.VK_LEFT -> leftPressed = false;
                case KeyEvent.VK_RIGHT -> rightPressed = false;
            }
        }
    }
}
