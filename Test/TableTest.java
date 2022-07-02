import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.BufferedPieces;
import pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    Table table;
    BufferedPieces bufferedPieces;

    @BeforeEach
    void setUp() {
        table = new Table();
        bufferedPieces = new BufferedPieces();
    }

    @AfterEach
    void tearDown() {
    }

    //--------------------------------------------------------------------------------PointTest
    @Test
    void PutPointIntoTable_return_True() {
        table.newPoint();
        boolean positionX = table.point.getX_coordenade() > 0 && table.point.getX_coordenade() < table.length_Of_X;
        boolean positionY = table.point.getY_coordenade() >= 0 && table.point.getY_coordenade() < table.length_Of_Y;
        assertTrue(positionX && positionY);
    }

    @Test
    void PutPointOutOfTable_return_False() {
        table.newPoint();
        table.point.setY_coordenade(table.length_Of_Y);
        table.point.setX_coordenade(table.length_Of_X);
        boolean positionX = table.point.getX_coordenade() >= 0 && table.point.getX_coordenade() < table.length_Of_X;
        boolean positionY = table.point.getY_coordenade() >= 0 && table.point.getY_coordenade() < table.length_Of_Y;
        assertFalse(positionX && positionY);
    }

    @Test
    void PutPointOutOfTable2_return_False() {
        table.newPoint();
        table.point.setY_coordenade(-1);
        table.point.setX_coordenade(-1);
        boolean positionX = table.point.x_coordenade > 0 && table.point.x_coordenade < 12;
        boolean positionY = table.point.y_coordenade >= 0 && table.point.y_coordenade < 9;
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
        table.point.setY_coordenade(table.length_Of_Y - 1);
        assertFalse(table.canMovePointRight());
    }

    @Test
    void canMovePointOutOfTableY_Left_return_False() {
        table.newPoint();
        table.point.setY_coordenade(0);
        assertFalse(table.canMovePointLeft());
    }

    @Test
    void areThereInTheBorderLeft_return_True() {
        table.point.setY_coordenade(0);
        assertTrue(table.point.getY_coordenade() == 0);
    }

    @Test
    void areThereInTheBorderRight_return_True() {
        table.newPoint();
        table.point.setY_coordenade(table.length_Of_Y - 1);
        assertTrue(table.point.getY_coordenade() == table.length_Of_Y - 1);
    }

    @Test
    void areThereInTheBorderBottom_return_True() {
        table.newPoint();
        table.point.setX_coordenade(table.length_Of_X - 1);
        assertTrue(table.point.getX_coordenade() == table.length_Of_X - 1);
    }

    @Test
    void areThereInTheBorderBottom_return_False() {
        table.newPoint();
        assertFalse(table.point.getX_coordenade() == table.length_Of_X - 1);
    }

    //------------------------------------------------------------------------------------Pieces Tests
    @Test
    void PutPieceOnTable_return_True() {
        table.newPoint();
        table.printUnderPoint();
        assertTrue(table.canPutPieceLeft() && table.canPutPieceRight() && table.canPutPiecedown());
    }

    //---------------------------------------------------------------MovePiece right
    @Test
    void PutPieceOnTable_Right_return_True() {
        table.newPoint();
        table.printUnderPoint();
        assertTrue(table.canPutPieceRight());
    }

    @Test
    void PutPieceOnTable_RightBorder_return_False() {
        table.newPoint();
        table.printUnderPoint();
        assertFalse(table.pieceInRightBorder());
    }

    @Test
    void PutPieceOnTable_RightBorder_return_True() {
        table.newPoint();
        table.point.setY_coordenade(table.length_Of_Y - 1);
        table.point.setX_coordenade(1);
        table.printUnderPoint();
        assertTrue(table.pieceInRightBorder());
    }

    //---------------------------------------------------------------MovePiece Left
    @Test
    void PutPieceOnTable_Left_return_True() {
        table.newPoint();
        assertTrue(table.canPutPieceLeft());
    }

    @Test
    void PutPieceOnTable_LeftBorder_return_False() {
        table.newPoint();
        table.printUnderPoint();
        assertFalse(table.pieceInLeftBorder());
    }

    @Test
    void PutPieceOnTable_LeftBorder_return_True() {
        table.newPoint();
        table.point.setY_coordenade(1);
        table.point.setX_coordenade(1);
        table.printUnderPoint();
        assertTrue(table.pieceInLeftBorder());
    }

    //----------------------------------------------------------------MovePiece Down
    @Test
    void PutPieceOnTable_Bottom_return_True() {
        table.newPoint();
        assertTrue(table.canPutPiecedown());
    }

    @Test
    void PieceOnBottom_Bottom_return_True() {
        table.newPoint();
        table.point.setX_coordenade(table.length_Of_X - 2);     // piece L
        table.printUnderPoint();
        assertTrue(table.pieceInBotoom());
    }

    @Test
    void PieceOnBottom_Bottom_return_False() {
        table.newPoint();
        table.printUnderPoint();
        assertFalse(table.pieceInBotoom());
    }

    //----------------------------------------------------------------------Turn Piece
    //-----------------------------------------------------right
    @Test
    void canTurnPieceRight_return_true() {
        table.newPoint();
        table.printUnderPoint();
        assertTrue(table.canTurnRight());
    }

    @Test
    void canTurnPieceRight_return_False() {
        table.newPoint();
        table.point.setX_coordenade(1);
        table.point.setY_coordenade(table.length_Of_Y - 1);
        table.printUnderPoint();
        assertFalse(table.canTurnRight());
    }

    @Test
    void areTherePieceRight_return_False() {
        table.newPoint();
        table.printUnderPoint();
        assertFalse(table.areTherePieceR());
    }

    @Test
    void areThereOtherPieceRight_return_False() {
        table.newPoint();
        table.printUnderPoint();
        assertFalse(table.areTherePieceR());
    }

    @Test
    void areThereOtherPieceRight_return_True() {
        table.newPoint();
        table.table[6][11]=2;
        table.point.setX_coordenade(table.length_Of_X-2);
        table.point.setY_coordenade(table.length_Of_Y-2);
        table.printUnderPoint();
        assertTrue(table.areTherePieceR());
    }
    @Test
    void areThereBorderRight_return_True() {
        table.newPoint();
        table.point.setX_coordenade(table.length_Of_X-2);
        table.point.setY_coordenade(table.length_Of_Y-1);
        table.printUnderPoint();
        assertTrue(table.areThereBorderR());
    }
    @Test
    void areThereBorderRight_return_False() {
        table.newPoint();
        table.printUnderPoint();
        assertFalse(table.areThereBorderR());
    }

    //----------------------------------------------------left
@Test
void canTurnPieceLeft_return_true() {
    table.newPoint();
    table.printUnderPoint();
    assertTrue(table.canTurnLeft());
}

    @Test
    void canTurnPieceLeft_return_False() {

        table.newPoint();
        table.point.setX_coordenade(1);
        table.point.setY_coordenade(1);
        table.printUnderPoint();
        table.piece.turnLeft();
        table.piece.turnLeft();
        table.printUnderPoint();
        table.movedPoint('a');
        assertFalse(table.canTurnLeft());
    }

    @Test
    void areTherePieceLeft_return_False() {
        table.newPoint();
        table.printUnderPoint();
        assertFalse(table.areTherePieceL());
    }
}