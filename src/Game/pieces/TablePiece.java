package Game.pieces;

import Enum.Enum;

public class TablePiece implements IPieces {
    public Enum[][] piece = new Enum[3][3];

    public TablePiece(Enum[][] piece) {
        this.piece = piece;
    }

    public TablePiece() {
    }
    @Override
    public Enum getValuesArray(int x, int y) {
        return piece[x][y];
    }

    @Override
    public void setArray(Enum[][] array) {
        piece = array;
    }

}
