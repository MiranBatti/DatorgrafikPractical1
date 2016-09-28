package se.hig.cg.practical1.hermite;

import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HermiteViewerPanel extends JPanel
{
	private Hermite hermite;
	private java.awt.Point mousePt;
	
	/*
	 * Stub for the viewer panel.
	 * 
	 * TODO:
	 * - Add suitable parameters to the constructor
	 * - Store data as necessary in variables.
	 * - Implement the drawing code in method paintComponent.
	 */
    public HermiteViewerPanel() {
    	hermite = new Hermite();
    	setSize(800, 600);
        
    	this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    	this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePt = e.getPoint();
                repaint();
            }
        });
        
    	this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = e.getX();
                int dy = e.getY();
                if(hermite.getStartPoint().getPointBounds().contains(e.getPoint()))
                {
                	hermite.getStartPoint().setPoint(dx, dy);
                }
                
                else if(hermite.getEndPoint().getPointBounds().contains(e.getPoint()))
                {
                	hermite.getEndPoint().setPoint(dx, dy); 
                }
                
                else if(hermite.getStartTangent().getPointBounds().contains(e.getPoint()))
                {
                	hermite.getStartTangent().setPoint(dx, dy); 
                }
                
                else if(hermite.getEndTangent().getPointBounds().contains(e.getPoint()))
                {
                	hermite.getEndTangent().setPoint(dx, dy); 
                }
                
                repaint();
            }
        });
    }

    /**
     * Ritar ut bilden i bildobjektet 'picture'.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawRect((int)hermite.getStartPoint().getPointBounds().getX(),(int) hermite.getStartPoint().getPointBounds().getY(), (int)hermite.getStartPoint().getPointBounds().getWidth(), (int)hermite.getStartPoint().getPointBounds().getHeight());
        
        g2.drawString("Pk", hermite.getStartPoint().getX(), hermite.getStartPoint().getY());
        
        g2.drawOval(hermite.getEndPoint().getX(), hermite.getEndPoint().getY(), 4, 4);
        g2.drawString("Pk1", hermite.getEndPoint().getX(), hermite.getEndPoint().getY());
        
        g2.drawOval(hermite.getStartTangent().getX(), hermite.getStartTangent().getY(), 4, 4);
        g2.drawString("DPk", hermite.getStartTangent().getX(), hermite.getStartTangent().getY());
        
        g2.drawOval(hermite.getEndTangent().getX(), hermite.getEndTangent().getY(), 4, 4);
        g2.drawString("DPk1", hermite.getEndTangent().getX(), hermite.getEndTangent().getY());
        
        g2.drawLine(hermite.getStartPoint().getX(), hermite.getStartPoint().getY(), hermite.getStartTangent().getX(), hermite.getStartTangent().getY());
        g2.drawLine(hermite.getEndPoint().getX(), hermite.getEndPoint().getY(), hermite.getEndTangent().getX(), hermite.getEndTangent().getY());
        
        Point[] p = hermite.getPoints(20);
        int[] x = new int[p.length + 1];
        int[] y = new int[p.length + 1];
        
        for (int i = 0; i < p.length; i++) 
        {
			x[i] = p[i].getX();
			y[i] = p[i].getY();
		}
        
        x[p.length] = hermite.getEndPoint().getX();
        y[p.length] = hermite.getEndPoint().getY();
        
        g2.drawPolyline(x, y, p.length + 1);
    }
    
}