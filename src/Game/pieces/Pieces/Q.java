package Game.pieces.Pieces;
import Enum.Enum;
import Game.pieces.TablePiece;

import static Enum.Enum.*;

public class Q extends TablePiece {


    public Q() {
        setArray(getPieceQ());
    }

    public Enum[][] getPieceQ() {
        piece[0][0] = CURRENTPIECE;
        piece[1][0] = CURRENTPIECE;
        piece[0][1] = CURRENTPIECE;
        piece[1][1] = CURRENTPIECE;

        return piece;
    }
}
