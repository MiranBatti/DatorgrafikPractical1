package se.hig.cg.practical1.hermite;

public class Point {
    private int X = 0;
    private int Y = 0;
    private Vector direction = new Vector();

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public Point() {

    }

    public void setDirection(Vector v) {
        direction.setVector(v);
    }

    public Vector getDirection() {
        return direction;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
