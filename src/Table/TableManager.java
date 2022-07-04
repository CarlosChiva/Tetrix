package Table;


import pieces.BufferedPieces;
import pieces.Piece;
import pieces.PieceDecorator;


public class TableManager {
    Table table;
    Point point;
    BufferedPieces bufferedPieces = new BufferedPieces();
    int sources = 0;
    Piece piece;
    PieceDecorator aux;
    Table aux1;

    public TableManager() {
        table = new Table();
        newPoint();
        newPiece();
    }

    protected void newPoint() {
        this.point = new Point();
        table.putPoint(point);

    }

    private void newPiece() {
        this.piece = new Piece(bufferedPieces.getPiece());
        table.printUnderPoint(piece);

    }

    private void updatePoint() {
        sources += 100;
    }

    //--------------------------------------------------------------------------Left
    protected boolean canMovePointLeft() {
        return point.getY_coordenade() - 1 >= 0;
    }

    protected boolean pieceInLeftBorder() {
        for (int[] ints : table.table) {
            if (ints[0] == 1) {
                return true;
            }
        }
        return false;
    }

    protected boolean otherPieceInLeft() {
        for (int i = 0; i < table.getLength_Of_X(); i++)
            for (int j = table.getLength_Of_Y() - 1; j >= 1; j--) {
                if (table.valueInTableOf(i, j) == 1 && table.valueInTableOf(i, j - 1) == 2) {
                    return true;
                }
            }

        return false;
    }

    protected boolean canPutPieceLeft() {
        return !pieceInLeftBorder() && !otherPieceInLeft();
    }

    protected boolean canMoveLeft() {
        return canMovePointLeft() && canPutPieceLeft();
    }


    //--------------------------------------------------------------------------Right
    protected boolean pieceInRightBorder() {
        for (int i = 0; i < table.getLength_Of_X(); i++) {
            if (table.table[i][table.getLength_Of_Y() - 1] == 1) {
                return true;
            }
        }

        return false;
    }

    protected boolean otherPieceInRight() {
        for (int i = 0; i < table.getLength_Of_X(); i++)
            for (int j = 0; j < table.getLength_Of_Y(); j++) {
                if (table.valueInTableOf(i, j) == 1 && table.valueInTableOf(i, j + 1) == 2) {
                    return true;
                }
            }

        return false;
    }

    protected boolean canPutPieceRight() {
        return !pieceInRightBorder() && !otherPieceInRight();
    }

    protected boolean canMovePointRight() {
        return point.getY_coordenade() + 1 < table.getLength_Of_Y();
    }

    protected boolean canMoveRight() {
        return canMovePointRight() && canPutPieceRight();
    }


    //--------------------------------------------------------------------------Down
    protected boolean pieceInBotoom() {
        for (int j = 0; j < table.getLength_Of_Y(); j++) {
            if (table.valueInTableOf(table.getLength_Of_X() - 1, j) == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean otherPieceDown() {
        for (int i = 0; i < table.getLength_Of_X(); i++)
            for (int j = 0; j < table.getLength_Of_Y(); j++) {
                if (table.valueInTableOf(i, j) == 1 && table.valueInTableOf(i + 1, j) == 2) {
                    return true;
                }
            }

        return false;
    }

    protected boolean canPutPiecedown() {
        return !pieceInBotoom() && !otherPieceDown();
    }

    protected boolean canMovePointDown() {
        return point.getX_coordenade() + 1 < table.getLength_Of_X();
    }

    protected boolean canMoveDown() {
        return canMovePointDown() && canPutPiecedown();
    }

    //---------------------------------------------------------------------------Turn Piece

    protected boolean areTherePiece() {
        aux = new PieceDecorator(piece.getPiece());
        aux.turnLeft();
        int printX = 0;
        for (int i = point.getX_coordenade() - 1; i <= point.getX_coordenade() + 1; i++) {
            int printY = 0;
            for (int j = point.getY_coordenade() - 1; j <= point.getY_coordenade() + 1; j++) {
                if (table.valueInTableOf(i, j) == 2 && aux.areTherePiece(printX, printY)) {
                    return true;
                }
                printY++;
            }
            printX++;
        }
        return false;
    }


    //-----------------------------------------------------------------TurnLeft
    protected boolean areThereBorderL() {
        aux = new PieceDecorator(piece.getPiece());
        aux.turnLeft();
        int printX = 0;
        for (int i = point.getX_coordenade() - 1; i <= point.getX_coordenade() + 1; i++) {
            int printY = 0;
            for (int j = point.getY_coordenade() - 1; j <= point.getY_coordenade() + 1; j++) {
                if (j >= table.getLength_Of_Y() || j < 0 || i < 0 || i >= table.getLength_Of_X() && aux.areTherePiece(printX, printY)) {
                    return true;
                }
                printY++;
            }
            printX++;
        }
        return false;
    }

    protected boolean canTurnLeft() {
        return !areThereBorderL() && !areTherePiece();
    }

    //----------------------------------------------------------------Turn Right
    protected boolean areThereBorderR() {
        aux = new PieceDecorator(piece.getPiece());
        aux.turnRight();
        int printX = 0;
        for (int i = point.getX_coordenade() - 1; i <= point.getX_coordenade() + 1; i++) {
            int printY = 0;
            for (int j = point.getY_coordenade() - 1; j <= point.getY_coordenade() + 1; j++) {
                if (j >= table.getLength_Of_Y() || j < 0 || i < 0 || i >= table.getLength_Of_X() && aux.areTherePiece(printX, printY)) {
                    return true;
                }
                printY++;
            }
            printX++;
        }
        return false;
    }

    protected boolean canTurnRight() {
        return !areThereBorderR() && !areTherePiece();
    }

    //-------------------------------------------------------------------Look if Points
    protected boolean rowsFill() {
        int count = 0;
        for (int i = 0; i < table.getLength_Of_X(); i++) {
            for (int j = 0; j < table.getLength_Of_Y(); j++) {
                if (table.valueInTableOf(i, j) == 2) {
                    count++;
                    if (count == table.getLength_Of_Y()) {
                        return true;

                    }
                }
            }
            count = 0;
        }
        return false;
    }


    public void movedPoint(char boton) {
        switch (boton) {
            case 'a' -> {
                if (canMoveLeft()) {
                    point.setY_coordenade(point.getY_coordenade() - 1);
                    table.putPoint(point);
                    table.printUnderPoint(piece);
                }

            }
            case 's' -> {
                if (canMoveDown()) {
                    point.setX_coordenade(point.getX_coordenade() + 1);
                    table.putPoint(point);
                    table.printUnderPoint(piece);
                } else {
                    table.blockedPiece();

                    if (rowsFill()) {
                        table.refreshTable();
                        updatePoint();
                        System.out.println("Good, your scource is:  " + sources);
                    }
                    newPoint();
                    newPiece();
                }
            }
            case 'd' -> {
                if (canMoveRight()) {
                    point.setY_coordenade(point.getY_coordenade() + 1);
                    table.putPoint(point);
                    table.printUnderPoint(piece);
                }

            }
            case 'e' -> {
                if (canTurnRight()) {
                    piece.turnRight();
                    table.printUnderPoint(piece);
                }
            }
            case 'q' -> {
                if (canTurnLeft()) {
                    piece.turnLeft();
                    table.printUnderPoint(piece);
                }
            }
        }
    }

    public void printTable() {
        for (int[] ints : table.table) {
            for (int j = 0; j < table.getLength_Of_Y(); j++) {
                if (ints[j] == 0) {
                    System.out.print('-');
                }
                if (ints[j] == 1) {
                    System.out.print('X');
                }
                if (ints[j] == 2) {
                    System.out.print('0');
                }

                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
