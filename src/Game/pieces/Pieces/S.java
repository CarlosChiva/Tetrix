package Game.pieces.Pieces;
import Enum.Enum;
import Game.pieces.TablePiece;

import static Enum.Enum.*;

public class S extends TablePiece {


    public S() {
setArray(getPieceS());
    }

    public Enum[][] getPieceS() {
        piece[0][0] = CURRENTPIECE;
        piece[0][1] = CURRENTPIECE;
        piece[1][1] = CURRENTPIECE;
        piece[2][1] = CURRENTPIECE;
        piece[2][2] = CURRENTPIECE;

        return piece;
    }
}
