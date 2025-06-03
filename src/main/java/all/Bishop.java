package all;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Bishop extends Piece {

    public Bishop(String color) {
        this.type = "bishop";
        this.color = color;
        fetchImage();
    }

    private void fetchImage() {
        try {
            if (color == "white")
                image = ImageIO.read(Piece.class.getResourceAsStream("/bishop_white.jpg"));
            else image = ImageIO.read(Piece.class.getResourceAsStream("/bishop_black.jpg"));
            
        } catch (IOException exception){
            // handle
        }
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}