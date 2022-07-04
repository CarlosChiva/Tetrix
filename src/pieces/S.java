package pieces;

public class S extends Pieces {


    public S() {
setArray(getPieceS());
    }

    public int[][] getPieceS() {
        piece[0][0] = 1;
        piece[0][1] = 1;
        piece[1][1] = 1;
        piece[2][1] = 1;
        piece[2][2] = 1;

        return piece;
    }
}
