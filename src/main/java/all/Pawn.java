package all;

import all.GamePanel.PColor;

public class Pawn extends Piece {

    public Pawn(int row, int col, GamePanel.PType type, GamePanel.PColor color) {
        super(row, col, type, color);
    }

    @Override
    protected boolean validMove(int rowNew, int colNew) {
        if (color == PColor.white) {
            if (row == 1 && rowNew == 3)
                return true;

            if (rowNew == row + 1)
                return true;
        } 

        if (color == PColor.black) {
            if (row == 6 && rowNew == 4) 
                return true; 
            
            if (rowNew == row - 1)
                return true;
        }

        return false;
    }
}
