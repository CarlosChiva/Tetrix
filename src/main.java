import pieces.T;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Table table = new Table();
        table.printTable();
        Scanner scn = new Scanner(System.in);
        char chos;
    /*  T piece=new T();
      piece.print();
      piece.turnRight();
        System.out.println("-----right-----");
      piece.print();
        piece.turnLeft();
        System.out.println("-------left---");
        piece.print();
        piece.turnLeft();
        System.out.println("---------left-");
        piece.print();
      */
        do {
            String chose = scn.next();
            char[] choose = chose.toCharArray();
            chos = choose[0];
            System.out.println("-------------------------");
            table.movedPoint(chos);
            table.printTable();

        } while (chos != 0);
    }
}
