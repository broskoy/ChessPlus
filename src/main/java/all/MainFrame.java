package all;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;


public class MainFrame extends JFrame{
    
    final static int HEIGHT = 640;
    final static int WIDTH = 1080;
    GamePanel gamePanel;
    SidePanel sidePanel;

    public static void main(String[] args) {
        new MainFrame();
    }

    public MainFrame() {
        addGamePanel();
        addSidePanel();

        // window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT + 35);
        this.setResizable(true);
        this.setTitle("Chess Plus");
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }    

    private void addGamePanel() {
        // initialize the simulation panel
        gamePanel = new GamePanel();
        this.add(gamePanel, BorderLayout.WEST);
        
        gamePanel.requestFocus();
    }

    private void addSidePanel() {
        // initialize the simulation panel
        sidePanel = new SidePanel();
        this.add(sidePanel, BorderLayout.EAST);
    }
}