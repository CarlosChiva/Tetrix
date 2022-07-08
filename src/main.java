
import Menu.GameWindow;
import Menu.MainWindow;

import javax.swing.*;

public class main {

    public static void main(String[] args) {
        /*TableManager tableManager = new TableManager();
        Scanner scn = new Scanner(System.in);
        char chos;
        tableManager.printTable();
        do {
            System.out.println("-------------------------");
            String chose = scn.next();
            String generalice=chose.toLowerCase(Locale.ROOT);
            char[] choose = generalice.toCharArray();
            chos = choose[0];
            tableManager.movedPoint(chos);
            tableManager.printTable();
        } while (chos != 0);
    */

      //  new MainWindow();
      /*  SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow=new MainWindow();
            }
        });
    */
        JFrame jFrame=new JFrame();

        GameWindow gameWindow=new GameWindow();
    jFrame.add(gameWindow);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    }
}
