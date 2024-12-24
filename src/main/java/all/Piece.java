package all;

public class Piece {

    int row; 
    int col;
    int type;
    int color;

    public Piece(int row, int col, int type, int color) {
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