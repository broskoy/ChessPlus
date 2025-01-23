package all;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SidePanel extends JPanel{

    static JTextArea panelText;
    public int width = MainFrame.WIDTH - MainFrame.HEIGHT;
    public int height = MainFrame.HEIGHT;

    public SidePanel() {
        //panel settings
        this.setSize(width, height);
        this.setBackground(new Color(38, 37, 34));
        this.setLocation(MainFrame.HEIGHT, 0);
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setVisible(true);

        // text area settings
        panelText = new JTextArea();
        panelText.setText(null);
        panelText.setBackground(new Color(38, 37, 34));
        panelText.setForeground(Color.white);
        panelText.setEditable(false);
        panelText.setBorder(BorderFactory.createEmptyBorder(
            (int) (0.1 * width), (int) (0.1 * height), (int) (0.1 * width), (int) (0.1 * height)));
        panelText.setLineWrap(true);
        panelText.setFocusable(false);
        panelText.setOpaque(true);
        this.add(panelText);
    }

    // handles what is painted each frame
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.dispose();
    }

    public static void print(String text) {
        panelText.append(text);
    }
}
