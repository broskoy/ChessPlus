package all;


public class Rook extends Piece {

    public Rook(String newColor) {
        type = "rook";
        color = newColor;
        fetchImage();
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}