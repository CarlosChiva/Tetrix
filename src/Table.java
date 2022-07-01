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

    public Table() {
        newPoint();

    }

    private void newPoint() {
        this.point = new Point(1, 5);
        newPiece();
    }

    private void newPiece() {
        piece = new Piece(bufferedPieces.getPiece());
    }

    private void reset() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1) {
                    table[i][j] = 0;
                }
            }
        }
    }

    //---------------------------------------Left
    private boolean canMovePointLeft() {
        return point.y_coordenade - 1 >= 0;
    }

    private boolean pieceInLeftBorder() {
        for (int[] ints : table) {
            if (ints[0] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean otherPieceInLeft() {
        for (int[] ints : table)
            for (int j = 0; j < table[0].length; j++) {
                if (ints[j] == 2 && ints[j + 1] == 1) {
                    return false;
                }
            }

        return true;
    }

    private boolean canPutPieceLeft() {
        return pieceInLeftBorder() && otherPieceInLeft();
    }

    //------------------------------------------------------------Right
    private boolean pieceInRightBorder() {
        int lend = table[0].length;
        for (int i = 0; i < table.length; i++) {
            if (table[i][lend - 1] == 1) {
                return false;
            }
        }

        return true;
    }

    private boolean otherPieceInRight() {
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1 && table[i][j + 1] == 2) {
                    return false;
                }
            }

        return true;
    }

    private boolean canPutPieceRight() {
        return pieceInRightBorder() && otherPieceInRight();
    }

    private boolean canMovePointRight() {
        return point.y_coordenade + 1 < table[0].length;
    }


    //--------------------------------------------------------------------------------------------Down
    private boolean pieceInBotoom() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1 && i == table.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean otherPieceDown() {
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1 && table[i + 1][j] == 2) {
                    return false;
                }
            }

        return true;
    }

    private boolean canPutPiecedown() {
        return pieceInBotoom() && otherPieceDown();
    }

    private boolean canMovePointDown() {
        return point.x_coordenade + 1 < table.length;
    }

    //----------------------------------------------------------------------------------Turn Piece
    //---------------------------------------------------------------------------TurnLeft
    private boolean areThereBorderL() {
        Piece aux = new Piece(bufferedPieces.getPiece());
        aux.turnLeft();
        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (j >= table[0].length || j <= 0 && aux.areTherePiece(printX, printY)) {
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
    private boolean areThereBorderR() {
        Piece aux = new Piece(bufferedPieces.getPiece());
        aux.turnRight();
        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (j >= table[0].length || j <= 0 && aux.areTherePiece(printX, printY)) {
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
    private void printUnderPoint() {
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
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
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
            for (int j = 0; j < table[0].length; j++) {
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
