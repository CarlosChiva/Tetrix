package Game.pieces;

import Game.pieces.Pieces.*;

import java.io.Serializable;
import java.util.ArrayList;

public class BufferedPieces implements Serializable {
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
        pieces.add(new LInvers());
        pieces.add(new ZInvers());
        pieces.add(new Plus());

    }

    public TablePiece getPiece() {

        return pieces.get((int) (Math.random() * pieces.size()));
    }

}
