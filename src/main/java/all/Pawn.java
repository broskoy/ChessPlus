package all;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Pawn extends Piece {

    public Pawn(String color) {
        this.type = "pawn";
        this.color = color;
        fetchImage();
    }

    private void fetchImage() {
        try {
            if (color == "white")
                image = ImageIO.read(Piece.class.getResourceAsStream("/pawn_white.jpg"));
            else image = ImageIO.read(Piece.class.getResourceAsStream("/pawn_black.jpg"));
            
        } catch (IOException exception){
            // handle
        }
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
