package pieces;

import java.awt.*;
import java.util.LinkedList;

public class BufferedPieces {
    LinkedList<int[][]> pieces=new LinkedList<>();
    public BufferedPieces(){
        pieces.add(new T().getPieceT());
        pieces.add(new L().getPieceL());
    }
    public int[][] getPiece(){
        return pieces.pop();
    }
}
