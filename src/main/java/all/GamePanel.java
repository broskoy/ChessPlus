package all;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    // allocate a thread to run 
    Thread gameThread;

    // the fps at which the game is rendered
    final static int FPS = 60;

    // constant for the size of the chess board
    public static final int BOARDTILES = 8;

    // size of tiles that is also used for the border
    int tileSize = MainFrame.HEIGHT / (BOARDTILES + 2);

    // where the pieces will be stored
    ArrayList<Piece> board = new ArrayList<>();

    enum PType {
        king,
        pawn,
        horse,
        bishop,
        rook,
        queen;
    }

    enum PColor {
        white,
        black;
    }

    // constructor
    public GamePanel() {
        //panel settings
        this.setSize(MainFrame.HEIGHT, MainFrame.HEIGHT);
        this.setBackground(new Color(48, 46, 43));
        this.setLocation(0, 0);
        // this.addKeyListener(keyHandler);
        // this.setLayout(null);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setVisible(true);
        
        // start the thread
        gameThread = new Thread(this);
        gameThread.start();

        // initialize the board
        spawnDefault();
    }

    @Override
    public void run() {

        // calculations are in nanoseconds nextDrawTime is the next frame
        double drawInterval = 1e9 / FPS; 
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {

            update();

            repaint();

            try {
                // the target time minus current time
                double remainingTime = nextDrawTime - System.nanoTime();
                
                // avoiding negatives and convert from nano to milisecods
                remainingTime = Math.max(remainingTime, 0) / 1e6;

                // wait until next draw
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        drawBoard(g);

        g.dispose();
    }

    public void drawBoard(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.gray);

        // draw horizontal lines
        for (int i=0; i<9; i++)
            g2d.drawLine(tileSize, (1 + i) * tileSize, MainFrame.HEIGHT - tileSize, (1 + i) * tileSize);

        // draw vertical lines
        for (int i=0; i<9; i++)
            g2d.drawLine((1 + i) * tileSize, tileSize, (1 + i) * tileSize, MainFrame.HEIGHT - tileSize);

        // g2d.setColor(Color.blue);

        for (Piece piece : board) {
            int imageX = (int) ((1.05 + piece.col) * tileSize);
            int imageY = (int) ((1.05 + piece.row) * tileSize);
            int resizeX = (int) (0.9*tileSize);
            int resizeY = (int) (0.9*tileSize);
            g2d.drawImage(piece.image, imageX, imageY, resizeX, resizeY, null);
        }
    }

    // spawns a piece
    private void spawn(int row, int col, PType type, PColor player) {
        board.add(new Piece(row, col, type, player));
    }

    // puts the default pieces on the board
    private void spawnDefault() {
        // the white position
        for (int j=0; j<8; j++) 
            spawn(1, j, PType.pawn, PColor.white);

        spawn(0, 0, PType.rook, PColor.white);
        spawn(0, 1, PType.horse, PColor.white);
        spawn(0, 2, PType.bishop, PColor.white);
        spawn(0, 3, PType.queen, PColor.white);
        spawn(0, 4, PType.king, PColor.white);
        spawn(0, 5, PType.bishop, PColor.white);
        spawn(0, 6, PType.horse, PColor.white);
        spawn(0, 7, PType.rook, PColor.white);

        // the black position
        for (int j=0; j<8; j++) 
            spawn(6, j, PType.pawn, PColor.black);

        spawn(7, 0, PType.rook, PColor.black);
        spawn(7, 1, PType.horse, PColor.black);
        spawn(7, 2, PType.bishop, PColor.black);
        spawn(7, 3, PType.queen, PColor.black);
        spawn(7, 4, PType.king, PColor.black);
        spawn(7, 5, PType.bishop, PColor.black);
        spawn(7, 6, PType.horse, PColor.black);
        spawn(7, 7, PType.rook, PColor.black);
    }
}
