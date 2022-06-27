
import pieces.T;

//0 empty
//1 point
//1 piece
//2 piece blocked
public class Table {
    int[][] table = new int[9][12];
    Point point = new Point(1, 5);
    T piece = new T();

    public Table() {
        putPoint();
    }


    private void putPoint() {
        reset();
        table[point.x_coordenade][point.y_coordenade] = 1;
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

    private void printUnderPoint() {
        reset();
        int printX = 0;
        for (int i = point.x_coordenade - 1; i <= point.x_coordenade + 1; i++) {
            int printY = 0;
            for (int j = point.y_coordenade - 1; j <= point.y_coordenade + 1; j++) {
                table[i][j] = piece.areTherePiece(printX, printY) ? 1 : 0;
                printY++;
            }
            printX++;
        }
    }

    public void movedPoint(char boton) {
        switch (boton) {
            case 'a' -> {
                point.setY_coordenade(point.getY_coordenade() - 1);
                putPoint();
                printUnderPoint();
            }
            case 's' -> {
                point.setX_coordenade(point.getX_coordenade() + 1);
                putPoint();
                printUnderPoint();
            }
            case 'd' -> {
                point.setY_coordenade(point.getY_coordenade() + 1);
                putPoint();
                printUnderPoint();
            }
        }
    }

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
