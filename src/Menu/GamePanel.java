package Menu;

import Table.TableManager;
import java.awt.*;
import javax.swing.JPanel;
import static Enum.Enum.*;

public class GamePanel extends JPanel {

    TableManager tableManager;
    int cuadrado = 25;
    public GamePanel() {
        tableManager = new TableManager();
        setPreferredSize(new Dimension(250, 200));
        setVisible(true);


    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i <= tableManager.table.getLength_Of_X(); i++) {
            g.drawLine(0, i * cuadrado, tableManager.table.getLength_Of_Y() * cuadrado, i * cuadrado);
        }
            for (int j = 0; j <= tableManager.table.getLength_Of_Y(); j++) {
                g.drawLine(j * cuadrado, 0, j * cuadrado, tableManager.table.getLength_Of_X() * cuadrado);
            }
            for (int x=0;x<tableManager.table.getLength_Of_X();x++){
                for (int c=0;c<tableManager.table.getLength_Of_Y();c++){
                    if (tableManager.table.valueInTableOf(x,c)==EMPTY){
                        g.setColor(Color.GRAY);
                        g.fillRect(c*cuadrado,x*cuadrado,cuadrado-1,cuadrado-1);
                    }if (tableManager.table.valueInTableOf(x,c)==CURRENTPIECE){
                        g.setColor(Color.RED);
                        g.fillRect(c*cuadrado,x*cuadrado,cuadrado-1,cuadrado-1);
                    }if (tableManager.table.valueInTableOf(x,c)==BLOCKEDPIECE){
                        g.setColor(Color.BLACK);
                        g.fillRect(c*cuadrado,x*cuadrado,cuadrado-1,cuadrado-1);
                    }
                }
            }

    }

}
