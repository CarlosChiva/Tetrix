package Table;
import Enum.Enum;
import Game.pieces.TablePiece;

import java.io.Serializable;

import static Enum.Enum.*;

public class Piece implements Serializable {
    TablePiece piece;

public Piece(TablePiece piece){
    this.piece=piece;
}

    public void setPieceArray(Enum[][]array) {
        this.piece.setArray(array);
    }

    public TablePiece getPiece() {
        return piece;
    }

    public TablePiece newPiece(){
        return new TablePiece(piece.piece);
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
