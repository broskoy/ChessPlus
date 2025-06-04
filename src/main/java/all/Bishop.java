package all;



public class Bishop extends Piece {

    public Bishop(String newColor) {
        type = "bishop";
        color = newColor;
        fetchImage();
    }


    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}