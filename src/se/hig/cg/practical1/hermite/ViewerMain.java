package se.hig.cg.practical1.hermite;

public class ViewerMain
{
    public static void main (String[] args)
    {
    	/*
    	 * Instantiate here an HermiteSpline object
    	 * and assign it (or its data) to the viewer
    	 * panel below.
    	 */
    	
        HermiteViewerPanel panel = new HermiteViewerPanel ();
        ViewerWindow win = new ViewerWindow ("Hermite Spline Viewer", panel);
        Hermite s = new Hermite(1, 100, 10, 10, 20);
        win.setVisible (true);
    }
}
