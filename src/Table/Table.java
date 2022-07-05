package Table;

import pieces.Piece;
import Enum.Enum;
import static Enum.Enum.*;

public class Table {
    private final int lenghtX = 9;
    private final int lenghtY = 12;
    Enum[][] table = new Enum[lenghtX][lenghtY];
    Point point;

    public int getLength_Of_Y() {
        return lenghtY;
    }

    public int getLength_Of_X() {
        return lenghtX;
    }


    public Table() {
        fillTable();
    }

    public Table(Piece piece) {
        fillTable();
        point = new Point();
        printUnderPoint(piece);
    }

    private void fillTable() {
        for (int i = 0; i < getLength_Of_X(); i++) {
            for (int j = 0; j < getLength_Of_Y(); j++) {
                table[i][j] = EMPTY;
            }
        }
    }

    public void reset() {
        for (int i = 0; i < getLength_Of_X(); i++) {
            for (int j = 0; j < getLength_Of_Y(); j++) {
                if (table[i][j] == CURRENTPIECE) {
                    table[i][j] = EMPTY;
                }
            }
        }
    }

    public void setTable(int x, int y, Enum newEnum) {
        table[x][y] = newEnum;
    }

    public void putPoint(Point point) {
        reset();
        this.point = point;

    }

    public Enum valueInTableOf(int x, int y) {
        return table[x][y];
    }

    //-----------------------------------------------------------------Put piece on the point
    protected void printUnderPoint(Piece piece) {
        reset();
        int printX = 0;
        for (int i = point.getX_coordenade() - 1; i <= point.getX_coordenade() + 1; i++) {
            int printY = 0;
            for (int j = point.getY_coordenade() - 1; j <= point.getY_coordenade() + 1; j++) {
                if (piece.areTherePiece(printX, printY) && i < getLength_Of_X() && j < getLength_Of_Y()) {
                    setTable(i, j, CURRENTPIECE);
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
                if (valueInTableOf(i, j) == CURRENTPIECE) {
                    setTable(i, j, BLOCKEDPIECE);

                }
            }
        }
    }

    //------------------------------------------------------------------Delete row
    private void deleteRow(int x) {
        for (int i = 0; i < getLength_Of_Y(); i++) {
            setTable(x, i, EMPTY);
        }
    }

    protected void refreshTable() {
        int count = 0;
        for (int i = 0; i < getLength_Of_X(); i++) {
            for (int j = 0; j < getLength_Of_Y(); j++) {
                if (valueInTableOf(i, j) == BLOCKEDPIECE) {
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

            setTable(0, j, EMPTY);
        }

    }
}
