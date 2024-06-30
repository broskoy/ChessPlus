package all;

public class Board {

    // constants for the size of the chess board
    public static final int HEIGHT = 8;
    public static final int WIDTH = 8;


    private int [][] matrix = new int[HEIGHT][WIDTH];

    public Board() {
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                matrix[i][j] = 0;
            }
        }
    }
}
