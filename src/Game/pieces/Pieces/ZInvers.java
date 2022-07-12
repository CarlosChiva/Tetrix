package Game.pieces.Pieces;

import Game.pieces.TablePiece;
import Enum.Enum;

import static Enum.Enum.*;

public class ZInvers extends TablePiece {


    public ZInvers() {
        setArray(getPieceZInvers());
    }

    public Enum[][] getPieceZInvers() {
        piece[1][1] = CURRENTPIECE;
        piece[1][2] = CURRENTPIECE;
        piece[2][0] = CURRENTPIECE;
        piece[2][1] = CURRENTPIECE;

        return piece;
    }
}

