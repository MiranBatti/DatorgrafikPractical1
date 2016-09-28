package se.hig.cg.practical1.rasterizer;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Rasterizer
{
    private BufferedImage rasterImg;
    private WritableRaster raster;
    double scaleX, scaleY;
    
    public Rasterizer (int width, int height)
    {
        rasterImg = new BufferedImage (width, height, BufferedImage.TYPE_INT_RGB);
        raster = rasterImg.getRaster ();
        for (int i = 0; i < height - 1; i++)
            for (int k = 0; k < width - 1; k++)
            	// Black in all pixels:
                raster.setPixel(k, i, new int[]{0, 0, 0});
    }
    
    /*
     * Method for rasterizeLine.
     */
    public void rasterizeLine (int x0, int y0, int x1, int y1)
    {
    	float dX = (x1 - x0);
    	float dY = (y1 - y0);
    	float m = (dY / dX);	//slope
    	int x = x0;
    	float y = y0;
    	
    	while(x < x1)
    	{
    		raster.setPixel(x, Math.round(y), new int[]{255, 50, 100});
    		x += 1;
    		y += m;
    	}
    }
    
    public BufferedImage getRasterImage ()
    {
        return rasterImg;
    }
}
