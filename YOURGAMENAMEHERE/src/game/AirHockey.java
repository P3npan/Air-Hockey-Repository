package game;

import java.awt.*;
import java.awt.event.*;

public class AirHockey extends Game{

    static int counter = 0;
    private Board airHockey;

    public AirHockey() {
    	super("Air Hockey", 800, 428);
        this.setFocusable(true);

        airHockey = new Board();


        this.addKeyListener(airHockey.getLeftStriker().getKeyListener());
        this.addKeyListener(airHockey.getRightStriker().getKeyListener());

        this.requestFocus();
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

    public static void main(String[] args) {
        AirHockey a = new AirHockey();
        a.repaint();
    }
}
