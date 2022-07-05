package Game.pieces;
import Game.pieces.Pieces.*;

import java.util.ArrayList;

public class BufferedPieces {
    static ArrayList<TablePiece> pieces = new ArrayList<>();

    public BufferedPieces() {
        fillList();
    }

    private void fillList() {
        pieces.add(new T());
        pieces.add(new L());
        pieces.add(new Q());
        pieces.add(new Z());
        pieces.add(new S());

    }

    public TablePiece getPiece() {

        return pieces.get((int) (Math.random() * pieces.size()));
    }

}
