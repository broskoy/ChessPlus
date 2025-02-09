package all;

import java.io.IOException;

import javax.imageio.ImageIO;


public class Rook extends Piece {

    public Rook(int row, int col, GamePanel.PType type, GamePanel.PColor color) {
        super(row, col, type, color);
        try {
            this.image = ImageIO.read(Rook.class.getResourceAsStream("/rook_white.jpg"));
        } catch(IOException exception) {

        }
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}