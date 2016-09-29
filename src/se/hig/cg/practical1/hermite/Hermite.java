package se.hig.cg.practical1.hermite;

public class Hermite 
{	
	private Point startPoint, endPoint, startTangent, endTangent;
	
	public Hermite()
	{
		this(new Point(200, 300), new Point(500, 300), new Point(200, 100), new Point(500, 100));
	}
	
	public Hermite(Point startPoint, Point endPoint, Point startTangent, Point endTangent)
	{	
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
		this.startTangent = startTangent;
		this.endTangent = endTangent;
	}
	
	/**
	 * Algorithm calculates hermite curve.
	 * u is a value between 0 and 1.
	 * @param pk
	 * @param pk1
	 * @param dpk
	 * @param dpk1
	 * @param u
	 * @return
	 */
	private Point calculateHermite(Point pk, Point pk1, Point dpk, Point dpk1, double u)//start point, end point, start tangent, end tangent
	{	
		double u2 = u * u;
		double u3 = u * u2;

		double x = 	((2*pk.getX() - 2*pk1.getX() + dpk.getX() + dpk1.getX()) * u3) + 
					((-3*pk.getX() + 3*pk1.getX() - 2*dpk.getX() - dpk1.getX()) * u2) + 
					(dpk.getX() * u) + 
					pk.getX();
		
		double y = 	((2*pk.getY() - 2*pk1.getY() + dpk.getY() + dpk1.getY()) * u3) +
					((-3*pk.getY() + 3*pk1.getY() - 2*dpk.getY() - dpk1.getY()) * u2) + 
					(dpk.getY() * u) + 
					pk.getY();

		return new Point((int)x, (int)y);
	}
	
	private Point getPoint(double u)
	{
		return calculateHermite(startPoint, endPoint, startTangent, endTangent, u);
	}
	
	/**
	 * Baserat på kod av Viktor Hanstorp(ndi14vhp@student.hig.se)
	 * @param numberOfPoints
	 * @return
	 */
	public Point[] getPoints(int numberOfPoints)
	{
		Point[] points = new Point[numberOfPoints];
		
		for (int i = 0; i < numberOfPoints; i++) 
		{
			points[i] = getPoint((1d / (double) numberOfPoints) * (double) i);
		}
		
		return points;
	}
	
	/**
	 * Returns the points of the hermite as an array of points.
	 * @return
	 */
	public Point[] getConstraintPoints()
	{
		Point[] points = new Point[4];
		
		points[0] = startPoint;
		points[1] = endPoint;
		points[2] = startTangent;
		points[3] = endTangent;
		
		return points;
	}
	
	/**
	 * This is used to check one point is within another point's boundary rectangle.
	 * Needed so that mouse dragging won't merge 2 points to 1.
	 * @param point
	 * @return
	 */
	public boolean collisionDetection(Point point)
	{
		boolean collision = false;
		int collisions = 0;
		
		for (int i = 0; i < getConstraintPoints().length; i++) {
			if(point.getPointBounds().contains(getConstraintPoints()[i].getPointBounds()))
				collisions++;
		}
		
		if(collisions > 1)
			collision = true;
		
		return collision;
	}
	
	public Point getStartPoint()
	{
		return startPoint;
	}

	public Point getEndPoint()
	{
		return endPoint;
	}

	public Point getStartTangent()
	{
		return startTangent;
	}

	public Point getEndTangent()
	{
		return endTangent;
	}
	
	public void setStartPoint(Point startPoint) 
	{
		this.startPoint = startPoint;
	}

	public void setEndPoint(Point endPoint) 
	{
		this.endPoint = endPoint;
	}

	public void setStartTangent(Point startTangent) 
	{
		this.startTangent = startTangent;
	}

	public void setEndTangent(Point endTangent) 
	{
		this.endTangent = endTangent;
	}
	
	public void setStartPoint(int x, int y)
	{
		this.startPoint.setPoint(x, y);
	}

	public void setEndPoint(int x, int y) 
	{
		this.endPoint.setPoint(x, y);	
		}

	public void setStartTangent(int x, int y)
	{
		this.startTangent.setPoint(x, y);
	}

	public void setEndTangent(int x, int y)
	{
		this.endTangent.setPoint(x, y);
	}
	
}
