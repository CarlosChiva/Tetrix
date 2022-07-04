package pieces;

public class T extends Pieces {

    public T() {
        setArray(getPieceT());
    }
    public int[][] getPieceT() {
        piece[0][0] = 1;
        piece[0][1] = 1;
        piece[0][2] = 1;
        piece[1][1] = 1;

        return piece;
    }
}
