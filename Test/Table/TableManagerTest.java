package Table;

import Game.pieces.Pieces.T;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Enum.Enum.*;
import static org.junit.jupiter.api.Assertions.*;

class TableManagerTest {
    TableManagerMock tableManager;
    T pieze = new T();
    Piece piece = new Piece(pieze);

    @BeforeEach
    void setUp() {
        tableManager = new TableManagerMock(piece);
    }

    @Test
    void point_moveRight_return_True() {
        assertTrue(tableManager.canMovePoint(RIGHT));
    }

    @Test
    void point_moveRight_return_False() {
        tableManager.point.setX_coordenade(tableManager.table.getLength_Of_X() - 1);
        tableManager.point.setY_coordenade(tableManager.table.getLength_Of_Y() - 1);
        assertFalse(tableManager.canMovePoint(RIGHT));
    }

    @Test
    void point_moveLeft_return_True() {
        assertTrue(tableManager.canMovePoint(LEFT));
    }

    @Test
    void point_moveLeft_return_False() {
        tableManager.point.setX_coordenade(tableManager.table.getLength_Of_X() - 1);
        tableManager.point.setY_coordenade(0);
        assertFalse(tableManager.canMovePoint(LEFT));
    }

    @Test
    void point_moveDown_return_True() {
        assertTrue(tableManager.canMovePoint(DOWN));
    }

    @Test
    void point_moveDown_return_False() {
        tableManager.point.setX_coordenade(tableManager.table.getLength_Of_X() - 1);
        assertFalse(tableManager.canMovePoint(DOWN));
    }

    @Test
    void pieceInBorder_Right_return_True() {
        tableManager.point.setY_coordenade(tableManager.table.getLength_Of_Y() - 2);
        tableManager.table.putPoint(tableManager.point);
        tableManager.table.printUnderPoint(tableManager.piece);
        assertTrue(tableManager.pieceInBorder(RIGHT));
    }

    @Test
    void pieceInBorder_Right_return_False() {
        assertFalse(tableManager.pieceInBorder(RIGHT));
    }

    @Test
    void pieceInBorder_Left_return_True() {
        tableManager.point.setY_coordenade(1);
        tableManager.table.putPoint(tableManager.point);
        tableManager.table.printUnderPoint(tableManager.piece);
        assertTrue(tableManager.pieceInBorder(LEFT));
    }

    @Test
    void pieceInBorder_Left_return_False() {
        assertFalse(tableManager.pieceInBorder(LEFT));
    }

    @Test
    void otherPieceIn_Right_return_True() {

        tableManager.table.setTable(tableManager.point.getX_coordenade(), tableManager.point.getY_coordenade()+1,  BLOCKEDPIECE);
        assertTrue(tableManager.otherPiece(RIGHT));
    }

    @Test
    void otherPieceIn_Right_return_False() {

        assertFalse(tableManager.otherPiece(RIGHT));
    }

    @Test
    void otherPieceIn_Left_return_True() {
        tableManager.table.setTable(tableManager.point.getX_coordenade(),tableManager.point.getY_coordenade()-1 , BLOCKEDPIECE);
        assertTrue(tableManager.otherPiece(LEFT));
    }

    @Test
    void otherPieceIn_Left_return_False() {
        assertFalse(tableManager.otherPiece(LEFT));
    }

    @Test
    void PieceInBottom_return_True() {
        tableManager.point.setX_coordenade(tableManager.table.getLength_Of_X() - 1);
        tableManager.table.putPoint(tableManager.point);
        tableManager.table.printUnderPoint(tableManager.piece);
        assertTrue(tableManager.pieceInBotoom());
    }

    @Test
    void PieceInBottom_return_False() {
        assertFalse(tableManager.pieceInBotoom());
    }
    @Test
    void otherPieceDown_return_True() {
        tableManager.table.setTable(tableManager.point.getX_coordenade()+1,tableManager.point.getY_coordenade(), BLOCKEDPIECE);

        assertTrue(tableManager.otherPieceDown());
    }
    @Test
    void otherPieceDown_return_False() {
        assertFalse(tableManager.otherPieceDown());
    }
    @Test
    void AreTherePieceRight_return_True() {
        tableManager.table.setTable(tableManager.point.getX_coordenade(),tableManager.point.getY_coordenade()+1, BLOCKEDPIECE);


        assertTrue(tableManager.areTherePiece(TURNRIGHT));
    }
    @Test
    void AreTherePieceRight_return_False() {
        assertFalse(tableManager.areTherePiece(TURNRIGHT));
    }
    @Test
    void AreTherePieceLeft_return_True() {
        tableManager.table.setTable(tableManager.point.getX_coordenade(),tableManager.point.getY_coordenade()-1, BLOCKEDPIECE);
        assertTrue(tableManager.areTherePiece(TURNLEFT));
    }

    @Test
    void AreTherePieceLeft_return_False() {
        assertFalse(tableManager.areTherePiece(TURNLEFT));
    }

    @Test
    void outOfTableAtTurn_Right_return_True() {
        tableManager.piece.turnLeft();
        tableManager.point.setY_coordenade(tableManager.table.getLength_Of_Y()-1);
        tableManager.table.putPoint(tableManager.point);
        tableManager.table.printUnderPoint(piece);
        assertTrue(tableManager.areThereBorder());
    }
    @Test
    void outOfTableAtTurn_Right_return_False() {
        assertFalse(tableManager.areThereBorder());
    }
    @Test
    void outOfTableAtTurn_Left_return_False() {
        assertFalse(tableManager.areThereBorder());
    }
    @Test
    void outOfTableAtTurn_Left_return_True() {
        tableManager.piece.turnRight();
        tableManager.point.setY_coordenade(0);
        tableManager.table.putPoint(tableManager.point);
        tableManager.table.printUnderPoint(piece);
        assertTrue(tableManager.areThereBorder());
    }

    @Test
    void rowsFill_return_True() {
        for (int i=0;i<tableManager.table.getLength_Of_Y();i++){
        tableManager.table.setTable(1,i,BLOCKEDPIECE);}
        assertTrue(tableManager.rowsFill());
    }
    @Test
    void rowsFill_return_False() {
        assertFalse(tableManager.rowsFill());
    }
}