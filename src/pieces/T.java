package pieces;

public class T implements IPiece {

    int[][] pieceT = new int[3][3];

    public T() {

        pieceT[0][0] = 1;
        pieceT[0][1] = 1;
        pieceT[0][2] = 1;
        pieceT[1][1] = 1;


    }

    public boolean areTherePiece(int xCoordenade, int yCoordenade) {
        return pieceT[xCoordenade][yCoordenade] == 1;
    }

    @Override
    public void turnRight() {
        int[][] aux = new int[3][3];
        aux[0][2] = pieceT[0][0];
        aux[0][1] = pieceT[1][0];
        aux[0][0] = pieceT[2][0];
        aux[1][0] = pieceT[2][1];
        aux[2][0] = pieceT[2][2];
        aux[2][1] = pieceT[1][2];
        aux[2][2] = pieceT[0][2];
        aux[1][2] = pieceT[0][1];
        aux[1][1] = pieceT[1][1];

        this.pieceT = aux;

    }

    @Override
    public void turnLeft() {
        int[][] aux = new int[3][3];

        aux[0][0] = pieceT[0][2];
        aux[1][0] = pieceT[0][1];
        aux[2][0] = pieceT[0][0];
        aux[2][1] = pieceT[1][0];
        aux[2][2] = pieceT[2][0];
        aux[1][2] = pieceT[2][1];
        aux[0][2] = pieceT[2][2];
        aux[0][1] = pieceT[1][2];
        aux[2][1] = pieceT[1][0];
        aux[1][1] = pieceT[1][1];

        this.pieceT = aux;
    }

    public void print() {
        for (int i = 0; i < pieceT.length; i++) {
            for (int j = 0; j < pieceT[0].length; j++) {
                System.out.print(pieceT[i][j]);
            }
            System.out.println();
        }
    }
}
