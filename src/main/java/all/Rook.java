package all;

import javax.imageio.ImageIO;


public class Rook extends Piece {

    public Rook(int row, int col, GamePanel.PType type, GamePanel.PColor color) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.color = color;
        this.image = ImageIO.read(Rook.class.getResourceAsStream("/rook_white.jpg"));
    }

    @Override
    protected boolean validMove(int row, int col) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}