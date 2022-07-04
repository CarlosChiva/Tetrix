package pieces;

public class Q extends Pieces {


    public Q() {
        setArray(getPieceQ());
    }

    public int[][] getPieceQ() {
        piece[0][0] = 1;
        piece[1][0] = 1;
        piece[0][1] = 1;
        piece[1][1] = 1;

        return piece;
    }
}
