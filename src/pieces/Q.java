package pieces;
import Enum.Enum;
import static Enum.Enum.*;

public class Q extends Pieces {


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
