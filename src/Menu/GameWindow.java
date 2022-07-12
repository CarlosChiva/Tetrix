package Menu;

import Table.TableManager;

import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import static Enum.Enum.EMPTY;


public class GameWindow extends JPanel {

    TableManager tableManager;
    int cuadrado = 25;
    public GameWindow() {
        tableManager = new TableManager();
        setPreferredSize(new Dimension(250, 200));
        setVisible(true);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i <= 9; i++) {
            g.drawLine(0, i * cuadrado, 12 * cuadrado, i * cuadrado);
        }
            for (int j = 0; j <= 12; j++) {
                g.drawLine(j * cuadrado, 0, j * cuadrado, 9 * cuadrado);
            }
            for (int x=0;x<9;x++){
                for (int c=0;c<12;c++){
                    if (tableManager.table.valueInTableOf(x,c)==EMPTY){
                        g.fillRect(c*cuadrado,x*cuadrado,cuadrado-1,cuadrado-1);
                    }
                }
            }

    }

}
