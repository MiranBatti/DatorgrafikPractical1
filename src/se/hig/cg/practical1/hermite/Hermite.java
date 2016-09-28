package se.hig.cg.practical1.hermite;

public class Hermite 
{	
	private Point startPoint, endPoint, startTangent, endTangent;
	
	public Hermite()
	{
		this(new Point(50, 300), new Point(300, 300), new Point(50, 100), new Point(300, 100));
	}
	
	public Hermite(Point startPoint, Point endPoint, Point startTangent, Point endTangent)
	{	
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
		this.startTangent = startTangent;
		this.endTangent = endTangent;
		
		/*
		thing = (1 - 3*u2 + 2*u3) * p0 + //pk = 2u3-3u2+1
				(3*u2 - 2*u3) * p1	+	 //pk+1 = -2u3 + 3u2	
				(u - 2*u2 + u3) * v0 +	 //Dpk = u3-2u2 + u	
				(-u2 + u3) * v1		  	 //Dpk+1 = u3 - u2
				;s
		*/
		
		/*
		double a = 2*Math.pow(pk, 3) - 2*Math.pow(pk1, 2) + dpk + dpk1;
		double b = -3*Math.pow(pk, 3) + 3*Math.pow(pk1, 2) - 2*dpk - dpk1;
		double c = dpk;
		double d = Math.pow(pk, 3);
		*/
	}
	
	private Point calculateHermite(Point pk, Point pk1, Point dpk, Point dpk1, double u)//start point, end point, start tangent, end tangent
	{	
		double u2 = u * u;
		double u3 = u * u2;

		double x = ((2*pk.getX() - 2*pk1.getX() + dpk.getX() + dpk1.getX()) * u3) + ((-3*pk.getX() + 3*pk1.getX() - 2*dpk.getX() - dpk1.getX()) * u2) + (dpk.getX() * u) + pk.getX();
		double y = ((2*pk.getY() - 2*pk1.getY() + dpk.getY() + dpk1.getY()) * u3) + ((-3*pk.getY() + 3*pk1.getY() - 2*dpk.getY() - dpk1.getY()) * u2) + (dpk.getY() * u) + pk.getY();

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
	
	public Point[] getConstraintPoints()
	{
		Point[] points = new Point[4];
		
		points[0] = startPoint;
		points[1] = endPoint;
		points[2] = startTangent;
		points[3] = endTangent;
		
		return points;
	}
	
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
	
	/*
	private void calculateHermite2(Point pk, Point pk1, Point dpk, Point dpk1, int nbrOfPoints)//start point, end point, start tangent, end tangent
	{
		double[] pX = new double[nbrOfPoints];
		double[] pY = new double[nbrOfPoints];
		
		for (int t=0; t < nbrOfPoints; t++)
		{
		  double s = (double)t / (double)nbrOfPoints;    // scale s to go from 0 to 1
		  double h1 =  2*Math.pow(s, 3) - 3*Math.pow(s, 2) + 1;          // calculate basis function 1
		  double h2 = -2*Math.pow(s, 3) + 3*Math.pow(s, 2);              // calculate basis function 2
		  double h3 =   Math.pow(s, 3) - 2*Math.pow(s, 2) + s;         // calculate basis function 3
		  double h4 =   Math.pow(s, 3) - Math.pow(s, 2);              // calculate basis function 4
		  
		  pX[t] =    h1*pk.getX() +                    // multiply and sum all funtions
		             h2*pk1.getX() +                    // together to build the interpolated
		             h3*dpk.getX() +                    // point along the curve.
		             h4*dpk1.getX();
		  
		  pY[t] =    h1*pk.getY() +                    // multiply and sum all funtions
		             h2*pk1.getY() +                    // together to build the interpolated
		             h3*dpk.getY() +                    // point along the curve.
		             h4*dpk1.getY();
		}
		
		intX = new int[pX.length];
		for (int i=0; i<intX.length; ++i)
		    intX[i] = (int) pX[i];
		
		intY = new int[pY.length];
		for (int i=0; i<intY.length; ++i)
		    intY[i] = (int) pY[i];
		
	}
	*/
	
	public Point getStartPoint() {
		return startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public Point getStartTangent() {
		return startTangent;
	}

	public Point getEndTangent() {
		return endTangent;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public void setStartTangent(Point startTangent) {
		this.startTangent = startTangent;
	}

	public void setEndTangent(Point endTangent) {
		this.endTangent = endTangent;
	}
	
}
