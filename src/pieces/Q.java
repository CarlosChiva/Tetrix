package pieces;

public class Q {
    int[][] pieceQ = new int[3][3];

    public Q() {
    }

    public int[][] getPieceQ() {
        pieceQ[0][0] = 1;
        pieceQ[1][0] = 1;
        pieceQ[0][1] = 1;
        pieceQ[1][1] = 1;

        return pieceQ;
    }
}
