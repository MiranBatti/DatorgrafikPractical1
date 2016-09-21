package se.hig.cg.practical1.hermite;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ViewerWindow extends JFrame
{
    public ViewerWindow (String title, HermiteViewerPanel imgPanel)
    {
        setTitle (title);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel ();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        mainPanel.add(imgPanel, BorderLayout.CENTER);

        setMinimumSize (new Dimension(imgPanel.getWidth () + 10, imgPanel.getHeight () + 30));
        pack();
    }
}