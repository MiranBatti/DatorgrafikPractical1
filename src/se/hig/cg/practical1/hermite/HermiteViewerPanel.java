package se.hig.cg.practical1.hermite;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HermiteViewerPanel extends JPanel implements MouseListener, MouseMotionListener
{
	private int xPos, yPos;	
	Hermite hermite;
	
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
    	addMouseListener(this);
    }

    /**
     * Ritar ut bilden i bildobjektet 'picture'.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawOval(hermite.getStartPoint().getX(), hermite.getStartPoint().getY(), 4, 4);
        g2.drawString("Pk", hermite.getStartPoint().getX(), hermite.getStartPoint().getY());
        
        g2.drawOval(hermite.getEndPoint().getX(), hermite.getEndPoint().getY(), 4, 4);
        g2.drawString("Pk1", hermite.getEndPoint().getX(), hermite.getEndPoint().getY());
        
        g2.drawOval(hermite.getStartTangent().getX(), hermite.getStartTangent().getY(), 4, 4);
        g2.drawString("DPk", hermite.getStartTangent().getX(), hermite.getStartTangent().getY());
        
        g2.drawOval(hermite.getEndTangent().getX(), hermite.getEndTangent().getY(), 4, 4);
        g2.drawString("DPk1", hermite.getEndTangent().getX(), hermite.getEndTangent().getY());
        
        g2.drawLine(hermite.getStartPoint().getX(), hermite.getStartPoint().getY(), hermite.getStartTangent().getX(), hermite.getStartTangent().getY());
        g2.drawLine(hermite.getEndPoint().getX(), hermite.getEndPoint().getY(), hermite.getEndTangent().getX(), hermite.getEndTangent().getY());
        
        Point[] p = hermite.getPoints(100);
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

	@Override
	public void mouseClicked(MouseEvent e) {	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
        xPos = e.getXOnScreen();
        yPos = e.getYOnScreen();	
        
        hermite.setStartTangent(new Point(xPos, yPos));
        
        repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
}