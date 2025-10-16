package game;

import java.awt.*;
import java.awt.event.*;

public class Board implements Drawable{
	
	//Instantiates left and right goals
	private Goal goalLeft;
    private Goal goalRight;

    //Instantiates each border as an individual object
    private Border leftTopBorder;
    private Border leftBottomBorder;
    private Border rightTopBorder;
    private Border rightBottomBorder;
    private Border topBorder;
    private Border bottomBorder;
    
    //Instantiates the 2 strikers
    private Striker leftStriker;
    private Striker rightStriker;

    public Board() {
        this.goalLeft = new Goal(0, 125, 8, 150, Color.red);
        this.goalRight = new Goal(792, 125, 8, 150, Color.red);
        
        this.leftTopBorder = new Border(0, 0, 8, 127);
        this.leftBottomBorder = new Border(0, 273, 8, 150);
        this.rightTopBorder = new Border(792, 0, 8, 127);
        this.rightBottomBorder = new Border(792, 273, 8, 150);
        this.topBorder = new Border(0, 0, 800, 8);
        this.bottomBorder = new Border(0, 392, 800, 8);

        this.leftStriker = new Striker(200, 200, Color.blue, true);
        this.rightStriker = new Striker(600, 200, Color.green, false);
        
    }

    @Override
    public void draw(Graphics brush) {
    	
    	//Draws all non-interactive elements on the board
        brush.setColor(Color.white);
        brush.fillRect(0, 0, 800, 428);
        brush.setColor(Color.red);
        brush.drawOval(-75, 125, 150, 150);
        brush.drawOval(725, 125, 150, 150);
        brush.drawOval(360, 160, 80, 80);
        brush.fillOval(390, 190, 20, 20);
        brush.fillRect(399, 0, 2, 400);

        //Draws the goals via the draw method in inner class Goal
        goalLeft.draw(brush);
        goalRight.draw(brush);
        
        //Draws each border object via the drawRectangle method in Border class
        leftTopBorder.drawRectangle(brush, Color.black);
        leftBottomBorder.drawRectangle(brush, Color.black);
        rightTopBorder.drawRectangle(brush, Color.black);
        rightBottomBorder.drawRectangle(brush, Color.black);
        topBorder.drawRectangle(brush, Color.black);
        bottomBorder.drawRectangle(brush, Color.black);

        //Updates starting positions of strikers and then draws them on the board via the Striker draw method
        leftStriker.update(800, 428);
        rightStriker.update(800, 428);
        leftStriker.draw(brush);
        rightStriker.draw(brush);
    }
    
    //Goal inner class implemented since goal is a part of board but still a distinct interactive object
    public class Goal implements Drawable{
        private int x, y, width, height;
        private Color color;

        public Goal(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }
        
        @Override
        public void draw(Graphics brush) {
            brush.setColor(color);
            brush.fillRect(x, y, width, height);
        }
    }

    //Getters for all instance variables
    public Goal getGoalLeft() {
        return goalLeft;
    }

    public Goal getGoalRight() {
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
    
    public Striker getLeftStriker() {
        return leftStriker;
    }

    public Striker getRightStriker() {
        return rightStriker;
    }
}
