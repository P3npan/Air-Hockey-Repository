package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class AirHockey extends Game {
	static int counter = 0;

  public AirHockey() {
    super("Air Hockey",800,400);
    this.setFocusable(true);
	this.requestFocus();
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.white);
    	brush.fillRect(0,0,width,height);
    	brush.setColor(Color.red);
    	brush.drawOval(-75, 125, 150, 150);
    	brush.drawOval(725, 125, 150, 150);
    	brush.drawOval(360, 160, 80, 80);
    	brush.fillOval(390, 190, 20, 20);
    	brush.fillRect(399, 0, 2, 400);
    	brush.setColor(Color.red);
    	brush.fillRect(0, 125, 8, 150);
    	brush.fillRect(792, 125, 8, 150);
    	brush.setColor(Color.black);
    	brush.fillRect(0, 0, 8, 127);
    	brush.fillRect(0, 273, 8, 150);
    	brush.fillRect(792, 0, 8, 127);
    	brush.fillRect(792, 273, 8, 150);
    	brush.fillRect(0, 0, 800, 8);
    	brush.fillRect(0, 364, 800, 8);
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	brush.setColor(Color.white);
    	brush.drawString("Counter is " + counter,10,10);
  }
  
	public static void main (String[] args) {
   		AirHockey a = new AirHockey();
		a.repaint();
  }
}