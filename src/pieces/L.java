package pieces;

public class L extends Pieces {
    public L() {
        setArray(getPieceL());
    }

    public int[][] getPieceL() {
        piece[0][0] = 1;
        piece[1][0] = 1;
        piece[2][0] = 1;
        piece[2][1] = 1;

        return piece;
    }
}
