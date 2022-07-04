import Table.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.L;
import pieces.Piece;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    Table table;
    L ele=new L();
    @BeforeEach
    void setUp() {
    table=new Table(new Piece(ele));

    }

    @AfterEach
    void tearDown() {
    }
@Test
    void xLength(){
        assertTrue(table.getLength_Of_X()==9);
}

    @Test
    void yLength(){
        assertTrue(table.getLength_Of_Y()==12);
    }
    @Test
    void reset(){
        boolean boolen=true;
        table.reset();
        for(int i=0;i<table.getLength_Of_X();i++){
          for(int j=0;j<table.getLength_Of_Y();j++){
              if (table.valueInTableOf(i,j)==1){
                  boolen=false;
              }
          }}
        assertTrue(boolen);
    }

    @Test
    void reset_return_False(){
        boolean boolen=true;

        for(int i=0;i<table.getLength_Of_X();i++){
            for(int j=0;j<table.getLength_Of_Y();j++){
                if (table.valueInTableOf(i,j)==1){
                    boolen=false;
                }
            }}
        assertFalse(boolen);
    }

    @Test
    void setTable(){
        table.setTable(5,5,1);
        assertTrue(table.valueInTableOf(5,5)==1);
    }

}