package pieces;
import Enum.Enum;

import static Enum.Enum.*;

public class Piece {
    Pieces piece;

public Piece(Pieces piece){
    this.piece=piece;
}

    public void setPieceArray(Enum[][]array) {
        this.piece.setArray(array);
    }

    public Pieces getPiece() {
        return piece;
    }

    public Pieces newPiece(){
        return new Pieces(piece.piece);
    }
    public boolean areTherePiece(int xCoordenade, int yCoordenade) {
        return piece.getValuesArray(xCoordenade, yCoordenade)== CURRENTPIECE;
    }

    public void turnRight() {

        Enum[][] aux = new Enum[3][3];
        aux[0][2] = piece.getValuesArray(0,0);
        aux[0][1] = piece.getValuesArray(1,0);
        aux[0][0] = piece.getValuesArray(2,0);
        aux[1][0] = piece.getValuesArray(2,1);
        aux[2][0] = piece.getValuesArray(2,2);
        aux[2][1] = piece.getValuesArray(1,2);
        aux[2][2] = piece.getValuesArray(0,2);
        aux[1][2] = piece.getValuesArray(0,1);
        aux[1][1] = piece.getValuesArray(1,1);
        setPieceArray(aux);
    }

    public void turnLeft() {
        Enum[][] aux = new Enum[3][3];
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

        setPieceArray(aux);

    }

}
