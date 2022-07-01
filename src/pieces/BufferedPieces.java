package pieces;
import java.util.LinkedList;

public class BufferedPieces {
    LinkedList<int[][]> pieces = new LinkedList<>();

    public BufferedPieces() {
        fillList();
    }

    private void fillList() {
        pieces.add(new T().getPieceT());
        pieces.add(new L().getPieceL());
        pieces.add(new Q().getPieceQ());

    }

    public int[][] getPiece() {
        if (pieces.size()==0){
            fillList();
        }
        return pieces.pop();
    }
}
