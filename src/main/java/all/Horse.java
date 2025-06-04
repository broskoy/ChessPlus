package all;


public class Horse extends Piece {

    public Horse(String newColor) {
        type = "horse";
        color = newColor;
        fetchImage();
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}