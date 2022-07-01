package pieces;

public class Piece implements IPiece {
    int[][] piece;
public Piece(int[][] piece){
    this.piece=piece;
}
    @Override
    public boolean areTherePiece(int xCoordenade, int yCoordenade) {
        return piece[xCoordenade][yCoordenade] == 1;
    }

    @Override
    public void turnRight() {

        int[][] aux = new int[3][3];
        aux[0][2] = piece[0][0];
        aux[0][1] = piece[1][0];
        aux[0][0] = piece[2][0];
        aux[1][0] = piece[2][1];
        aux[2][0] = piece[2][2];
        aux[2][1] = piece[1][2];
        aux[2][2] = piece[0][2];
        aux[1][2] = piece[0][1];
        aux[1][1] = piece[1][1];

        this.piece = aux;
    }

    @Override
    public void turnLeft() {
        int[][] aux = new int[3][3];

        aux[0][0] = piece[0][2];
        aux[1][0] = piece[0][1];
        aux[2][0] = piece[0][0];
        aux[2][1] = piece[1][0];
        aux[2][2] = piece[2][0];
        aux[1][2] = piece[2][1];
        aux[0][2] = piece[2][2];
        aux[0][1] = piece[1][2];
        aux[2][1] = piece[1][0];
        aux[1][1] = piece[1][1];

        this.piece = aux;

    }

    public void print() {
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[0].length; j++) {
                System.out.print(piece[i][j]);
            }
            System.out.println();
        }
    }
}
