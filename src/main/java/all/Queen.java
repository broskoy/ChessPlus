package all;


public class Queen extends Piece {

    public Queen(String newColor) {
        type = "queen";
        color = newColor;
        fetchImage();
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}