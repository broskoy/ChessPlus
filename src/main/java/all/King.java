package all;


public class King extends Piece {

    public King(String newColor) {
        type = "king";
        color = newColor;
        fetchImage();
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}