package Game.pieces.Pieces;
import Enum.Enum;
import Game.pieces.TablePiece;

import static Enum.Enum.*;

public class LInvers extends TablePiece {

    public LInvers() {
        setArray(getPieceLInvers());
    }

    public Enum[][] getPieceLInvers() {
        piece[0][2] = CURRENTPIECE;
        piece[1][2] = CURRENTPIECE;
        piece[2][2] = CURRENTPIECE;
        piece[2][1] = CURRENTPIECE;

        return piece;
    }
}
