package se.hig.cg.practical1.hermite;

public class Hermite 
{	
	public Hermite()
	{	
		

		
		/*
		thing = (1 - 3*u2 + 2*u3) * p0 + //pk = 2u3-3u2+1
				(3*u2 - 2*u3) * p1	+	 //pk+1 = -2u3 + 3u2	
				(u - 2*u2 + u3) * v0 +	 //Dpk = u3-2u2 + u	
				(-u2 + u3) * v1		  	 //Dpk+1 = u3 - u2
				;
		*/
		
		/*
		double a = 2*Math.pow(pk, 3) - 2*Math.pow(pk1, 2) + dpk + dpk1;
		double b = -3*Math.pow(pk, 3) + 3*Math.pow(pk1, 2) - 2*dpk - dpk1;
		double c = dpk;
		double d = Math.pow(pk, 3);
		*/
		
		 
		
		//???
		
	}
	
	public double calculateHermite(double pk, double pk1, double dpk, double dpk1, double u)//start point, start tangent, end point, end tangent
	{
		double u2 = u * u;
		double u3 = u * u2;
		return (2*pk - 2*pk1 + dpk + 2*dpk1) * u3 + (-3*pk + 3*pk1 - 2*dpk - dpk1) * u2 + dpk * u + dpk1;
	}
	
}
