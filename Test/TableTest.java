import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.BufferedPieces;
import pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    Table table;
    Point point;
    Piece piece;
    BufferedPieces bufferedPieces = new BufferedPieces();

    @BeforeEach
    void setUp() {
        table = new Table();
        point = new Point(1, 5);
    }

    @AfterEach
    void tearDown() {
    }
//--------------------------------------------------------------------------------PointTest
    @Test
    void PutPointIntoTable_return_True() {
        table.newPoint();
        boolean positionX = point.x_coordenade > 0 && point.x_coordenade < 12;
        boolean positionY = point.y_coordenade >= 0 && point.y_coordenade < 9;
        assertTrue(positionX && positionY);
    }

    @Test
    void PutPointOutOfTable_return_False() {
        table.newPoint();
        point.setY_coordenade(13);
        point.setX_coordenade(10);
        boolean positionX = point.x_coordenade > 0 && point.x_coordenade < 9;
        boolean positionY = point.y_coordenade >= 0 && point.y_coordenade < 12;
        assertFalse(positionX && positionY);
    }
    @Test
    void canMovePointOutOfTableY_Right_return_True() {
        table.newPoint();
        assertTrue(table.canMovePointRight());
    }
    @Test
    void canMovePointOutOfTableY_Right_return_False() {
        table.newPoint();
        table.point.setY_coordenade(11);
        assertFalse(table.canMovePointRight());
    }
    @Test
    void canMovePointOutOfTableY_Left_return_False() {
        table.newPoint();
        table.point.setY_coordenade(0);
        assertFalse(table.canMovePointLeft());
    }

    @Test
    void PutPointOutOfTable2_return_False() {
        table.newPoint();
        point.setY_coordenade(-1);
        point.setX_coordenade(-1);
        boolean positionX = point.x_coordenade > 0 && point.x_coordenade < 12;
        boolean positionY = point.y_coordenade >= 0 && point.y_coordenade < 9;
        assertFalse(positionX && positionY);
    }

    @Test
    void PutPieceOnTable_return_True() {
        table.newPoint();
        table.printUnderPoint();
        assertTrue(table.canPutPieceLeft() && table.canPutPieceRight() && table.canPutPiecedown());
    }

    @Test
    void areThereInTheBorderLeft_return_True() {
        table.newPoint();
        point.setX_coordenade(0);
        point.setY_coordenade(0);
        assertTrue(table.areThereBorderL());
    }

    @Test
    void areThereInTheBorderRight_return_True() {
        table.newPoint();
        point.setX_coordenade(9);
        point.setY_coordenade(12);
        assertTrue(table.areThereBorderR());
    }
}