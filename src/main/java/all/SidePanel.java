package all;

import java.awt.Color;

import javax.swing.JPanel;

public class SidePanel extends JPanel{

    public SidePanel() {
        //panel settings
        this.setSize(MainFrame.WIDTH-MainFrame.HEIGHT, MainFrame.HEIGHT);
        this.setBackground(new Color(38, 37, 34));
        this.setLocation(MainFrame.HEIGHT, 0);
        // this.addKeyListener(keyHandler);
        //this.setLayout(null);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }
}
