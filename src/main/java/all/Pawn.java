package all;


public class Pawn extends Piece {

    public Pawn(int row, int col, GamePanel.PType type, GamePanel.PColor color) {
        super(row, col, type, color);
    }

    @Override
    protected boolean validMove(int row, int col) {
        return true;
    }
}
