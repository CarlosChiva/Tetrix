import pieces.BufferedPieces;
import pieces.Piece;

//0 empty
//1 point
//1 piece
//2 piece blocked
public class Table {
    int[][] table = new int[9][12];
    Point point;
    BufferedPieces bufferedPieces = new BufferedPieces();
    Piece piece;
    int length_Of_Y = table[0].length;
    int length_Of_X = table.length;

    public Table() {
        newPoint();

    }

    protected void newPoint() {
        this.point = new Point(1, 5);
        newPiece();
    }

    private void newPiece() {
        piece = new Piece(bufferedPieces.getPiece());
    }

    private void reset() {
        for (int i = 0; i < length_Of_X; i++) {
            for (int j = 0; j < length_Of_Y; j++) {
                if (table[i][j] == 1) {
                    table[i][j] = 0;
                }
            }
        }
    }

    //---------------------------------------Left
    protected boolean canMovePointLeft() {
        return point.getY_coordenade() - 1 >= 0;
    }

    protected boolean pieceInLeftBorder() {
        for (int[] ints : table) {
            if (ints[0] == 1) {
                return true;
            }
        }
        return false;
    }

    protected boolean otherPieceInLeft() {
        for (int[] ints : table)
            for (int j = 0; j < length_Of_Y; j++) {
                if (ints[j] == 2 && ints[j + 1] == 1) {
                    return true;
                }
            }

        return false;
    }

    protected boolean canPutPieceLeft() {
        return !pieceInLeftBorder() && !otherPieceInLeft();
    }

    //------------------------------------------------------------Right
    protected boolean pieceInRightBorder() {
        for (int i = 0; i < length_Of_X; i++) {
            if (table[i][length_Of_Y - 1] == 1) {
                return true;
            }
        }

        return false;
    }

    private boolean otherPieceInRight() {
        for (int i = 0; i < length_Of_X; i++)
            for (int j = 0; j < length_Of_Y; j++) {
                if (table[i][j] == 1 && table[i][j + 1] == 2) {
                    return true;
                }
            }

        return false;
    }

    protected boolean canPutPieceRight() {
        return !pieceInRightBorder() && !otherPieceInRight();
    }

    protected boolean canMovePointRight() {
        return point.getY_coordenade() + 1 < length_Of_Y;
    }


    //--------------------------------------------------------------------------------------------Down
    protected boolean pieceInBotoom() {
        for (int i = 0; i < length_Of_X; i++) {
            for (int j = 0; j < length_Of_Y; j++) {
                if (table[i][j] == 1 && i == length_Of_X - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean otherPieceDown() {
        for (int i = 0; i < length_Of_X; i++)
            for (int j = 0; j < length_Of_Y; j++) {
                if (table[i][j] == 1 && table[i + 1][j] == 2) {
                    return true;
                }
            }

        return false;
    }

    protected boolean canPutPiecedown() {
        return !pieceInBotoom() && !otherPieceDown();
    }

    protected boolean canMovePointDown() {
        return point.x_coordenade + 1 < length_Of_X;
    }

    //----------------------------------------------------------------------------------Turn Piece
    //---------------------------------------------------------------------------TurnLeft
    protected boolean areThereBorderL() {
        Piece aux = new Piece(bufferedPieces.getPiece());
        aux.turnLeft();
        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (j >= length_Of_Y || j <= 0 && aux.areTherePiece(printX, printY)) {
                    return false;
                }
                printY++;
            }
            printX++;
        }
        return true;
    }

    private boolean areTherePieceL() {
        Piece aux = new Piece(bufferedPieces.getPiece());
        aux.turnLeft();
        int[][] aux1;
        aux1 = table;
        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (aux1[i][j] == 2 && aux.areTherePiece(printX, printY)) {
                    return false;
                }
                printY++;
            }
            printX++;
        }


        return true;
    }

    private boolean canTurnLeft() {
        return areThereBorderL() && areTherePieceL();
    }

    //----------------------------------------------------------------Turn Right
    protected boolean areThereBorderR() {
        Piece aux = new Piece(bufferedPieces.getPiece());
        aux.turnRight();
        int printX = 0;
        for (int i = point.getX_coordenade() - 1; i <= point.getX_coordenade() + 1; i++) {
            int printY = 0;
            for (int j = point.getY_coordenade() - 1; j <= point.getY_coordenade() + 1; j++) {
                if (j >= length_Of_Y || j <= 0 && aux.areTherePiece(printX, printY)) {
                    return false;
                }
                printY++;
            }
            printX++;
        }
        return true;
    }

    private boolean areTherePieceR() {
        Piece aux = new Piece(bufferedPieces.getPiece());
        aux.turnRight();
        int[][] aux1;
        aux1 = table;
        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (aux1[i][j] == 2 && aux.areTherePiece(printX, printY)) {
                    return false;
                }
                printY++;
            }
            printX++;
        }


        return true;
    }

    private boolean canTurnRight() {
        return areThereBorderR() && areTherePieceR();
    }

    //-------------------------------------------------------------Poner pieza sobre el punto
    protected void printUnderPoint() {
        reset();

        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (piece.areTherePiece(printX, printY)) {
                    table[i][j] = 1;
                }
                printY++;
            }
            printX++;
        }
    }


    //----------------------------------------------------Bloquear pieza

    private void blockedPiece() {
        for (int i = 0; i < length_Of_X; i++) {
            for (int j = 0; j < length_Of_Y; j++) {
                if (table[i][j] == 1) {
                    table[i][j] = 2;
                }
            }
        }
        newPoint();
    }

    //-----------------------------------------------------------------Decision de movimiento
    public void movedPoint(char boton) {
        switch (boton) {
            case 'a' -> {
                if (canMovePointLeft() && canPutPieceLeft()) {
                    point.setY_coordenade(point.getY_coordenade() - 1);
                    printUnderPoint();
                }

            }
            case 's' -> {
                if (canMovePointDown() && canPutPiecedown()) {
                    point.setX_coordenade(point.getX_coordenade() + 1);
                    printUnderPoint();
                } else {
                    blockedPiece();

                }
            }
            case 'd' -> {
                if (canMovePointRight() && canPutPieceRight()) {
                    point.setY_coordenade(point.getY_coordenade() + 1);
                    printUnderPoint();
                }

            }
            case 'e' -> {
                if (canTurnRight()) {
                    piece.turnRight();
                    printUnderPoint();
                }
            }
            case 'q' -> {
                if (canTurnLeft()) {
                    piece.turnLeft();
                    printUnderPoint();
                }
            }
        }
    }

    //--------------------------------------------------------------Imprimir tabla
    public void printTable() {
        for (int[] ints : table) {
            for (int j = 0; j < length_Of_Y; j++) {
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
