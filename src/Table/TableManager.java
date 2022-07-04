package Table;


import pieces.BufferedPieces;
import pieces.Piece;


public class TableManager {
    Table table;
    Point point;
    BufferedPieces bufferedPieces;
    Piece piece;
    int sources = 0;

    public TableManager() {
        bufferedPieces = new BufferedPieces();
        table = new Table();
        newPoint();
        newPiece();
    }

    public TableManager(Piece piece) {
        table = new Table();
        newPoint();
        this.piece = piece;
        table.printUnderPoint(piece);
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

    //--------------------------------------------------------------------------Move
    protected boolean canMovePoint(Enum move) {
        if (move == Enum.LEFT) {
            return point.getY_coordenade() - 1 >= 0;
        }
        if (move == Enum.RIGHT) {
            return point.getY_coordenade() + 1 < table.getLength_Of_Y();
        }
        return point.getX_coordenade() + 1 < table.getLength_Of_X();

    }

    protected boolean pieceInBorder(Enum move) {
        for (int[] ints : table.table) {
            if (move == Enum.RIGHT) {
                if (ints[table.getLength_Of_Y() - 1] == 1) {
                    return true;
                }
            } else {
                if (ints[0] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean otherPiece(Enum move) {
        for (int i = 0; i < table.getLength_Of_X(); i++)
            for (int j = 0; j < table.getLength_Of_Y() - 1; j++) {
                if (move == Enum.LEFT) {
                    if (table.valueInTableOf(i, j) == 2 && table.valueInTableOf(i, j + 1) == 1) {
                        return true;
                    }
                } else {
                    if (table.valueInTableOf(i, j) == 1 && table.valueInTableOf(i, j + 1) == 2) {
                        return true;
                    }
                }
            }

        return false;
    }

    protected boolean canPutPiece(Enum move) {
        return !pieceInBorder(move) && !otherPiece(move);
    }

    protected boolean canMove(Enum move) {
        return canMovePoint(move) && canPutPiece(move);
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

    protected boolean otherPieceDown() {
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

    protected boolean canMoveDown() {
        return canMovePoint(Enum.DOWN) && canPutPiecedown();
    }

    //---------------------------------------------------------------------------Turn Piece

    protected boolean areTherePiece(Enum turn) {
        Piece aux = new Piece(piece.newPiece());
        if (turn == Enum.TURNLEFT) {
            aux.turnLeft();
        } else {
            aux.turnRight();
        }
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

    protected boolean areThereBorder() {
        Piece aux = new Piece(piece.newPiece());
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


    protected boolean canTurn(Enum turn) {
        return !areThereBorder() && !areTherePiece(turn);
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

    private Enum traductor(char choose) {
        if (choose == 'a') {
            return Enum.LEFT;
        }
        if (choose == 's') {
            return Enum.DOWN;
        }
        if (choose == 'd') {
            return Enum.RIGHT;
        }
        if (choose == 'e') {
            return Enum.TURNRIGHT;
        }
        if (choose == 'q') {
            return Enum.TURNLEFT;
        }
        return Enum.ERROR;
    }

    public void movedPoint(char boton) {
        switch (traductor(boton)) {
            case LEFT -> {
                if (canMove(Enum.LEFT)) {
                    point.setY_coordenade(point.getY_coordenade() - 1);
                    table.putPoint(point);
                    table.printUnderPoint(piece);
                }

            }
            case DOWN -> {
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

                }
            }
            case RIGHT -> {
                if (canMove(Enum.RIGHT)) {
                    point.setY_coordenade(point.getY_coordenade() + 1);
                    table.putPoint(point);
                    table.printUnderPoint(piece);
                }

            }
            case TURNRIGHT -> {
                if (canTurn(Enum.TURNRIGHT)) {
                    piece.turnRight();
                    table.printUnderPoint(piece);
                }
            }
            case TURNLEFT -> {
                if (canTurn(Enum.TURNLEFT)) {
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
