package pieces;

import Enum.Enum;

public class Pieces implements IPieces {
    Enum[][] piece = new Enum[3][3];

    public Pieces(Enum[][] piece) {
        this.piece = piece;
    }

    public Pieces() {
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
