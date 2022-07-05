package Game.pieces.Pieces;
import Enum.Enum;
import Game.pieces.TablePiece;

import static Enum.Enum.*;

public class Z extends TablePiece {

    public Z() {
    setArray(getPieceZ());
    }


    public Enum[][] getPieceZ() {
        piece[2][0] = CURRENTPIECE;
        piece[2][1] = CURRENTPIECE;
        piece[1][1] = CURRENTPIECE;
        piece[1][2] = CURRENTPIECE;

        return piece;
    }
}
