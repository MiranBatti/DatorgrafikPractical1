package se.hig.cg.practical1.rasterizer;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RasterViewerMain
{
    public static void main (String[] args)
    {
    	try {
			Rasterizer rasterizer = new Rasterizer (800, 600);
	    	
	        RasterViewerPanel panel = new RasterViewerPanel (rasterizer.getRasterImage ());
	        RasterViewerWindow win = new RasterViewerWindow ("Raster Viewer", panel);
	        win.setResizable(false);
	        
	        rasterizer.rasterizeLine(0, 0, 800, 600);
	        
	        File imageFile = new File ("raster.png");
	        ImageIO.write(rasterizer.getRasterImage (), "png", imageFile);
	        
	        win.setVisible (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
