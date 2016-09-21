package se.hig.cg.practical1.hermite;

public class Hermite 
{
	double thing;
	
	public Hermite(double p0, double v0, double p1, double v1, double u)	//start point, start tangent, end point, end tangent
	{		
		double u2 = u * u;
		double u3 = u * u2;
		
		thing = (1 - 3*u2 + 2*u3) * p0 + //pk = 2u3-3u2+1
				 (3*u2 - 2*u3) * p1	+	  //pk+1 = -2u3 + 3u2	
				 (u - 2*u2 + u3) * v0 +	  //Dpk = u3-2u2 + u	
				 (-u2 + u3) * v1		  //Dpk+1 = u3 - u2
				;
		
		//???
		
	}
	
}
