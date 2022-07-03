package pieces;
import java.util.ArrayList;

public class BufferedPieces {
    ArrayList<Pieces> pieces = new ArrayList<>();

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

    public Pieces getPiece() {
        int pieceRandom = (int) (Math.random() * pieces.size()-1 + 1);
        Pieces piece = pieces.get(pieceRandom);
        return piece;

    }
}
