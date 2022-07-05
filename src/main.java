import Menu.Menu;
import Table.TableManager;

import java.util.Locale;
import java.util.Scanner;

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

        Menu menu=new Menu();
        menu.setVisible(true);
    }
}
