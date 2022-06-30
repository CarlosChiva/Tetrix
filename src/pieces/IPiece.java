package pieces;

public interface IPiece {
    boolean areTherePiece(int xCoordenade, int yCoordenade);

    void turnRight();

    void turnLeft();
}