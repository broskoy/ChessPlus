package all;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame extends JFrame{
    
    final static int HEIGHT = 640;
    final static int WIDTH = 1080;
    GamePanel gamePanel;

    public Frame() {
        addGamePanel();

        // window settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH + 50, HEIGHT + 70);
        this.setResizable(false);
        this.setTitle("Gravity Simulation");
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(null);
        this.setVisible(true);
    }    

    private void addGamePanel() {
        // initialize the simulation panel
        gamePanel = new GamePanel();
        this.getLayeredPane().add(gamePanel, Integer.valueOf(1));
        gamePanel.requestFocus();
    }
}