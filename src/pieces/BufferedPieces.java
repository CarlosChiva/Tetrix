package pieces;

import java.util.ArrayList;
import java.util.LinkedList;

public class BufferedPieces {
    ArrayList<int[][]> pieces = new ArrayList<>();

    public BufferedPieces() {
        fillList();
    }

    private void fillList() {
        pieces.add(new T().getPieceT());
        pieces.add(new L().getPieceL());
        pieces.add(new Q().getPieceQ());
        pieces.add(new Z().getPieceZ());
        pieces.add(new S().getPieceS());

    }

    public int[][] getPiece() {
        int pieceRandom = (int) (Math.random() * pieces.size() + 1);
        if (pieces.size() == 0)
            fillList();

        int[][] piece = pieces.get(pieceRandom);

        pieces.remove(pieceRandom);
        return piece;

    }
}
