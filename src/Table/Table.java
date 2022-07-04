package Table;

import pieces.L;
import pieces.Piece;
import pieces.Pieces;

//0 empty
//1 piece
//2 piece blocked
public class Table {
    private int lenghtX = 9;
    private int lenghtY = 12;
    int[][] table = new int[lenghtX][lenghtY];
    int pointXCoordenade;
    int pointYcoordenade;
    Piece piece;

    public int getLength_Of_Y() {
        return lenghtY;
    }

    public int getLength_Of_X() {
        return lenghtX;
    }


    public Table() {
    }

    public Table(Piece piece) {
        pointXCoordenade = 1;
        pointYcoordenade = 5;
        this.piece = piece;
        printUnderPoint(this.piece);
    }

    public void reset() {
        for (int i = 0; i < getLength_Of_X(); i++) {
            for (int j = 0; j < getLength_Of_Y(); j++) {
                if (table[i][j] == 1) {
                    table[i][j] = 0;
                }
            }
        }
    }

    public void setTable(int x, int y, int newValue) {
        table[x][y] = newValue;
    }

    public void putPoint(Point point) {
        reset();
        pointXCoordenade = point.getX_coordenade();
        pointYcoordenade = point.getY_coordenade();

    }

    public int valueInTableOf(int x, int y) {
        return table[x][y];
    }

    //-----------------------------------------------------------------Put piece on the point
    protected void printUnderPoint(Piece piece) {
        reset();
        int printX = 0;
        for (int i = pointXCoordenade - 1; i <= pointXCoordenade + 1; i++) {
            int printY = 0;
            for (int j = pointYcoordenade - 1; j <= pointYcoordenade + 1; j++) {
                if (piece.areTherePiece(printX, printY) && i < getLength_Of_X() && j < getLength_Of_Y()) {
                    setTable(i, j, 1);

                }
                printY++;
            }
            printX++;
        }
    }

    //--------------------------------------------------------------------Blocked piece
    protected void blockedPiece() {
        for (int i = 0; i < getLength_Of_X(); i++) {
            for (int j = 0; j < getLength_Of_Y(); j++) {
                if (valueInTableOf(i, j) == 1) {
                    setTable(i, j, 2);

                }
            }
        }
    }

    //------------------------------------------------------------------Delete row
    private void deleteRow(int x) {
        for (int i = 0; i < getLength_Of_Y(); i++) {
            setTable(x, i, 0);
        }
    }

    protected void refreshTable() {
        int count = 0;
        for (int i = 0; i < getLength_Of_X(); i++) {
            for (int j = 0; j < getLength_Of_Y(); j++) {
                if (valueInTableOf(i, j) == 2) {
                    count++;
                    if (count == getLength_Of_Y()) {
                        deleteRow(i);
                        dropPieces(i);
                        refreshTable();
                    }
                }
            }
            count = 0;
        }

    }

    protected void dropPieces(int x) {
        for (int j = 0; j < getLength_Of_Y(); j++) {
            for (int i = x; i > 1; i--) {
                setTable(i, j, valueInTableOf(i - 1, j));
            }

            setTable(0, j, 0);
        }

    }
}
