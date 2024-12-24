package all;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Board {
    // constants for the size of the chess board
    public static final int BHEIGHT = 8;
    public static final int BWIDTH = 8;
    ArrayList<Piece> board = new ArrayList<>();

    // TODO: enum
    // 1 king
    // 2 pawn
    // 3 knight
    // 4 bishop
    // 5 rook
    // 6 queen

    // TODO: enum
    // 0 ???
    // 1 white
    // 2 black

    // constructor
    public Board() {
        spawnDefault();
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    }

    // spawns a piece
    public void spawn(int row, int col, int type, int color) {
        board.add(new Piece(row, col, type, color));
    }

    // puts the default pieces on the board
    private void spawnDefault() {
        // the white position
        for (int j=0; j<8; j++) 
            spawn(1, j, 2, 1);

        spawn(0, 0, 5, 1);
        spawn(0, 1, 3, 1);
        spawn(0, 2, 4, 1);
        spawn(0, 3, 6, 1);
        spawn(0, 4, 1, 1);
        spawn(0, 5, 4, 1);
        spawn(0, 6, 3, 1);
        spawn(0, 7, 5, 1);

        // the black position
        for (int j=0; j<8; j++) 
            spawn(6, j, 2, 2);

        spawn(7, 0, 5, 2);
        spawn(7, 1, 3, 2);
        spawn(7, 2, 4, 2);
        spawn(7, 3, 6, 2);
        spawn(7, 4, 1, 2);
        spawn(7, 5, 4, 2);
        spawn(7, 6, 3, 2);
        spawn(7, 7, 5, 2);
    }
}