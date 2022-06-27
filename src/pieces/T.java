package pieces;

public class T implements IPiece {

    int[][] pieceT = new int[3][3];

    public T() {

        pieceT[0][0] = 1;
        pieceT[0][1] = 1;
        pieceT[0][2] = 1;
        pieceT[1][1] = 1;


    }
    public boolean areTherePiece(int xCoordenade, int yCoordenade){
        return pieceT[xCoordenade][yCoordenade]==1;
    }

}
