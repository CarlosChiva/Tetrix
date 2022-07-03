
import Table.TableManager;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TableManager tableManager = new TableManager();
        Scanner scn = new Scanner(System.in);
        char chos;
        tableManager.printTable();
        do {
            System.out.println("-------------------------");

            String chose = scn.next();
            char[] choose = chose.toCharArray();
            chos = choose[0];
            tableManager.movedPoint(chos);
            tableManager.printTable();


//}
        } while (chos != 0);
    }
}
