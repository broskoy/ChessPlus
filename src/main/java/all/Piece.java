package all;

import all.Board.PColor;
import all.Board.PType;

public class Piece {

    int row; 
    int col;
    PType type;
    PColor color;

    public Piece(int row, int col, PType type, PColor color) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.color = color;
    }

    private boolean validate_move(int row, int col) {
        return true;
    }

    // if th emove is valid, it moves the piece
    public void move(int row, int col) {
        if (validate_move(row, col)) {
            this.row = row;
            this.col = col;
        }
    }
}