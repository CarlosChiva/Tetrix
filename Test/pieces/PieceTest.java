package pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    BufferedPieces bufferedPieces = new BufferedPieces();

    Piece piece = new Piece(bufferedPieces.getPiece());

    @Test
    void samePiece_True() {
        BufferedPieces bufferedPieces1 = new BufferedPieces();
        Piece piece1 = new Piece(bufferedPieces1.getPiece());
        assertArrayEquals(piece.piece, piece1.piece);
    }
}