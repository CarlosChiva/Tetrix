package pieces;

public class Z extends Pieces{

    public Z() {
    setArray(getPieceZ());
    }


    public int[][] getPieceZ() {
        piece[2][0] = 1;
        piece[2][1] = 1;
        piece[1][1] = 1;
        piece[1][2] = 1;

        return piece;
    }
}
