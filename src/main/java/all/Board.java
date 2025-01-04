package all;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Board {
    // constants for the size of the chess board
    public static final int BOARDHEIGHT = 8;
    public static final int BOARDWIDTH = 8;
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
    public Board() {
        spawnDefault();
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.gray);

        // draw horizontal lines
        for (int i=0; i<9; i++)
            g2d.drawLine(100, 100 + i*50, 500, 100 + i*50);

        // draw vertical lines
        for (int i=0; i<9; i++)
            g2d.drawLine(100 + i*50, 100, 100 + i*50, 500);
    }

    // spawns a piece
    public void spawn(int row, int col, PType type, PColor player) {
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