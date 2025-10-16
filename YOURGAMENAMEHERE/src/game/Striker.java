package game;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

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
    
    private final Map<Integer, Runnable> keyPressActions;
    private final Map<Integer, Runnable> keyReleaseActions;


    public Striker(int startX, int startY, Color color, boolean isLeftSide) {
        this.x = startX;
        this.y = startY;
        this.color = color;
        this.isLeftSide = isLeftSide;
        
        if (isLeftSide) {
            keyPressActions = Map.of(
                KeyEvent.VK_W, () -> upPressed = true,
                KeyEvent.VK_S, () -> downPressed = true,
                KeyEvent.VK_A, () -> leftPressed = true,
                KeyEvent.VK_D, () -> rightPressed = true
            );

            keyReleaseActions = Map.of(
                KeyEvent.VK_W, () -> upPressed = false,
                KeyEvent.VK_S, () -> downPressed = false,
                KeyEvent.VK_A, () -> leftPressed = false,
                KeyEvent.VK_D, () -> rightPressed = false
            );
        } else {
            keyPressActions = Map.of(
                KeyEvent.VK_UP, () -> upPressed = true,
                KeyEvent.VK_DOWN, () -> downPressed = true,
                KeyEvent.VK_LEFT, () -> leftPressed = true,
                KeyEvent.VK_RIGHT, () -> rightPressed = true
            );

            keyReleaseActions = Map.of(
                KeyEvent.VK_UP, () -> upPressed = false,
                KeyEvent.VK_DOWN, () -> downPressed = false,
                KeyEvent.VK_LEFT, () -> leftPressed = false,
                KeyEvent.VK_RIGHT, () -> rightPressed = false
            );
        }
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
            if (leftPressed && x > 385 + radius) {
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

    
    public KeyListener getKeyListener() {
        return new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
            	keyPressActions.getOrDefault(e.getKeyCode(), () -> {}).run();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            	keyReleaseActions.getOrDefault(e.getKeyCode(), () -> {}).run();
            }

            @Override
            public void keyTyped(KeyEvent e) {}
        };
    }
}
