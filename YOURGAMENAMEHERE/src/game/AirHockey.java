package game;

import java.awt.*;
import java.awt.event.*;
import game.Polygon;

class AirHockey extends Game implements KeyListener {
    static int counter = 0;

    public AirHockey() {
        super("Air Hockey", 800, 428);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocus();
    }
    
    Board airHockey = new Board();

    public void paint(Graphics brush) {

        airHockey.draw(brush);
        
        counter++;
        brush.setColor(Color.white);
        brush.drawString("Counter is " + counter, 10, 10);
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
