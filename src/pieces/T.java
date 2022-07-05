package pieces;
import Enum.Enum;
import static Enum.Enum.*;

public class T extends Pieces {

    public T() {
        setArray(getPieceT());
    }
    public Enum[][] getPieceT() {
        piece[0][0] = CURRENTPIECE;
        piece[0][1] = CURRENTPIECE;
        piece[0][2] = CURRENTPIECE;
        piece[1][1] = CURRENTPIECE;

        return piece;
    }
}
