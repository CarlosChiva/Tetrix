package pieces;

public class T extends Pieces {
    int[][] pieceT = new int[3][3];
    public T() {
    }
    public int[][] getPieceT() {
        pieceT[0][0] = 1;
        pieceT[0][1] = 1;
        pieceT[0][2] = 1;
        pieceT[1][1] = 1;

        return pieceT;
    }
}
