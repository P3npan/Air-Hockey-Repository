package game;

import java.awt.Color;
import java.awt.Graphics;

public class Board {
	
	private Border goalLeft;
	private Border goalRight;
	private Border leftTopBorder;
	private Border leftBottomBorder;
	private Border rightTopBorder;
	private Border rightBottomBorder;
	private Border topBorder;
	private Border bottomBorder;
	
	    
	public Board() {
        this.goalLeft = new Border(0, 125, 8, 150);
        this.goalRight = new Border(792, 125, 8, 150);
        this.leftTopBorder = new Border(0, 0, 8, 127);
        this.leftBottomBorder = new Border(0, 273, 8, 150);
        this.rightTopBorder = new Border(792, 0, 8, 127);
        this.rightBottomBorder = new Border(792, 273, 8, 150);
        this.topBorder = new Border(0, 0, 800, 8);
        this.bottomBorder = new Border(0, 392, 800, 8);
    }

    public void draw(Graphics brush) {
        brush.setColor(Color.white);
        brush.fillRect(0, 0, 800, 428);
        brush.setColor(Color.red);
        brush.drawOval(-75, 125, 150, 150);
        brush.drawOval(725, 125, 150, 150);
        brush.drawOval(360, 160, 80, 80);
        brush.fillOval(390, 190, 20, 20);
        brush.fillRect(399, 0, 2, 400);

        goalLeft.drawRectangle(brush, Color.red);
        goalRight.drawRectangle(brush, Color.red);
        leftTopBorder.drawRectangle(brush, Color.black);
        leftBottomBorder.drawRectangle(brush, Color.black);
        rightTopBorder.drawRectangle(brush, Color.black);
        rightBottomBorder.drawRectangle(brush, Color.black);
        topBorder.drawRectangle(brush, Color.black);
        bottomBorder.drawRectangle(brush, Color.black);
    }
	
	public Border getGoalLeft() {
	    return goalLeft;
	}

	public Border getGoalRight() {
	    return goalRight;
	}

	public Border getLeftTopBorder() {
	    return leftTopBorder;
	}

	public Border getLeftBottomBorder() {
	    return leftBottomBorder;
	}

	public Border getRightTopBorder() {
	    return rightTopBorder;
	}

	public Border getRightBottomBorder() {
	    return rightBottomBorder;
	}

	public Border getTopBorder() {
	    return topBorder;
	}

	public Border getBottomBorder() {
	    return bottomBorder;
	}
}
