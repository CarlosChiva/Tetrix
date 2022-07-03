package pieces;

public class S extends Pieces {
    int[][] pieceS = new int[3][3];

    public S() {

    }

    public int[][] getPieceS() {
        pieceS[0][0] = 1;
        pieceS[0][1] = 1;
        pieceS[1][1] = 1;
        pieceS[2][1] = 1;
        pieceS[2][2] = 1;

        return pieceS;
    }
}
