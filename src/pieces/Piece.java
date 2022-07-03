package pieces;

public class Piece implements IPieces{
    Pieces piece;

public Piece(Pieces piece){
    this.piece=piece;
}

    public Pieces getPiece() {
        return piece;
    }


    public boolean areTherePiece(int xCoordenade, int yCoordenade) {
        return piece.getValuesArray(xCoordenade, yCoordenade)== 1;
    }

    public void turnRight() {

        int[][] aux = new int[3][3];
        aux[0][2] = piece.getValuesArray(0,0);
        aux[0][1] = piece.getValuesArray(1,0);
        aux[0][0] = piece.getValuesArray(2,0);
        aux[1][0] = piece.getValuesArray(2,1);
        aux[2][0] = piece.getValuesArray(2,2);
        aux[2][1] = piece.getValuesArray(1,2);
        aux[2][2] = piece.getValuesArray(0,2);
        aux[1][2] = piece.getValuesArray(0,1);
        aux[1][1] = piece.getValuesArray(1,1);
        piece.setArray(aux);
    }

    public void turnLeft() {
        int[][] aux = new int[3][3];

        aux[0][0] = piece.getValuesArray(0,2);
        aux[1][0] = piece.getValuesArray(0,1);
        aux[2][0] = piece.getValuesArray(0,0);
        aux[2][1] = piece.getValuesArray(1,0);
        aux[2][2] = piece.getValuesArray(2,0);
        aux[1][2] = piece.getValuesArray(2,1);
        aux[0][2] = piece.getValuesArray(2,2);
        aux[0][1] = piece.getValuesArray(1,2);
        aux[2][1] = piece.getValuesArray(1,0);
        aux[1][1] = piece.getValuesArray(1,1);

        piece.setArray(aux);

    }

    public void print() {
        for (int i = 0; i < piece.piece.length; i++) {
            for (int j = 0; j < piece.piece[0].length; j++) {
                System.out.print(piece.getValuesArray(i,j));
            }
            System.out.println();
        }
    }

    @Override
    public int getValuesArray(int x, int y) {
        return piece[x][y];
    }

    @Override
    public void setArray(int[][] array) {
        this.piece=array;

    }
}
