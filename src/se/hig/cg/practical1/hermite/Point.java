package se.hig.cg.practical1.hermite;

import java.awt.Rectangle;

public class Point {
    private int x = 0;
    private int y = 0;
    public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	private final int WIDTH = 30; //Rectangle boundary width.
    private final int HEIGHT = 30;
    private Rectangle rect;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        createBounds();
    }

    public Point() {
    	this(0, 0);
    }

    public void setPoint(int x, int y)
    {
    	this.x = x;
    	this.y = y;
    	int upperLeftX = this.x - (WIDTH/2);
    	int upperLeftY = this.y - (HEIGHT/2);
    	rect.setBounds(upperLeftX, upperLeftY, WIDTH, HEIGHT);    	
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    private void createBounds()
    {
    	int upperLeftX = x - (WIDTH/2);
    	int upperLeftY = y - (HEIGHT/2);
    	rect = new Rectangle(upperLeftX, upperLeftY, WIDTH, HEIGHT);
    }
    
    public Rectangle getPointBounds()
    {
    	return rect;
    }
    
}
