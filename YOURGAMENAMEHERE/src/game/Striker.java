package game;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

public class Striker implements Drawable{
	//Position variables
    private int x;
    private int y;
    
    //Sets speed of strikers
    private int speed = 5;
    
    //Sets size of strikers
    private int radius = 22;
    
    //Striker color
    private Color color;
    
    //Checks for left side striker
    private boolean isLeftSide;
    
    //Checks which movement condition is satisfied
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    
    private final Map<Integer, Runnable> keyPressActions;
    private final Map<Integer, Runnable> keyReleaseActions;

    //Instantiates the positions and colors of the strikers
    public Striker(int startX, int startY, Color color, boolean isLeftSide) {
        this.x = startX;
        this.y = startY;
        this.color = color;
        //Used to identify a left side striker as movement varies
        this.isLeftSide = isLeftSide;
        
        
        //Lambda functions in control of understanding keyboard input and updating movement permitting booleans accordingly
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

    //Updates the position of the Strikers upon movement
    public void update(int width, int height) {
    	//Series of if loops checking which keyboard input condition is true.
        if (upPressed && y > 8) {
            y -= speed;
        }
        if (downPressed && y < height - radius * 2 - 36) {
            y += speed;
        }

        if (isLeftSide) {
            if (leftPressed && x > 8) {
                x -= speed;
            }
            if (rightPressed && x < 395 - radius * 2) {
                x += speed;
            }
        } else {
            if (leftPressed && x > 380 + radius) {
                x -= speed;
            }
            if (rightPressed && x < width - radius * 2 - 8) {
                x += speed;
            }
        }
    }

    //In charge of drawing the strikers on the board when called from Board.java
    public void draw(Graphics brush) {
        brush.setColor(color);
        brush.fillOval(x, y, radius * 2, radius * 2);
    }

    //Anonymous KeyListner class only relevant for the Strikers since they are the only objects moved via Keyboard inputs
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
