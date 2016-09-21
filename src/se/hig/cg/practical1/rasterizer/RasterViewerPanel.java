package se.hig.cg.practical1.rasterizer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RasterViewerPanel extends JPanel
{
    private BufferedImage picture;

    public RasterViewerPanel(BufferedImage picture) {
        this.picture = picture;
        setSize(picture.getWidth (), picture.getHeight ());
    }

    /**
     * Ritar ut bilden i bildobjektet 'picture'.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (picture != null) {
            g2.drawImage(picture, null, 0, 0);
        }
    }
}