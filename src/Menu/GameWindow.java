package Menu;

import Table.TableManager;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.*;

import static Enum.Enum.CURRENTPIECE;
import static Enum.Enum.EMPTY;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GameWindow extends JPanel {
    JFrame jFrame = new JFrame();
    TableManager tableManager;
    int cuadrado = 25;
    public GameWindow() {

        tableManager = new TableManager();
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(250, 200));
        jFrame.setResizable(false);
        jFrame.add(this);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        setVisible(true);
        jFrame.add(this);
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

/*
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 12; j++) {
                if (tableManager.table.valueInTableOf(i, j) == CURRENTPIECE) {
                    g.fillRect(i * cuadrado, j * cuadrado, this.getWidth() * cuadrado, this.getHeight() * cuadrado);
                }
            }
        }
*/
    }

    /*
    public void refresh() {
        int x = 0;
        for (int i = 0; i < heightPanel; i += heightPanel) {
            int y = 0;
            for (int j = 0; j < withPanel; j += withPanel) {
                if (tableManager.table.valueInTableOf(x, y) == EMPTY) {

                }

            }
        }
    }

    public void paint(Graphics g, int x, int y) {
        super.paint(g);
        g.setColor(Color.CYAN);
        g.fillRect(x + 1, y + 1, anchoCuadrado, altoCuadrado);
    }

*/
}
