package se.hig.cg.practical1.hermite;

import java.awt.Rectangle;

public class Point {
    private int X = 0;
    private int Y = 0;
    private final int WIDTH = 30; //Rectangle boundary width
    private final int HEIGHT = 30;
    private Rectangle rect;


    public Point(int x, int y) {
        X = x;
        Y = y;
        createBounds();
    }

    public Point() {

    }

    public void setPoint(int x, int y)
    {
    	X = x;
    	Y = y;
    	int upperLeftX = X - (WIDTH/2);
    	int upperLeftY = Y - (HEIGHT/2);
    	rect.setBounds(upperLeftX, upperLeftY, WIDTH, HEIGHT);    	
    }
    
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    private void createBounds()
    {
    	int upperLeftX = X - (WIDTH/2);
    	int upperLeftY = Y - (HEIGHT/2);
    	rect = new Rectangle(upperLeftX, upperLeftY, WIDTH, HEIGHT);
    }
    
    public Rectangle getPointBounds()
    {
    	return rect;
    }
    
}
