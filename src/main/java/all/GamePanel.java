package all;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, MouseListener {

    // the fps at which the game is rendered
    final static int FPS = 10;

    // constant for the size of the chess board
    public static final int BOARDSIZE = 8;

    // size of tiles that is also used for the border
    int tileSize = MainFrame.HEIGHT / (BOARDSIZE + 2);

    // where the pieces will be stored
    Piece[][] board = new Piece[BOARDSIZE][BOARDSIZE];

    // allocate a thread to run 
    Thread gameThread;

    // the variable used to move pieces
    boolean moveSelected = false;
    Point moveFrom = new Point();

    // constructor
    public GamePanel() {
        //panel settings
        this.setSize(MainFrame.HEIGHT, MainFrame.HEIGHT);
        this.setBackground(new Color(48, 46, 43));
        this.setLocation(0, 0);
        this.setLayout(null);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setVisible(true);
        addMouseListener(this);

        // initialize the board
        spawnDefault();

        // start the thread
        gameThread = new Thread(this);
        gameThread.start();
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

    // handles the logic of the game
    private void update() {
        
    }

    // handles what is painted each frame
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawBoard(g2d);
        drawSelectedTile(g2d);
        drawPieces(g2d);
        drawText(g2d);

        g2d.dispose();
    }
    
    // draws the lines bounding the tiles
    private void drawBoard(Graphics2D g2d) {

        g2d.setColor(Color.gray);

        // draw horizontal lines
        for (int i=0; i<9; i++)
            g2d.drawLine(tileSize, (1 + i) * tileSize, MainFrame.HEIGHT - tileSize, (1 + i) * tileSize);

        // draw vertical lines
        for (int i=0; i<9; i++)
            g2d.drawLine((1 + i) * tileSize, tileSize, (1 + i) * tileSize, MainFrame.HEIGHT - tileSize);
    }

    private void drawSelectedTile(Graphics2D g2d) {
        if (moveSelected) {
            g2d.setColor(new Color(255, 255, 255, 150));
            g2d.fillRect((moveFrom.x + 1)*tileSize, (moveFrom.y + 1)*tileSize, tileSize, tileSize);
        }
    }

    // goes through the pieces and draws their image on the tile
    private void drawPieces(Graphics2D g2d) {

        for (int i=0; i<BOARDSIZE; i++) {
            for (int j=0; j<BOARDSIZE; j++) {
                if (board[i][j] != null) {
                    int imageX = (int) ((1.05 + j) * tileSize);
                    int imageY = (int) ((1.05 + i) * tileSize);
                    int resizeX = (int) (0.9*tileSize);
                    int resizeY = (int) (0.9*tileSize);
                    g2d.drawImage(board[i][j].image, imageX, imageY, resizeX, resizeY, null);
                }
            }
        }
    }

    // draws the names of the opponents
    private void drawText(Graphics2D g2d) {
        g2d.setColor(Color.gray);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 24)); 
        g2d.drawString("GM Bozo", tileSize, (int) (0.7 * tileSize));
        g2d.drawString("GM Baka", tileSize, (int) ((1.7 + BOARDSIZE) * tileSize));
    }

    // puts the default pieces on the board
    private void spawnDefault() {
        // the white position
        for (int j=0; j<8; j++) 
            board[1][j] = new Pawn("white");

        board[0][0] = new Rook("white");
        board[0][1] = new Horse("white");
        board[0][2] = new Bishop("white");
        board[0][3] = new Queen("white");
        board[0][4] = new King("white");
        board[0][5] = new Bishop("white");
        board[0][6] = new Horse("white");
        board[0][7] = new Rook("white");


        // the black position
        for (int j=0; j<8; j++) 
            board[6][j] = new Pawn("black");

        board[7][0] = new Rook("black");
        board[7][1] = new Horse("black");
        board[7][2] = new Bishop("black");
        board[7][3] = new Queen("black");
        board[7][4] = new King("black");
        board[7][5] = new Bishop("black");
        board[7][6] = new Horse("black");
        board[7][7] = new Rook("black");
    }

    private void movePiece(Point from, Point to) {
        Piece piece = board[from.y][from.x];

        // SidePanel.print(codeNotation(PType.pawn, from, to) + "\n");

        if (board[from.y][from.x] == null)
            throw new IllegalArgumentException("No piece at source position.");

        board[to.y][to.x] = piece;
        board[from.y][from.x] = null;
        
        SidePanel.print(codeNotation(board[to.y][to.x].type, from, to) + "\n");
        // SidePanel.print(chessNotation(piece.type, from, to) + "\n");    
    }

    @SuppressWarnings("unused")
    private String chessNotation(String type, Point from, Point to) {
        String returnString = "";

        switch (type) {
            case "pawn" -> returnString += "P";
            case "horse" -> returnString += "H";
            case "bishop" -> returnString += "B";
            case "rook" -> returnString += "R";
            case "queen" -> returnString += "Q";
            case "king" -> returnString += "K";
            default -> throw new AssertionError();
        }

        switch (from.x) {
            case 0 -> returnString += "h";
            case 1 -> returnString += "g";
            case 2 -> returnString += "f";
            case 3 -> returnString += "e";
            case 4 -> returnString += "d";
            case 5 -> returnString += "c";
            case 6 -> returnString += "b";
            case 7 -> returnString += "a";
            default -> throw new AssertionError();
        }
        returnString += from.y + 1;

        switch (to.x) {
            case 0 -> returnString += "h";
            case 1 -> returnString += "g";
            case 2 -> returnString += "f";
            case 3 -> returnString += "e";
            case 4 -> returnString += "d";
            case 5 -> returnString += "c";
            case 6 -> returnString += "b";
            case 7 -> returnString += "a";
            default -> throw new AssertionError();
        }
        returnString += to.y + 1;

        return returnString;
    }

    private String codeNotation(String type, Point from, Point to) {
        String returnString = "";

        switch (type) {
            case "pawn" -> returnString += "P";
            case "horse" -> returnString += "H";
            case "bishop" -> returnString += "B";
            case "rook" -> returnString += "R";
            case "queen" -> returnString += "Q";
            case "king" -> returnString += "K";
            default -> throw new AssertionError();
        }
        returnString += from.x;
        returnString += from.y;
        returnString += to.x;
        returnString += to.y;

        return returnString;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // save event while dividing by tilesize and removeing buffer
        Point click = new Point();
        click.x = e.getX() / tileSize - 1;
        click.y = e.getY() / tileSize - 1;

        // if the click is on the board
        if ((0 <= click.x) && (click.x < BOARDSIZE) && (0 <= click.y) && (click.y < BOARDSIZE)) {
            // if a from has not been selected
            if (!moveSelected) {
                moveFrom.x = click.x;
                moveFrom.y = click.y;
            } else {
                // TODO: remove select if pressing the same tile
                movePiece(moveFrom, click);
            }
            // when valid it always flips
            moveSelected = !moveSelected;
        } else {
            moveSelected = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
