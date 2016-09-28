package se.hig.cg.practical1.hermite;

public class Vector {
    private double X = 0;
    private double Y = 0;

    public Vector(double x, double y) {
        X = x;
        Y = y;
    }

    public Vector() {
        X = 0;
        Y = 0;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setVector(Vector v) {
        X = v.getX();
        Y = v.getY();
    }
}
