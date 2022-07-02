package pieces;

public class Z {
    int[][] pieceZ = new int[3][3];
    public Z() {
    }
    public int[][] getPieceZ() {
        pieceZ[2][0] = 1;
        pieceZ[2][1] = 1;
        pieceZ[1][1] = 1;
        pieceZ[1][2] = 1;

        return pieceZ;
    }
}
