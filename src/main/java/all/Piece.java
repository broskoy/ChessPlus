package all;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Piece {

    String type;
    String color;
    BufferedImage image;

    // returns true if the move is on the board
    protected boolean validBounds(int row, int col) {
        return ((0 <= row) && (row < GamePanel.BOARDSIZE) && 
                (0 <= col) && (col < GamePanel.BOARDSIZE));
    }

    protected void fetchImage() {
        try {
            String path = "/" + type + "_" + color + ".jpg";
            image = ImageIO.read(Piece.class.getResourceAsStream(path));
            
        } catch (IOException exception){
            // handle
        }
    }

    // returns true if the piece can do that move
    protected abstract boolean validMove(int row, int col);

    // if the emove is valid, it moves the piece
    // public void move(int row, int col) {
    //     SidePanel.print(validBounds(row, col) + "v" + validMove(row, col));
    //     if (validBounds(row, col) && validMove(row, col)) {
    //         this.row = row;
    //         this.col = col;
    //     } else {
    //         SidePanel.print(" invalid ");
    //     }
    // }
}