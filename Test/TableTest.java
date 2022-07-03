import Table.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pieces.L;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    Table table;
    L ele=new L();
    @BeforeEach
    void setUp() {
    table=new Table(ele);

    }

    @AfterEach
    void tearDown() {
    }

}