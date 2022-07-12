
import Menu.GameWindow;
import Menu.RankingWindows;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
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
        GameWindow gameWindow =new GameWindow();

    
    }
}
