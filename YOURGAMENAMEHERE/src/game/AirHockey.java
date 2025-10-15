package game;

import java.awt.*;
import java.awt.event.*;

public class AirHockey extends Game implements KeyListener {

    static int counter = 0;
    private Board airHockey;

    public AirHockey() {
        super("Air Hockey", 800, 428);
        this.setFocusable(true);
        this.addKeyListener(this);
        this.requestFocus();
        airHockey = new Board();
    }

    @Override
    public void paint(Graphics brush) {
        if (airHockey != null) {
            airHockey.draw(brush);
        }

        counter++;
        brush.setColor(Color.white);
        brush.drawString("Counter is " + counter, 10, 10);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (airHockey != null) {
            airHockey.handleKeyPress(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (airHockey != null) {
            airHockey.handleKeyRelease(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void main(String[] args) {
        AirHockey a = new AirHockey();
        a.repaint();
    }
}
