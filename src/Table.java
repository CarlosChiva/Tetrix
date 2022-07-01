import pieces.BufferedPieces;
import pieces.Piece;
import pieces.T;

//0 empty
//1 point
//1 piece
//2 piece blocked
public class Table {
    int[][] table = new int[9][12];
    Point point;
    BufferedPieces bufferedPieces= new BufferedPieces();
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

    private boolean canPutPieceLeft() {
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] == 1) {
                return false;
            }
        }
        return true;
    }

    //------------------------------------------------------------Right

    private boolean canPutPieceRight() {
        int lend = table[0].length;
        for (int i = 0; i < table.length; i++) {
            if (table[i][lend - 1] == 1) {
                return false;
            }

        }
        return true;

    }

    private boolean canMovePointRight() {
        return point.y_coordenade + 1 < table[0].length;
    }


    //--------------------------------------------------------------------------------------------Down

    private boolean canMovePointDown() {
        return point.x_coordenade + 1 < table.length;
    }

    private boolean canPutPieceDown() {
        int lend = table.length - 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1 && i == table.length - 1) {
                    return false;
                }
            }
        }
        return true;

    }

    //----------------------------------------------------------------------------------Turn Piece
    /*private boolean canTurnRight(){
        int[][] aux=new int[3][3];

    }*/
    //-------------------------------------------------------------Poner pieza sobre el punto
    private void printUnderPoint() {
        reset();

        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (j < table[0].length && j >= 0 && i < table.length) {
                    table[i][j] = piece.areTherePiece(printX, printY) ? 1 : 0;
                } else {
                    break;
                }
                printY++;
            }
            printX++;
        }
    }

    //--------------------------------------------------------------Poner punto
    private void printPoint() {
        reset();
        table[point.x_coordenade][point.y_coordenade] = 1;
    }

    //----------------------------------------------------Bloquear pieza
    private boolean canBlockedPiece() {
        int lend = table.length;
        for (int i = 0; i < table.length; i++) {
            if (table[lend][i] == 1) {
                return true;
            }

        }
        return true;

    }

    private void bloquePiece() {
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
                    printPoint();
                    printUnderPoint();
                }

            }
            case 's' -> {
                if (canMovePointDown() && canPutPieceDown()) {
                    point.setX_coordenade(point.getX_coordenade() + 1);
                    printPoint();
                    printUnderPoint();
                } else {
                    bloquePiece();

                }
            }
            case 'd' -> {
                if (canMovePointRight() && canPutPieceRight()) {
                    point.setY_coordenade(point.getY_coordenade() + 1);
                    printPoint();
                    printUnderPoint();
                }

            }
            case 'e' -> {
                //if (canTurnRight()) {
                // }

            }
            case 'q' -> {
            }
        }
    }

    //--------------------------------------------------------------Imprimir tabla
    public void printTable() {
        for (int[] ints : table) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(ints[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
