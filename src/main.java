import pieces.T;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Table table = new Table();
        table.printTable();
        Scanner scn = new Scanner(System.in);
        char chos;
        do {
            String chose = scn.next();
            char[] choose = chose.toCharArray();
            chos = choose[0];
            System.out.println("-------------------------");
            table.movedPoint(chos);
            table.printTable();
//if (table.finalMove()){

//}
        } while (chos != 0);
    }
}
