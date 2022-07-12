package Game.pieces.Pieces;
import Enum.Enum;

import Game.pieces.TablePiece;

import static Enum.Enum.CURRENTPIECE;

public class Plus extends TablePiece {
    public Plus() {
        setArray(getPiecePlus());
    }

    public Enum[][] getPiecePlus() {
        piece[0][1] = CURRENTPIECE;
        piece[1][0] = CURRENTPIECE;
        piece[1][1] = CURRENTPIECE;
        piece[1][2] = CURRENTPIECE;
        piece[2][1] = CURRENTPIECE;

        return piece;
    }
}
