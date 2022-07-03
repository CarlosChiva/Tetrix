package pieces;

public class L extends Pieces{
    int[][] pieceL = new int[3][3];
    public L() {

    }
    public int[][] getPieceL() {
        pieceL[0][0] = 1;
        pieceL[1][0] = 1;
        pieceL[2][0] = 1;
        pieceL[2][1] = 1;

        return pieceL;
    }
}
