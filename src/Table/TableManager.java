package Table;

import  Enum.Enum;
import pieces.BufferedPieces;
import pieces.Piece;

import static Enum.Enum.*;


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
        areTherePiece(ERROR);
        table.printUnderPoint(piece);
    }

    protected void newPoint() {
        this.point = new Point();
        table.putPoint(point);

    }

    private void newPiece() {
        this.piece = new Piece(bufferedPieces.getPiece());
        if (areTherePiece(ERROR)) {
            gameOver();
        } else {
            table.printUnderPoint(piece);
        }
    }

    private void updatePoint() {
        sources += 100;
    }

    //--------------------------------------------------------------------------Move
    protected boolean canMovePoint(Enum move) {
        if (move == LEFT) {
            return point.getY_coordenade() - 1 >= 0;
        }
        if (move == RIGHT) {
            return point.getY_coordenade() + 1 < table.getLength_Of_Y();
        }
        return point.getX_coordenade() + 1 < table.getLength_Of_X();

    }

    protected boolean pieceInBorder(Enum move) {
        for (Enum[] ints : table.table) {
            if (move == RIGHT) {
                if (ints[table.getLength_Of_Y() - 1] == CURRENTPIECE) {
                    return true;
                }
            } else {
                if (ints[0] == CURRENTPIECE) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean otherPiece(Enum move) {

        for (int i = 0; i < table.getLength_Of_X(); i++)
            for (int j = 0; j < table.getLength_Of_Y() - 1; j++) {
                if (move == LEFT) {
                    if (table.valueInTableOf(i, j) == BLOCKEDPIECE && table.valueInTableOf(i, j + 1) == CURRENTPIECE) {
                        return true;
                    }
                } else if (move == RIGHT) {
                    if (table.valueInTableOf(i, j) == CURRENTPIECE && table.valueInTableOf(i, j + 1) == BLOCKEDPIECE) {
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
            if (table.valueInTableOf(table.getLength_Of_X() - 1, j) == CURRENTPIECE) {
                return true;
            }
        }
        return false;
    }

    protected boolean otherPieceDown() {
        for (int i = 0; i < table.getLength_Of_X(); i++)
            for (int j = 0; j < table.getLength_Of_Y(); j++) {
                if (table.valueInTableOf(i, j) == CURRENTPIECE && table.valueInTableOf(i + 1, j) == BLOCKEDPIECE) {
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
        if (turn == TURNLEFT) {
            aux.turnLeft();
        } else if (turn == TURNRIGHT) {
            aux.turnRight();
        }
        int printX = 0;
        for (int i = point.getX_coordenade() - 1; i <= point.getX_coordenade() + 1; i++) {
            int printY = 0;
            for (int j = point.getY_coordenade() - 1; j <= point.getY_coordenade() + 1; j++) {
                if (table.valueInTableOf(i, j) == BLOCKEDPIECE && aux.areTherePiece(printX, printY)) {
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
                if (table.valueInTableOf(i, j) == BLOCKEDPIECE) {
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
        return ERROR;
    }

    public void movedPoint(char boton) {
        switch (traductor(boton)) {
            case LEFT -> {
                if (canMove(LEFT)) {
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
                    newPiece();
                }
            }
            case RIGHT -> {
                if (canMove(RIGHT)) {
                    point.setY_coordenade(point.getY_coordenade() + 1);
                    table.putPoint(point);
                    table.printUnderPoint(piece);
                }

            }
            case TURNRIGHT -> {
                if (canTurn(TURNRIGHT)) {
                    piece.turnRight();
                    table.printUnderPoint(piece);
                }
            }
            case TURNLEFT -> {
                if (canTurn(TURNLEFT)) {
                    piece.turnLeft();
                    table.printUnderPoint(piece);
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over");
        System.out.println("Your score is: " +sources);
    }

    public void printTable() {
        for (Enum[] ints : table.table) {
            for (int j = 0; j < table.getLength_Of_Y(); j++) {
                if (ints[j] == EMPTY) {
                    System.out.print('-');
                }
                if (ints[j] == CURRENTPIECE) {
                    System.out.print('X');
                }
                if (ints[j] == BLOCKEDPIECE) {
                    System.out.print('0');
                }

                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
