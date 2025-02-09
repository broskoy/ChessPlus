package all;


public class Queen extends Piece {

    public Queen(int row, int col, GamePanel.PType type, GamePanel.PColor color) {
        super(row, col, type, color);
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}