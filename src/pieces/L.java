package pieces;
import Enum.Enum;
import static Enum.Enum.*;

public class L extends Pieces {
    public L() {
        setArray(getPieceL());
    }

    public Enum[][] getPieceL() {
        piece[0][0] = CURRENTPIECE;
        piece[1][0] = CURRENTPIECE;
        piece[2][0] = CURRENTPIECE;
        piece[2][1] = CURRENTPIECE;

        return piece;
    }
}
