package se.hig.cg.practical1.hermite;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HermiteViewerPanel extends JPanel
{
	/*
	 * Stub for the viewer panel.
	 * 
	 * TODO:
	 * - Add suitable parameters to the constructor
	 * - Store data as necessary in variables.
	 * - Implement the drawing code in method paintComponent.
	 */
    public HermiteViewerPanel() {
    	setSize(800, 600);
    }

    /**
     * Ritar ut bilden i bildobjektet 'picture'.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawLine(10, 10, 790, 590);
        //g2.drawPolyline(xPoints, yPoints, nPoints);
    }
}