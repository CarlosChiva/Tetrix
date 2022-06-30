import pieces.T;

//0 empty
//1 point
//1 piece
//2 piece blocked
public class Table {
    int[][] table = new int[9][12];
    Point point;
    T piece = new T();

    public Table() {
        point = new Point(1, 5);
    }

    private boolean canMovePointLeft() {
        return point.y_coordenade - 1 >= 0;
    }

//--------------------------------------------------------------------------------------------Tope del punto
    private boolean canMovePointRight() {
        return point.y_coordenade + 1 < table[0].length;
    }

    private boolean canMovePointDown() {
        return point.x_coordenade + 1 < table.length;
    }

//------------------------------------------------------------topePieza
    private boolean canPutPieceLeft() {
        for (int i = 0; i < table.length; i++) {
            if (table[i][0] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean canPutPieceRight() {
        int lend = table[0].length;
        for (int i = 0; i < table.length; i++) {
            if (table[i][lend - 1] == 1) {
                return false;
            }

        }
        return true;

    }

    private void reset() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 2 || table[i][j] == 1) {
                    table[i][j] = 0;
                }
            }
        }
    }

//-------------------------------------------------------------Poner pieza sobre el punto
    private void printUnderPoint() {
        reset();

        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                if (j < table[0].length && j >= 0) {
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
                if (canMovePointDown()) {
                    point.setX_coordenade(point.getX_coordenade() + 1);

                }
                printPoint();
                printUnderPoint();
            }
            case 'd' -> {
                if (canMovePointRight() && canPutPieceRight()) {
                    point.setY_coordenade(point.getY_coordenade() + 1);
                    printPoint();
                    printUnderPoint();
                }


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
