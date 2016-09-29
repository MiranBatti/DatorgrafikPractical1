package se.hig.cg.practical1.hermite;

public class ViewerMain
{
    public static void main (String[] args)
    {    	
        HermiteViewerPanel panel = new HermiteViewerPanel(new Hermite());
        ViewerWindow win = new ViewerWindow ("Hermite Spline Viewer", panel);
        win.setVisible (true);
    }
}
