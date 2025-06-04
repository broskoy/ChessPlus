package all;

public class Pawn extends Piece {

    public Pawn(String newColor) {
        type = "pawn";
        color = newColor;
        fetchImage();
    }

    @Override
    protected boolean validMove(int rowNew, int colNew) {
        //     if (color == PColor.white) {
        //         if (row == 1 && rowNew == 3)
        //             return true;

        //         if (rowNew == row + 1)
        //             return true;
        //     } 

        //     if (color == PColor.black) {
        //         if (row == 6 && rowNew == 4) 
        //             return true; 
                
        //         if (rowNew == row - 1)
        //             return true;
        //     }

        return false;
    }
}
