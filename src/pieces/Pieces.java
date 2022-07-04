package pieces;

public class Pieces implements IPieces {
    int[][] piece = new int[3][3];

    public Pieces(int[][] piece) {
        this.piece = piece;
    }

    public Pieces() {
    }
    @Override
    public int getValuesArray(int x, int y) {
        return piece[x][y];
    }

    @Override
    public void setArray(int[][] array) {
        piece = array;
    }
}
